package ru.gb.lesson2.hw;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;
import java.util.Date;
import java.util.TimeZone;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class ObjectCreator {

   // обработка аннотации
   public static class RandomAnnotationProcessor {

      // установка возраста для класса Person
      public static void setAgePerson(Object obj, Date birthDate, String zone) {
         if (!(obj instanceof Person)) return ;
         for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.getName().equals("age") && field.getType().isAssignableFrom(int.class)) {
               ZoneId zoneId = ZoneId.of(zone);
               LocalDate ldate = birthDate.toInstant().atZone(zoneId).toLocalDate();
               LocalDate currentDate = LocalDate.now();
               Period period = Period.between(ldate, currentDate);
               int years = period.getYears();
               try {
                  field.setAccessible(true);
                  field.set(obj, years);
               } catch (IllegalAccessException e) {
                  System.err.println("Не удалось вставить значение в поле: " + e.getMessage());
               }
            }
         }
      }

      public static void processAnnotation(Object obj) {
         java.util.Random random = new java.util.Random();
         Class<?> objClass = obj.getClass();

         // получаем все внутренние поля объекта
         for (Field field : objClass.getDeclaredFields()) {
            // обработка аннотации @Random
            if (field.isAnnotationPresent(Random.class) && field.getType().isAssignableFrom(int.class)) {
               Random annotation = field.getAnnotation(Random.class);
               int min = annotation.min();
               int max = annotation.max();

               try {
                  field.setAccessible(true); // чтобы можно было изменять финальные поля
                  field.set(obj, random.nextInt(min, max));
               } catch (IllegalAccessException e) {
                  System.err.println("Не удалось вставить значение в поле: " + e.getMessage());
               }
            }

            // обработка аннотации @RandomDate
            if (field.isAnnotationPresent(RandomDate.class)) {
               RandomDate annotation = field.getAnnotation(RandomDate.class);
               long min = annotation.min();
               long max = annotation.max();
               String zone = annotation.zone();

               try {
                  if (min > max) throw new IllegalAccessException("Error: min > max");
                  Date date = new Date(random.nextLong(min, max));
                  TimeZone timeZone = TimeZone.getTimeZone(zone);
                  date.setTime(date.getTime() + timeZone.getOffset(date.getTime()));

                  field.setAccessible(true);
                  // поддержка типов Date, Instant, LocalDate, LocalDateTime
                  if (field.getType().isAssignableFrom(Date.class)) field.set(obj, date);
                  else if (field.getType().isAssignableFrom(Instant.class)) field.set(obj, date.toInstant());
                  else if (field.getType().isAssignableFrom(LocalDate.class)) field.set(obj, date.toInstant().atZone(ZoneId.of(zone)).toLocalDate());
                  else if (field.getType().isAssignableFrom(LocalDateTime.class)) field.set(obj, date.toInstant().atZone(ZoneId.of(zone)).toLocalDateTime());
                  else return ;

                  if (field.getName().equals("birthDate") && field.getType().isAssignableFrom(Date.class)) setAgePerson(obj, date, zone);
               } catch (IllegalAccessException e) {
                  System.err.println("Не удалось вставить значение в поле: " + e.getMessage());
               }
            }
         }
      }

   }

   @Retention(RetentionPolicy.RUNTIME)
   @Target(ElementType.FIELD)
   @interface Random {
      int min() default 0;
      int max() default 100;
   }

   @Retention(RetentionPolicy.RUNTIME)
   @Target(ElementType.FIELD)
   @interface RandomDate {
      long min() default 0L; // 1 января 1970 года UTC0
      long max() default 1735689600000L; // 1 января 2025 года UTC0
      String zone() default "Europe/Moscow";
   }

   public static <T> T createObj(Class<T> tClass) {
      try {
         Constructor<T> constructor = tClass.getDeclaredConstructor();
         T obj = constructor.newInstance();
         RandomAnnotationProcessor.processAnnotation(obj);
         return obj;
      } catch (Exception e) {
         System.err.println("Ошибка: " + e.getMessage());
         return null;
      }
   }

   public static <T> T createObj(Class<T> tClass, Object args) {
      try {
         T obj = tClass.getConstructor(args.getClass()).newInstance(args);
         RandomAnnotationProcessor.processAnnotation(obj);
         return obj;
      } catch (Exception e) {
         System.err.println("Ошибка: " + e.getMessage());
         return null;
      }
   }

   public static class Person {
      private String name;
      @RandomDate
      private Date birthDate;
      @RandomDate
      private Instant workExperienceBegin;
      @RandomDate
      private LocalDate dateEndingOfSchool;
      @RandomDate
      private LocalDateTime dateWedding;

      private int age;
      @Random(min=50)
      private int weight;

      public Person(String name) { this.name = name; }

      public Person() {this("noname");}

      @Override
      public String toString() {
         DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
         LocalDateTime ldtBirthDate = birthDate.toInstant().atZone(ZoneId.of("Europe/Moscow")).toLocalDateTime();
         String formattedBirthDate = ldtBirthDate.format(formatterDate);
         LocalDateTime ldtWorkExperienceBegin = workExperienceBegin.atZone(ZoneId.of("Europe/Moscow")).toLocalDateTime();
         String formattedWorkExperienceBegin = ldtWorkExperienceBegin.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
         LocalDateTime ldtDateEndingOfSchool = dateEndingOfSchool.atStartOfDay();
         String formattedDateEndingOfSchool = ldtDateEndingOfSchool.format(formatterDate);
         String formattedDateWedding = dateWedding.format(formatterDate);

         return "Имя: \"" + name +
            "\", возраст: " + age + 
            ", вес:" + weight +
            "\nдата рождения: " + formattedBirthDate +
            "\nдата начала работы: " + formattedWorkExperienceBegin +
            "\nдата окончания школы: " + formattedDateEndingOfSchool +
            "\nдата свадьбы: " + formattedDateWedding;
      }
   }

   public static void main(String[] args) {
      Person obj = createObj(Person.class);
      System.out.println(obj);
      
      System.out.println();

      Person obj2 = createObj(Person.class, "Vasya");
      System.out.println(obj2);
   }
}
