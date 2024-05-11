package ru.home;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class EmployeeTest {
    @Test
    void testIncreaseSalary() {
        Employee employee = new Employee(200, "David", LocalDate.of(2022, 2, 1));
        Employee.increaseSalary(employee, 200);
        assertEquals(400, employee.getSalary());
    }
}
