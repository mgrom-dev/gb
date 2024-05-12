package ru.home;

public class Customer {
    String name;
    int age;
    String phone;
    Gender gender;

    public Customer(String name, int age, String phone, Gender gender) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + '\'' + ", age=" + age + ", phone='" + phone + "', gender='" + gender + "'}";
    }
}
