import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee> {
    private SortType sType;

    public EmployeeNameComparator(SortType sType) {
        this.sType = sType;
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        int res = sType == SortType.Ascending ? o1.getName().compareTo(o2.getName())
                : o2.getName().compareTo(o1.getName());
        if (res == 0)
            res = sType == SortType.Ascending ? o1.getAge() - o2.getAge() : o2.getAge() - o1.getAge();
        return res;
    }

}
