package FunctionalInterfacesAndLambdaExpressions;


import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class Question1 {
    public static Consumer<Employee> displayEmployee(){
        return System.out::println;
    }
    public static Predicate<Employee> isEmployeeSalaryGreaterThan2000(){
        return e-> e.getSalary()>2000;
    }
    public static BiPredicate<Employee,Integer> isEmployeeSalaryGreaterThanValue(){
        return (e,value)->e.getSalary()>value;
    }
    public static void main(String[] args){
        System.out.println("\nDisplaying employees with Consumer Interface");
        List<Employee> employees = Employee.getEmployeeList();
        displayEmployee().accept(employees.get(0));
        displayEmployee().accept(employees.get(2));

        System.out.println("\nDisplaying employees with sal > 2000 using Predicate Interface");
        for(Employee emp : employees){
            if(isEmployeeSalaryGreaterThan2000().test(emp)){
                displayEmployee().accept(emp);
            }
        }

        System.out.println("Is salary of Employee e4 greater than 2000? "+isEmployeeSalaryGreaterThan2000().test(employees.get(3)));
        System.out.println("Enter a Salary value");
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        System.out.println("\nDisplaying Employees with sal above "+val+" using BiPredicate Interface");
        for(Employee emp : employees){
            if(isEmployeeSalaryGreaterThanValue().test(emp,val)){
                displayEmployee().accept(emp);
            }
        }
    }
}
