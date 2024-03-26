/**
 * Класс вакансии
 */
public class Vacancy {
    private JobType jobType;
    private String companyName;
    private int salary;

    public Vacancy(JobType jobType, String companyName, int salary) {
        this.jobType = jobType;
        this.companyName = companyName;
        this.salary = salary;
    }

    public JobType getJobType() {
        return jobType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Вакансия [Должность=" + jobType + ", оклад=" + salary + ", Компания=" + companyName + "]";
    }

}
