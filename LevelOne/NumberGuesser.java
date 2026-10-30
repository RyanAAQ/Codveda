package LevelOne;
import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1;
        int userGuess = 0;
        int attempts = 0;


        System.out.println("Welcome to the Number Guesser!");
        System.out.println("Try to guess the number between 1 and 100.");

        while (userGuess != numberToGuess) {
            System.out.print("Enter your guess: ");

            if (!input.hasNextInt()) {
                System.out.println("Please enter a valid integer.");
                input.next();
                continue;
            }

            userGuess = input.nextInt();
            attempts++;

            if (attempts >= 5) {
                System.out.println("You lose! The number was " + numberToGuess);
                break;
            }

            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
        } else if (userGuess > numberToGuess) {
            System.out.println("Too high! Try again.");
         } else {
             System.out.println("Congratulations! You've guessed the number!");
            }

        }
        input.close();

    }
    
}
