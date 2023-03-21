import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        
        // generate a random number between 1 and 100
        Random random = new Random();
        int number = random.nextInt(100) + 1;
        
        // set the number of attempts allowed
        int maxAttempts = 10;
        int attemptsLeft = maxAttempts;
        
        // create a Scanner object to read user input from the console
        Scanner scanner = new Scanner(System.in);
        
        // keep playing until the user guesses the number or runs out of attempts
        while (attemptsLeft > 0) {
            
            // prompt the user to enter their guess
            System.out.print("Guess the number between 1 and 100. You have " + attemptsLeft + " attempts left: ");
            
            // read the user's guess from the console
            int guess = scanner.nextInt();
            
            // check if the guess is correct
            if (guess == number) {
                System.out.println("Congratulations, you guessed the number!");
                break;
            } else if (guess < number) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }
            
            // decrement the number of attempts left
            attemptsLeft--;
        }
        
        // display the final message
        if (attemptsLeft == 0) {
            System.out.println("Sorry, you ran out of attempts. The number was " + number + ".");
        }
        
        // close the scanner
        scanner.close();
    }

}