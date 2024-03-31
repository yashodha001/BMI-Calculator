import java.util.ArrayList;
import java.util.Scanner;

// User class
class User {
    private int id;
    private String name;
    private int yearOfBirth;
    private double height;
    private double weight;

    // Constructor 
    public User(int id, String name, int yearOfBirth, double height, double weight) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.height = height;
        this.weight = weight;
    }

    // Getters 
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    // calculate BMIi
    public double calculateBMI() {
        return weight / ((height / 100) * (height / 100));
    }

    public String getBMIStatus() {
        double bmi = calculateBMI();
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    // recommendations
    public String getRecommendations() {
        String bmiStatus = getBMIStatus();
        if (bmiStatus.equals("Underweight")) {
            return "1";
        } else if (bmiStatus.equals("Overweight")) {
            return "2";
        } else if (bmiStatus.equals("Obese")) {
            return "3";
        } else {
            return "4";
        }
    }

    // display user information
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Year of Birth: " + yearOfBirth);
        System.out.println("Height: " + height);
        System.out.println("Weight: " + weight);
        System.out.println("BMI: " + calculateBMI());
        System.out.println("BMI Status: " + getBMIStatus());
        System.out.println("Recommendations: " + getRecommendations());
    }
}

// Main class
public class Main {
    private static ArrayList<User> userList = new ArrayList<>(); // store user records
    private static Scanner scanner = new Scanner(System.in); // for user input

    // start the program 
    public static void main(String[] args) {
        displayMenu(); // Call the displayMenu()
    }

    // display the menu handle user inpu
    private static void displayMenu() {
        while (true) { //  run until the user chooses to exit
            System.out.println("\nMenu:");
            System.out.println("1. Create a record");
            System.out.println("2. Show BMI data for all users");
            System.out.println("3. Show BMI data for a selected user");
            System.out.println("4. Delete all");
            System.out.println("5. Exit application");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt(); // Read user's choice
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    create(); 
                    break;
                case 2:
                    index(); 
                    break;
                case 3:
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt(); // Read user ID
                    view(userId); 
                    break;
                case 4:
                    delete(); 
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // BMI data for all users
    private static void index() {
        System.out.println("\nAll Records:");
        for (User user : userList) {
            user.display(); //  user information
        }
    }

    //  display BMI data 
    private static void view(int id) {
        for (User user : userList) {
            if (user.getId() == id) { //specified ID
                user.display(); 
                return;
            }
        }
        System.out.println("User with ID " + id + " not found."); //not found
    }

    // create a new userds
    private static void create() {
        System.out.print("Enter user ID: ");
        int id = scanner.nextInt(); // Read user ID from the console
        scanner.nextLine(); 
        System.out.print("Enter name: ");
        String name = scanner.nextLine(); // Read user name 
        System.out.print("Enter year of birth: ");
        int yearOfBirth = scanner.nextInt(); //year of birth 
        System.out.print("Enter height (in cm): ");
        double height = scanner.nextDouble(); //  height 
        System.out.print("Enter weight (in kg): ");
        double weight = scanner.nextDouble(); // s weight 

        userList.add(new User(id, name, yearOfBirth, height, weight)); // new user object and add to userList
        System.out.println("User record created successfully."); //
    }

    //  delete all 
    private static void delete() {
        userList.clear(); // Clear the userList
        System.out.println("All records deleted."); 
    }

    //  exit 
    private static void exit() {
        System.out.println("Exiting application."); 
        System.exit(0); 
    }
}
