import java.util.ArrayList;
import java.util.List;

/**
 * Класс соискатель, чтобы убрать дублирование кода
 */
public abstract class Applicant implements Observer {
    private String name;
    private int salary;
    private List<Vacancy> subscriptions;
    private boolean unsubscribe;

    Applicant(String name, int salary) {
        this.name = name;
        this.salary = salary;
        subscriptions = new ArrayList<>();
        unsubscribe = false;
    }

    @Override
    public void receiveOffer(Vacancy vacancy) {
        if (unsubscribe) // работа уже найдена
            return;
        if (this.salary <= vacancy.getSalary()) {
            System.out.printf("%s: Мне нужна эта работа! (компания: %s; должность: %s заработная плата: %d)\n",
                    name, vacancy.getCompanyName(), vacancy.getJobType().getName(), vacancy.getSalary());
            this.salary = vacancy.getSalary();
            this.subscriptions.add(vacancy);
            vacancy.subscribes.add(this);
            if (this.subscriptions.size() > 1)
                unsubscribe = true;
        } else {
            System.out.printf("%s: Я найду работу получше! (компания: %s; должность: %s заработная плата: %d)\n",
                    name, vacancy.getCompanyName(), vacancy.getJobType().getName(), vacancy.getSalary());
        }
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ").append(name).append("; ");
        sb.append("Зарплата: ").append(salary).append("; ");
        sb.append("Подписки на вакансии: [");
        for (int i = 0; i < subscriptions.size(); i++) {
            Vacancy vacancy = subscriptions.get(i);
            sb.append("\"").append(vacancy.getJobType().getName()).append(" в компании ").append(vacancy.getCompanyName()).append("\"");
            if (i < subscriptions.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] unsubscribe: ").append(unsubscribe ? "Да" : "Нет");
        return sb.toString();
    }

}
