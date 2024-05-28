package home;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonalBook personalBook = new PersonalBook();

        // Добавление сотрудников
        personalBook.addPersonal("+7-123-456-7890", "Иван", 5);
        personalBook.addPersonal("+7-987-654-3210", "Анна", 3);
        personalBook.addPersonal("+7-555-555-5555", "Елена", 10);
        personalBook.addPersonal("+7-123-456-7891", "Максим", 2);
        personalBook.addPersonal("+7-987-654-3211", "Алексей", 8);
        personalBook.addPersonal("+7-555-555-5556", "Елена", 7);
        personalBook.addPersonal("+7-123-456-7892", "Дмитрий", 1);
        personalBook.addPersonal("+7-987-654-3212", "Ольга", 6);
        personalBook.addPersonal("+7-555-555-5557", "Сергей", 12);
        personalBook.addPersonal("+7-123-456-7893", "Андрей", 4);
        personalBook.addPersonal("+7-987-654-3213", "Михаил", 9);
        personalBook.addPersonal("+7-555-555-5558", "Ирина", 3);
        personalBook.addPersonal("+7-123-456-7894", "Андрей", 5);
        personalBook.addPersonal("+7-987-654-3214", "Татьяна", 11);
        personalBook.addPersonal("+7-555-555-5559", "Юрий", 2);
        personalBook.addPersonal("+7-123-456-7895", "Екатерина", 7);
        personalBook.addPersonal("+7-987-654-3215", "Роман", 6);
        personalBook.addPersonal("+7-555-555-5560", "Полина", 4);
        personalBook.addPersonal("+7-123-456-7896", "Владимир", 8);
        personalBook.addPersonal("+7-987-654-3216", "Иван", 5);

        // Поиск сотрудников по стажу
        List<Personal> personalTenYearsOldExp = personalBook.findPersonalByExperience(10);
        System.out.println("Сотрудники со стажем 10 лет: " + personalTenYearsOldExp);

        // Получение номеров телефонов по имени
        List<String> phoneNumbersByNameIvan = personalBook.getPhoneNumbersByName("Иван");
        System.out.println("Телефонные номера Иванов: " + phoneNumbersByNameIvan);

        // Поиск сотрудника по табельному номеру
        Personal personal = personalBook.findPersonalById(2);
        System.out.println("Сотрудник с табельным номером 2: " + personal);
    }
}
