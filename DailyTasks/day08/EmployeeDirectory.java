
import java.util.*;

class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private String department;
    private double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Sort employees by ID
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Department: " + department +
                ", Salary: " + salary;
    }

    // Employees are considered equal when their IDs match
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Employee)) {
            return false;
        }

        Employee other = (Employee) obj;
        return this.id == other.id;
    }

    // Correct hashCode implementation
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}

public class EmployeeDirectory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Employee> employees = new HashMap<>();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Read employee details
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for employee " + (i + 1));

            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Department: ");
            String department = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            Employee emp = new Employee(id, name, department, salary);

            if (employees.containsKey(id)) {
                System.out.println("Employee ID already exists!");
            } else {
                employees.put(id, emp);
                System.out.println("Employee added successfully.");
            }
        }

        // 1. HashMap lookup
        System.out.print("\nEnter employee ID to search: ");
        int searchId = sc.nextInt();

        Employee found = employees.get(searchId);

        if (found != null) {
            System.out.println("Employee found: " + found);
        } else {
            System.out.println("Employee not found.");
        }

        // 2. Frequency count using merge()
        Map<String, Integer> frequency = new HashMap<>();

        for (Employee emp : employees.values()) {
            frequency.merge(emp.getDepartment(), 1, Integer::sum);
        }

        System.out.println("\nDepartment frequency:");
        System.out.println(frequency);

        // 3. TreeMap department report
        Map<String, Integer> report = new TreeMap<>(frequency);

        System.out.println("\nSorted department report:");
        for (Map.Entry<String, Integer> entry : report.entrySet()) {
            System.out.println(
                    entry.getKey() + " : " + entry.getValue() + " employees"
            );
        }

        // 4. Comparable: sort by employee ID
        List<Employee> sortedById =
                new ArrayList<>(employees.values());

        Collections.sort(sortedById);

        System.out.println("\nEmployees sorted by ID:");
        for (Employee emp : sortedById) {
            System.out.println(emp);
        }

        // 5. Comparator chain: salary descending, then name ascending
        List<Employee> topEmployees =
                new ArrayList<>(employees.values());

        topEmployees.sort(
                Comparator.comparingDouble(Employee::getSalary)
                        .reversed()
                        .thenComparing(Employee::getName)
        );

        System.out.println("\nTop 5 highest-paid employees:");
        for (int i = 0; i < Math.min(5, topEmployees.size()); i++) {
            System.out.println(topEmployees.get(i));
        }

        // 6. Demonstrate missing-hashCode bug
        Employee e1 = new Employee(101, "Arun", "IT", 50000);
        Employee e2 = new Employee(101, "Arun", "IT", 50000);

        System.out.println("\nHashCode demonstration:");
        System.out.println("e1.equals(e2): " + e1.equals(e2));

        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(e1);
        employeeSet.add(e2);

        System.out.println("HashSet size with correct hashCode: "
                + employeeSet.size());

        sc.close();
    }
}
