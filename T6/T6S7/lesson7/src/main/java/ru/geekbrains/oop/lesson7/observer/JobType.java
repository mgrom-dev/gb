/**
 * Типы вакансии
 */
public enum JobType {
    STUDENT("Студент"),
    INTERN("Стажер"),
    JAVA_DEVELOPER("Разработчик Java"),
    PYTHON_DEVELOPER("Разработчик Python"),
    DATABASE_ENGINEER("Инженер баз данных"),
    C_DEVELOPER("Разработчик C"),
    SYSTEM_ADMINISTRATOR("Системный администратор"),
    SYSTEM_ANALYST("Системный аналитик"),
    PROJECT_MANAGER("Проектный менеджер"),
    TESTER("Тестировщик");

    private final String name;

    JobType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
