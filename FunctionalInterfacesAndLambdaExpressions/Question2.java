package FunctionalInterfacesAndLambdaExpressions;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Question2 {
    public static void main(String[] args) {
        List<User> users = getUserList(Employee.getEmployeeList());
        users.forEach(System.out::println);
    }
    public static List<User> getUserList(List<Employee> employees){
        System.out.println("\nCreating List of Users.........");
        List<User> users = new ArrayList<>();
        for(Employee emp : employees){
            users.add(createUser().apply(emp));
        }
        return users;
    }
    public static Function<Employee,User> createUser(){
        return e-> {
            User u = new User();
            u.setId(e.getId());
            u.setUserName(e.getFirstName()+e.getLastName()+e.getDateOfBirth()+e.getId());
            u.setPassword(generatePassword().get());
            return u;
        };
    }
    public static Supplier<String> generatePassword(){
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:,.<>?";
        String allChars = upperCase + lowerCase + digits + specialChars;

        // SecureRandom for better randomness
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(16);

        // Ensure the password contains at least one character from each group
        password.append(upperCase.charAt(random.nextInt(upperCase.length())));
        password.append(lowerCase.charAt(random.nextInt(lowerCase.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(specialChars.charAt(random.nextInt(specialChars.length())));

        // Fill the rest of the password with random characters
        for (int i = 4; i < 16; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        // Shuffle the password to ensure randomness
        char[] passwordArray = password.toString().toCharArray();
        for (int i = 0; i < passwordArray.length; i++) {
            int randomIndex = random.nextInt(passwordArray.length);
            // Swap characters
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[randomIndex];
            passwordArray[randomIndex] = temp;
        }

        return ()-> {return new String(passwordArray);};
    }
}
