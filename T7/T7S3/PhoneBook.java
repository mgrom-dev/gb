
/**
 * Напишите приложение, которое будет запрашивать у пользователя следующие
 * данные, разделенные пробелом:
 * Фамилия Имя Отчество дата _ рождения номер _ телефона пол
 * 
 * Форматы данных:
 * фамилия, имя, отчество - строки
 * дата _ рождения - строка формата dd.mm.yyyy
 * номер _ телефона - целое беззнаковое число без форматирования
 * пол - символ латиницей f или m.
 * 
 * Приложение должно проверить введенные данные по количеству. Если количество
 * не совпадает, вернуть код ошибки, обработать его и показать пользователю
 * сообщение, что он ввел меньше и больше данных, чем требуется.
 * 
 * Приложение должно распарсить полученную строку и выделить из них требуемые
 * значения. Если форматы данных не совпадают, нужно бросить исключение,
 * соответствующее типу проблемы. Можно использовать встроенные типы java и
 * создать свои. Исключение должно быть корректно обработано, пользователю
 * выведено сообщение с информацией, что именно неверно.
 * 
 * Если всё введено и обработано верно, должен создаться файл с названием,
 * равным фамилии, в него в одну строку должны записаться полученные данные,
 * вида
 * <Фамилия> <Имя> <Отчество> <дата _ рождения> <номер _ телефона> <пол>
 * 
 * Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
 * Не забудьте закрыть соединение с файлом.
 * При возникновении проблемы с чтением-записью в файл, исключение должно быть
 * корректно обработано, пользователь должен увидеть стектрейс ошибки.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/** Данные о записи в справочнике */
class Record {
    private String family;
    private String name;
    private String surname;
    private Date birthday;
    private long number;
    private char gender;

    private Record(String family, String name, String surname, Date birthday, long number, char gender) {
        this.family = family;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.number = number;
        this.gender = gender;
    }

    /**
     * Парсим строку в формате:
     * Фамилия Имя Отчество дата_рождения номер_телефона пол
     * 
     * @param line - строка с данными разделенные пробелом
     * @return - возвращает новый объект записи
     */
    public static Record parse(String line) throws IllegalArgumentException {
        String[] parts = line.split("\\s+");
        if (parts.length != 6)
            throw new IllegalArgumentException("Неверное количество данных в строке: " + line
                    + ". Нужно передать 6 аргументов в строке разделенных пробелами.");

        String family, name, surname;
        family = name = surname = null;
        Date birthday = null;
        char gender = '\0';
        long number = 0;

        for (String part : parts) {
            if (family == null && isPartOfName(part))
                family = part;
            else if (name == null && isPartOfName(part))
                name = part;
            else if (surname == null && isPartOfName(part))
                surname = part;
            else if (gender == '\0' && part.length() == 1 && (part.charAt(0) == 'f' || part.charAt(0) == 'm'))
                gender = part.charAt(0);
            else if (birthday == null && isDate(part))
                try {
                    birthday = new SimpleDateFormat("dd.MM.yyyy").parse(part);
                } catch (ParseException e) {
                    throw new IllegalArgumentException("Ошибка, не верная дата: " + part);
                }
            else if (number == 0 && isNumber(part) && part.length() > 5 && part.length() < 15) {
                number = Long.parseLong(part);
            } else
                throw new IllegalArgumentException("Неверный аргумент строки: " + part);
        }

        return new Record(family, name, surname, birthday, number, gender);
    }

    /**
     * Проверяет является ли строка числом
     * 
     * @param str - строка
     * @return - возвращает true, если строка является числом
     */
    private static boolean isNumber(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

    /**
     * Провяряет является ли строка частью даты
     * Формат даты: dd.mm.yyyy
     * 
     * @param str - строка
     * @return - возвращает true, если строка является частью даты
     */
    private static boolean isDate(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c) && c != '.')
                return false;
        }

        String[] parts = str.split("\\.");
        if (parts.length != 3)
            return false;
        if (parts[0].length() != 2 || parts[1].length() != 2 || parts[2].length() != 4)
            return false;

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        if (day < 1 || day > 31)
            return false;
        if (month < 1 || month > 12)
            return false;
        if (year < 1000 || year > 9999)
            return false;

        return true;
    }

    /**
     * Проверяет является ли строка частью имени
     * (Длина строки больше 1 и все символы строки - буквы)
     * 
     * @param str - строка
     * @return - возвращает true, если строка является частью имени
     */
    private static boolean isPartOfName(String str) {
        if (str.length() < 2)
            return false;
        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c))
                return false;
        }

        return true;
    }

    public String getFamily() {
        return family;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public long getNumber() {
        return number;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return family + " " + name + " " + surname + " "
                + new SimpleDateFormat("dd.MM.yyyy").format(birthday) + " "
                + number + " " + gender + "\n";
    }
}

public class PhoneBook {
    public static void main(String[] args) {
        System.out.println(
                "Введите данные для записи в справочник, в формате: Ф И О дд.мм.гггг номер_телефона пол(f/m).");
        System.out.println("Для выхода введите 'q'.");
        try (Scanner scan = new Scanner(System.in)) {
            String line;
            while (!(line = scan.nextLine()).toLowerCase().equals("q")) {
                try {
                    Record record = Record.parse(line);
                    try (FileWriter writer = new FileWriter(record.getFamily() + ".txt", true)) {
                        writer.write(record + "");
                    }
                } catch (IllegalArgumentException | IOException ex) {
                    ex.printStackTrace();
                }
                System.out.println("Введите следующую запись, или 'q' для выхода:");
            }
        }
    }
}
