import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UserService extends Storage {
    static Scanner scanner = new Scanner(System.in);

    public static void createAccount() {
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();
        if (!(UserValidation.validateName(fullName))) {
            throw new RuntimeException("Invalid name");
        }

        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        if (!(UserValidation.validateEmail(email))) {
            throw new RuntimeException("Invalid email");
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (!UserValidation.validatePassword(password)) {
            throw new RuntimeException("Invalid password");
        }

        User newUser = new User(fullName, email, password);
        users.forEach(user ->{
            if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
                throw new RuntimeException("User already exists");
            }
        });

        users.add(newUser);
        System.out.println("Account created successfully!");
    }

    public static void login() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Logged in successfully!");
                currentUser=user;
                break;
            }
            System.out.println("Invalid email or password!");
        }
    }

    public static void logout(){
        currentUser = null;
        System.out.println("You are log out!");
    }

}
