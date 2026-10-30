package LevelTwo.EmployeeManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();
        int choice = 0;

        while (choice != 6) {
            System.out.println("\n1. Add employee");
            System.out.println("2. View all employees");
            System.out.println("3. Find employee by ID");
            System.out.println("4. Update employee");
            System.out.println("5. Delete employee");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            try {
                choice = input.nextInt();
                input.nextLine();

                if (choice == 1) {
                    System.out.print("ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Name: ");
                    String name = input.nextLine();

                    System.out.print("Department: ");
                    String dept = input.nextLine();

                    System.out.print("Salary: ");
                    double salary = input.nextDouble();

                    if (manager.addEmployee(new Employee(id, name, dept, salary))) {
                        System.out.println("Employee added.");
                    } else {
                        System.out.println("That ID already exists.");
                    }

                } 
                else if (choice == 2) {
                    if (manager.getAllEmployees().isEmpty()) {
                        System.out.println("No employees yet.");
                    }
                    for (Employee employee : manager.getAllEmployees()) {
                        System.out.println(employee);
                    }

                } else if (choice == 3) {
                    System.out.print("ID: ");
                    Employee employee = manager.findById(input.nextInt());
                    System.out.println(employee == null ? "Not found." : employee);

                } else if (choice == 4) {
                    System.out.print("ID to update: ");
                    int id = Integer.parseInt(input.nextLine().trim());
                    System.out.print("New name: ");
                    String name = input.nextLine();
                    System.out.print("New department: ");
                    String dept = input.nextLine();
                    System.out.print("New salary: ");
                    double salary = input.nextDouble();

                    if (manager.updateEmployee(id, name, dept, salary)) {
                        System.out.println("Employee updated.");
                    } else {
                        System.out.println("Not found.");
                    }

                } else if (choice == 5) {
                    System.out.print("ID to delete: ");
                    if (manager.deleteEmployee(input.nextInt())) {
                        System.out.println("Employee deleted.");
                    } else {
                        System.out.println("Not found.");
                    }

                } else if (choice == 6) {
                    System.out.println("Goodbye!");

                } else {
                    System.out.println("Pick a number from 1 to 6.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please type a valid number.");
                choice = 0;
            }
        }
        input.close();
    }
}
