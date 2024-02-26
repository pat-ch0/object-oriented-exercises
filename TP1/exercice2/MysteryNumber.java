package exercice2;

import java.util.Random;

public class MysteryNumber {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("You must enter the upper and lower bounds!");
            System.exit(1);
        } else {
            try {
                int lowerBound = Integer.parseInt(args[0]);
                int upperBound = Integer.parseInt(args[1]);
                
                int randomNumber = new Random().nextInt(upperBound);

                System.out.printf("Give a number between %d and %d.%n", lowerBound, upperBound);
                
                int userAnswer = Integer.parseInt(System.console().readLine());
                
                while (userAnswer != randomNumber) {
                    if (userAnswer < randomNumber) {
                        System.out.printf("It is more than %s!%n", userAnswer);
                    } else if (userAnswer > randomNumber) {
                        System.out.printf("It is less than %s!%n", userAnswer);
                    }

                    System.out.printf("Give a number between %d and %d.%n", lowerBound, upperBound);
                    userAnswer = Integer.parseInt(System.console().readLine());
                }
                
                System.out.println("Congratulation! The number was " + randomNumber);

            } catch (NumberFormatException nfe) {
                System.err.println("Give valid numbers.");
                System.exit(2);
            }
        }

    }
}