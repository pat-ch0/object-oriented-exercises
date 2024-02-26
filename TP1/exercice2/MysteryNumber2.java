package exercice2;

import java.util.Random;

public class MysteryNumber2 {

    private int lowerBound;
    private int upperBound;
    private int randomNumber;
    private int userAnswer;

    public MysteryNumber2(String lb, String ub) {
        try {
            this.lowerBound = Integer.parseInt(lb);
            this.upperBound = Integer.parseInt(ub);
        } catch (NumberFormatException nfe) {
            System.err.println("Give valid numbers.");
            System.exit(1);
        }
        this.randomNumber = new Random().nextInt(this.upperBound);
    }

    private void run() {
        while (userAnswer != randomNumber) {
            askNumber();
            processNumber();
        }
        System.out.println("Congratulation! The number was " + randomNumber);
    }
    
    private void askNumber() {
        System.out.printf("Give a number between %d and %d.%n", lowerBound, upperBound);
        try {
            this.userAnswer = Integer.parseInt(System.console().readLine());
        } catch (NumberFormatException nfe) {
            System.err.println("Give a valid number.");
            System.exit(1);
        }
    }
    
    private void processNumber() {
        if (userAnswer < randomNumber) {
            System.out.printf("It is more than %s!%n", userAnswer);
        } else if (userAnswer > randomNumber) {
            System.out.printf("It is less than %s!%n", userAnswer);
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("You must enter the upper and lower bounds!");
            System.exit(1);
        } else {
            MysteryNumber2 mn2 = new MysteryNumber2(args[0], args[1]);
            mn2.run();
        }

    }
}
