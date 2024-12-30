package Streams;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private LocalDate dateOfJoining;
    private String dept;
    private double salary;

    public Employee(int id, String firstName, String lastName, LocalDate dateOfBirth, LocalDate dateOfJoining, String dept ,double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoining = dateOfJoining;
        this.dept = dept;
        this.salary = salary;
    }

    public Employee() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfJoining=" + dateOfJoining +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }

    // Static Method to Generate a List of Employees
    public static List<Employee> getEmployeeList() {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Ian", "Clark" , LocalDate.of(1990, 3, 15), LocalDate.of(2021, 6, 1), "IT", 85000));
        employees.add(new Employee(2, "George", "Martinez", LocalDate.of(1988, 11, 20), LocalDate.of(2023, 2, 15), "HR", 62000));
        employees.add(new Employee(3, "Charlie", "Williams", LocalDate.of(1995, 7, 8), LocalDate.of(2020, 12, 1), "Finance", 78000));
        employees.add(new Employee(4,  "Julia", "Davis", LocalDate.of(1992, 9, 25), LocalDate.of(2022, 5, 20), "IT", 87000));
        employees.add(new Employee(5, "Hannah", "Lopez", LocalDate.of(1993, 5, 12), LocalDate.of(2024, 1, 10), "Marketing", 65000));
        employees.add(new Employee(6, "Fiona", "Garcia", LocalDate.of(1994, 8, 30), LocalDate.of(2023, 8, 14), "HR", 63000));
        employees.add(new Employee(7, "Bob", "Johnson", LocalDate.of(1991, 1, 16), LocalDate.of(2021, 10, 5), "Sales", 72000));
        employees.add(new Employee(8, "Evan", "Jones", LocalDate.of(1989, 6, 18), LocalDate.of(2022, 4, 11), "IT", 90000));
        employees.add(new Employee(9, "Alice", "Smith", LocalDate.of(1996, 3, 2), LocalDate.of(2020, 9, 30), "Finance", 79000));
        employees.add(new Employee(10, "Diana", "Brown", LocalDate.of(1992, 7, 14), LocalDate.of(2024, 3, 18), "Sales", 74000));

        return employees;
    }
}
