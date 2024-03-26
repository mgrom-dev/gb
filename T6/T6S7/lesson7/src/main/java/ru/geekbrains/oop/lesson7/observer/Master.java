import java.util.Arrays;
import java.util.List;

public class Master extends Applicant {
   private List<JobType> jobTypes;

    public Master(String name){
        super(name, 80_000);
        jobTypes = Arrays.asList(JobType.DATABASE_ENGINEER, JobType.SYSTEM_ADMINISTRATOR, JobType.SYSTEM_ANALYST);
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
