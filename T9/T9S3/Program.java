public class Program {
    public static void main(String[] args) {
        Employee employee = new Employee("Danil", 13);

        LinkedList<Employee> empLinkedList = new LinkedList<>();
        empLinkedList.add(new Employee("Max", 36));
        empLinkedList.add(new Employee("Denis", 9));
        empLinkedList.add(new Employee("Andrei", 15));
        empLinkedList.add(new Employee("Evgen", 13));
        empLinkedList.add(new Employee("Boris", 25));
        empLinkedList.add(new Employee("Max", 26));
        empLinkedList.add(new Employee("Evgen", 28));
        empLinkedList.add(employee);

        empLinkedList.sort(new EmployeeNameComparator(SortType.Ascending));
        System.out.println(empLinkedList);
        empLinkedList.sort(new EmployeeNameComparator(SortType.Descending));
        System.out.println(empLinkedList);
        empLinkedList.removeFirst();
        empLinkedList.removeLast();
        System.out.println(empLinkedList);

        // найти середину списка
        LinkedList<Employee>.Node head = empLinkedList.head;
        int counter = 0;
        while (head != null) {
            counter++;
            head = head.next;
        }
        head = empLinkedList.head;
        for (int i = 0; i < counter / 2; i++) {
            head = head.next;
        }
        System.out.println(head.value);
    }
}
