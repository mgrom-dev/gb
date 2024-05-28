package home;

import java.util.ArrayList;
import java.util.List;

public class PersonalBook {
    private final List<Personal> personals;
    private int tabelNumber;

    public PersonalBook() {
        this.personals = new ArrayList<>();
        tabelNumber = 0;
    }

    // Добавление нового сотрудника в справочник
    public void addPersonal(String phoneNumber, String name, int experience) {
        personals.add(new Personal(++tabelNumber, phoneNumber, name, experience));
    }

    // Поиск сотрудника по стажу
    public List<Personal> findPersonalByExperience(int experience) {
        return personals.stream().filter(p -> p.experience() >= experience).toList();
    }

    // Получение номеров телефонов сотрудников по имени
    public List<String> getPhoneNumbersByName(String name) {
        return personals.stream().filter(p -> p.name().equalsIgnoreCase(name)).map(Personal::phoneNumber).toList();
    }

    // Поиск сотрудника по табельному номеру
    public Personal findPersonalById(int id) {
        return personals.stream().filter(p -> p.id() == id).findFirst().orElse(null);
    }
}