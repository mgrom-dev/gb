import java.util.ArrayList;
import java.util.List;

/**
 * Класс вакансии
 */
public class Vacancy {
    private JobType jobType;
    private String companyName;
    private int salary;
    List<Applicant> subscribes;

    public Vacancy(JobType jobType, String companyName, int salary) {
        this.jobType = jobType;
        this.companyName = companyName;
        this.salary = salary;
        subscribes = new ArrayList<>();
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
        StringBuilder sb = new StringBuilder();
        sb.append("Вакансия [Должность=").append(jobType.getName()).append(", оклад=").append(salary).append(", Компания=").append(companyName).append("] ");
        sb.append("Подписчики на вакансию: [");
        for (int i = 0; i < subscribes.size(); i++) {
            sb.append("\"").append(subscribes.get(i).getName()).append("\"");
            if (i < subscribes.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
