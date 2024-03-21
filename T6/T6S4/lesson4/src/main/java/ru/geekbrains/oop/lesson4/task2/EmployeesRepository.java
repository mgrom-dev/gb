package ru.geekbrains.oop.lesson4.task2;

import java.util.List;

public interface EmployeesRepository extends Repository<Employee>{

    List<Employee> getByDepartmentId(int departmentId);

}
