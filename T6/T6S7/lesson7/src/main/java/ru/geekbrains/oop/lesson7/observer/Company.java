import java.util.ArrayList;
import java.util.List;

public class Company {

    private String name;
    private Publisher jobAgency;
    private List<Vacancy> vacancys;

    public Company(String name, Publisher jobAgency) {
        this.name = name;
        this.jobAgency = jobAgency;
        vacancys = new ArrayList<>();
    }

    // добавление вакансии
    public void createVacancy(JobType jobType, int salary) {
        Vacancy vacancy = new Vacancy(jobType, name, salary);
        vacancys.add(vacancy);
    }

    public void needEmployee() {
        vacancys.forEach(v -> jobAgency.sendOffer(v));
    }

    public String getName() {
        return name;
    }

    public List<Vacancy> getVacancys() {
        return vacancys;
    }
    
}
