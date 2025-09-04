import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int roundNumber = 1;

        System.out.println("=== Welcome to the Number Guessing Game! ===");

        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1; // Generates number from 1 to 100
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n--- Round " + roundNumber + " ---");
            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess;

                // Validate input
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next(); // Clear invalid input
                    continue;
                }

                guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    // Score: Higher score for fewer attempts
                    totalScore += (maxAttempts - attempts + 1) * 10;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all your attempts. The number was: " + targetNumber);
            }

            System.out.println("Your current score: " + totalScore);

            // Ask if the user wants to play again
            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // Consume newline
            String response = scanner.nextLine().trim().toLowerCase();

            if (!response.equals("yes") && !response.equals("y")) {
                playAgain = false;
                System.out.println("\nThanks for playing!");
                System.out.println("🎯 Final Score: " + totalScore);
            } else {
                roundNumber++;
            }
        }

        scanner.close();
    }
}

#output
    === Welcome to the Number Guessing Game! ===

--- Round 1 ---
I'm thinking of a number between 1 and 100.
You have 7 attempts to guess it.
Enter your guess: 50
Too low!
Enter your guess: 75
Too low!
Enter your guess: 90
Too high!
Enter your guess: 80
Too low!
Enter your guess: 85
Too high!
Enter your guess: 83
Too high!
Enter your guess: 81
Too low!
? You've used all your attempts. The number was: 82
Your current score: 0
Do you want to play another round? (yes/no): yes

--- Round 2 ---
I'm thinking of a number between 1 and 100.
You have 7 attempts to guess it.
Enter your guess: 
=== Session Ended. Please Run the code again ===
    
