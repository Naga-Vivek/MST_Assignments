package FunctionalInterfacesAndLambdaExpressions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Employee {
    private String firstName;
    private String lastName;
    private int id;
    private LocalDate dateOfBirth;
    private int salary;
    private String dept;
    public static List<Employee> getEmployeeList(){
        List<Employee> employees = new ArrayList<>();
        Employee e1 = new Employee("John", "Doe", 1, LocalDate.of(1990, 5, 15), 2500, "IT");
        Employee e2 = new Employee("Jane", "Smith", 2, LocalDate.of(1985, 8, 25), 1800, "HR");
        Employee e3 = new Employee("Mark", "Taylor", 3, LocalDate.of(1992, 3, 10), 5000, "Finance");
        Employee e4 = new Employee("Emily", "Brown", 4, LocalDate.of(1995, 12, 5), 1500, "IT");
        Employee e5 = new Employee("Michael", "Johnson", 5, LocalDate.of(1988, 7, 20), 950, "Marketing");
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        return employees;
    }
    public Employee(String firstName, String lastName, int id, LocalDate dateOfBirth, int salary, String dept) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
        this.dept = dept;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", dateOfBirth=" + dateOfBirth +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                '}';
    }
}
