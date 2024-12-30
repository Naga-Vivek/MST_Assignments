package Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {
    public static void main(String[] args) {
        List<Employee> employees = Employee.getEmployeeList();
        //Write a program to print First Name of employees which joined in year 2023.
        System.out.println("First Name of employees who joined in year 2023");
        employees.stream()
                .filter(e->(e.getDateOfJoining().getYear())==2023)
                .forEach(e->System.out.println(e.getFirstName()));


        //Write a program to print count, min, max, sum, and the average of salary of all employees in a particular department.
        System.out.println("\nCount of employees in a particular department");
        Map<String,Long> salaryCountByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()));
        salaryCountByDepartment.forEach((k,v)->System.out.println(k+" "+v));

        System.out.println("\nMin of salaries in a particular department");
        Map<String, Optional<Employee>> minSalaryByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDept,Collectors.minBy(Comparator.comparingDouble(Employee::getSalary))));
        minSalaryByDepartment.forEach((k, v)->System.out.println(k+" "+v.get().getSalary()));

        System.out.println("\nMax of salaries in a particular department");
        Map<String, Optional<Employee>> maxSalaryByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDept,Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        maxSalaryByDepartment.forEach((k, v)->System.out.println(k+" "+v.get().getSalary()));

        System.out.println("\nSum of salaries in a particular department");
        Map<String,Double> totalSalaryByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDept,Collectors.summingDouble(Employee::getSalary)));
        totalSalaryByDepartment.forEach((k, v)->System.out.println(k+" "+v));

        System.out.println("\nAverage of salaries in a particular department");
        Map<String, Double> averageSalaryByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDept,Collectors.averagingDouble(Employee::getSalary)));
        averageSalaryByDepartment.forEach((k, v)->System.out.println(k+" "+v));

        //Write a program to print sorted list of employees by firstName in all departments except HR department.
        System.out.println("\nSorted List of Employees by firstName");
        List<String> sortedEmployees =
                employees.stream()
                        .filter(e->!e.getDept().equals("HR"))
                        .sorted(Comparator.comparing(Employee::getFirstName))
                        .map(Employee::getFirstName)
                        .toList();
        sortedEmployees.forEach(System.out::println);

        //Write a program to increment salary of employees in particular department by 10%.
        System.out.println("Enter the Department to which salary has to be incremented ");
        Scanner sc = new Scanner(System.in);
        String dept  = sc.nextLine();
        System.out.println("Employees after getting 10% salary increment in "+dept+" dept");
        employees.stream()
                .filter(e->e.getDept().equals(dept))
                .peek(e-> e.setSalary(e.getSalary()*1.1))
                .forEach(System.out::println);

        // or map(e->{e.setSalary(e.getSalary()*1.1);return e;})
        // peek to make an operation and return the stream of original elements
        // map to transform elements and return the stream of transformed elements

        //Write a program using stream to print 50 odd numbers after 100.
        System.out.println("\nprinting 50 odd numbers after 100.");
        IntStream.iterate(101,n->n+2)
                .limit(50)
                .forEach(System.out::println);

        //Write a program to create comma separated list of First names of employees order by dateOfbirth.
        System.out.println("\nList of Employees sorted by DOB");
        String result = employees.stream()
                .sorted(Comparator.comparing(Employee::getDateOfBirth))
                .map(Employee::getFirstName)
                .collect(Collectors.joining(",","[","]"));
        System.out.println(result);


    }
}
