
import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    // Instance variable of round, score and Scanner class
    // object------------------------------------------------
    static int round = 1;
    static int score = 0;
    static int noRound = 5;
    static int scorePerRound = 100;// Every correct answer amounts to 100 on the score board
    static int upperLimit = 100;
    static int lowerLimit = 1;
    static Scanner scanner = new Scanner(System.in);

    // This is a static block containing game instructions
    static {
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-Welcome to Number Game-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
       
    }

    public static void main(String[] args) {
        // calling random
        // method--------------------------------------------------------------------------------------
        int randomInt = NumberGame.ramdomInt(lowerLimit, upperLimit);
        // System.out.println("######" + randomInt);//To test if the random number is
        // being generated or not
        // This loop will take care of number of attampts per
        // game----------------------------------------------------
        for (int i = 0; i <= noRound; i++) {
            int guess = NumberGame.prompt(i);
            String result = NumberGame.compare(randomInt, guess);
            System.out.println(result);
            // This if condition will check the result and gives score to the
            // player--------------------------------------
            if (result.equals("Correct")) {
                score = score + scorePerRound;
                break;
            } else
                continue;
        }
        // This will display the score after every
        // round---------------------------------------------------------------
        System.out.println("Your current score after round " + round + " is:- " + score);
        // This will give a choice to the user weather to continue playing or
        // quit-------------------------------------
        System.out.println("Do you want to play other round(y/n)");
        char choice = scanner.next().charAt(0);
        // This will analyse the responce, if y => main method will run again if n=> It
        // will display the thanks message
        if (choice == 'y') {
            round = round + 1;
            NumberGame.main(null);
        } else if (choice == 'n') {
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-Thank you-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");

        } 
        else
            System.out.println("Invalid entry");
    }

    
    // This method will generate a random number withen the limits
    // specified---------------------------------------
    public static int ramdomInt(int num1, int num2) {
        Random random = new Random();
        int temp2 = -1;
        while (temp2 < num1) {
            int temp1 = random.nextInt(99999);
            temp2 = temp1 % num2;
        }
        return temp2;
    }

    // This method will prompt the user to enter gussed
    // number-----------------------------------------------------
    public static int prompt(int attampts) {
        System.out.println("-----------------------------------" + "Number of attampts left " + (5 - attampts)
                + "-----------------------------------");
        System.out.println("Guess a number:- ");
        int num = scanner.nextInt();
        return num;
    }

    // This method will compare the gusse with the randomly generated
    // number---------------------------------------
    public static String compare(int rand, int guess) {
        String result = "Invalid Guess, try again with a number";

        if (guess == rand)
            result = "Correct";

        else if (guess < rand)
            result = "Too low";

        else if (guess > rand)
            result = "Too high";

        return result;
    }
}