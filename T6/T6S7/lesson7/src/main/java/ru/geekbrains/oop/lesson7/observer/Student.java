import java.util.Arrays;
import java.util.List;

public class Student extends Applicant {
    private List<JobType> jobTypes;

    public Student(String name) {
        super(name, 5_000);
        jobTypes = Arrays.asList(JobType.STUDENT, JobType.INTERN);
    }

    public List<JobType> getJobTypes() {
        return jobTypes;
    }

    // добавляем проверку на соответствии должности
    @Override
    public void receiveOffer(Vacancy vacancy) {
        if (jobTypes.contains(vacancy.getJobType()))
            super.receiveOffer(vacancy);
    }
}
