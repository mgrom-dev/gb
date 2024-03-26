import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {
    public static Random random = new Random();

    /**
     * @TODO: Доработать приложение, которое разрабатывалось на семинаре,
     * поработать с шаблоном проектирования Observer,
     * добавить новый тип соискателя.
     * Добавить новую сущность "Вакансия", компания должна рассылать вакансии.
     * Только после этого вы можете усложнить ваше приложение (при желании),
     * например,
     * добавить тип вакансии (enum),
     * учитывать тип вакансии при отправке предложения соискателю.
     * ***. Добавить возможность отписаться от рассылки новых вакансий.
     * 
     * @param args
     */
    public static void main(String[] args) {

        Publisher publisher = new JobAgency();
        List<Company> companies = generateCompanies(publisher, 5); // генерируем компании
        generateVacancies(companies, 3); // генерируем вакансии
        List<Applicant> applicants = createRandomApplicant(5); // генерируем соискателей
        applicants.forEach(a -> publisher.registerObserver(a)); // добавляем в рассылку
        companies.forEach(c -> c.needEmployee()); // рассылка вакансии
        System.out.println("");
        applicants.forEach(a -> System.out.println(a));
    }

    // генерация компании
    private static List<Company> generateCompanies(Publisher publisher, int count) {
        List<Company> companies = new ArrayList<>();
        String[] companyNames = { "Google", "Yandex", "GeekBrains", "Apple", "Microsoft", "Amazon", "Facebook", "Uber",
                "JAVA", "Oracle" };

        for (int i = 0; i < count; i++) {
            String companyName = companyNames[random.nextInt(companyNames.length)];
            Company company = new Company(companyName, publisher);
            companies.add(company);
        }

        return companies;
    }

    // генерации вакансии
    private static void generateVacancies(List<Company> companies, int count) {
        JobType[] jobTypes = JobType.values();

        for (Company company : companies) {
            for (int i = 0; i < count; i++) { // Генерируем вакансии для каждой компании
                JobType jobType = jobTypes[random.nextInt(jobTypes.length)];
                int salary = random.nextInt(300_000); // Случайная зарплата
                company.createVacancy(jobType, salary);
            }
        }
    }

    // генерации соискателей
    private static List<Applicant> createRandomApplicant(int count) {
        List<Applicant> applicants = new ArrayList<>();
        String[] names = { "John", "Alice", "Bob", "Mary", "David", "Emma", "James", "Olivia", "Michael", "Sophia",
                "Max", "Denis", "Anna", "Mark" };

        for (int i = 0; i < count; i++) {
            int randomJobType = random.nextInt(3);
            String name = names[random.nextInt(names.length)];
            switch (randomJobType) {
                case 0:
                    applicants.add(new Master(name));
                    break;
                case 1:
                    applicants.add(new Developer(name));
                    break;
                case 2:
                    applicants.add(new Student(name));
                    break;
            }
        }

        return applicants;
    }
}
