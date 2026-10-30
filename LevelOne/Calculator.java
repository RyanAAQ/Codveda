package LevelOne;
import java.util.Scanner;

public class Calculator{
    public static int add(int numberOne, int numberTwo){
        return numberOne + numberTwo;
    }

    public static int subtract(int numberOne, int numberTwo){
        return numberOne - numberTwo;
    }

    public static int multiply(int numberOne, int numberTwo){
        return numberOne * numberTwo;
    }

    public static int divide(int numberOne, int numberTwo){
        if (numberTwo == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return numberOne / numberTwo;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Calculator\n");

        System.out.print("Enter the first number: ");
        int numberOne = input.nextInt();

        System.out.print("Enter the second number: ");
        int numberTwo = input.nextInt();

        System.out.print("Enter the operation: ");
        String operand = input.next();

        switch (operand) {
            case "+" -> System.out.print(add(numberOne, numberTwo));
            case "-" -> System.out.print(subtract(numberOne, numberTwo));
            case "*" -> System.out.print(multiply(numberOne, numberTwo));
            case "/" -> System.out.print(divide(numberOne, numberTwo));
        }

    }
}