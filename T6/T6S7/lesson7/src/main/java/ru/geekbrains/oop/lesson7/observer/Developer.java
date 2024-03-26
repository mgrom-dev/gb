import java.util.Arrays;
import java.util.List;

/**
 * Разработчик
 */
public class Developer extends Applicant {
    private List<JobType> jobTypes;

    public Developer(String name){
        super(name, 150_000);
        jobTypes = Arrays.asList(JobType.JAVA_DEVELOPER, JobType.PYTHON_DEVELOPER, JobType.C_DEVELOPER, JobType.TESTER, JobType.PROJECT_MANAGER);
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
