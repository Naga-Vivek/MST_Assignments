package FunctionalInterfacesAndLambdaExpressions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface UserNameGenerator{
    String generate(String firstName , String lastName , LocalDate dateOfBirth , int id);
}
public class LambdaQuestions {
    public static void main(String[] args) {
        // Sorting emp list based on month in DOB
        List<Employee> employees = Employee.getEmployeeList();
        List<User> users = Question2.getUserList(employees);
        System.out.println("Before Sorting: ");
        employees.forEach(System.out::println);
        List<Employee> employees1 = new ArrayList<>(employees);
        employees1.sort((e1,e2)->e1.getDateOfBirth().getMonthValue()-e2.getDateOfBirth().getMonthValue());
        System.out.println("After Sorting: ");
        employees1.forEach(System.out::println);

        // Creating Threads for printing emp & user lists
        System.out.println("List of Employees using Lambda exp");
        new Thread(()->employees.forEach(System.out::println)).start();
        System.out.println("List of Users using Lambda exp");
        new Thread(()->users.forEach(System.out::println)).start();

        // Creating a new Employee
        Employee emp = new Employee("Rajesh","Singh",6,LocalDate.of(1998,8,9),50000,"IT");
        System.out.println(emp);
        // Generating UserName Using custom functional interface
        User u = new User();
        u.setId(emp.getId());
        UserNameGenerator unameGenerator = (f,l,d,i)-> f+l+d+i;
        String uname = unameGenerator.generate(emp.getFirstName(), emp.getLastName(), emp.getDateOfBirth(),emp.getId());
        u.setUserName(uname);
        u.setPassword(Question2.generatePassword().get());
        System.out.println(u);

    }
}
