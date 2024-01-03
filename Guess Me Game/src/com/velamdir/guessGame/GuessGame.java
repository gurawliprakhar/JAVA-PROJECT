package com.velamdir.guessGame;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {

    public static void playGuessingGame() {
        System.out.println("Welcome to Guess the Number Game");

        System.out.println("May I have your name?");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        System.out.println("Hello " + name);

        System.out.println("Shall we start?");
        System.out.println("\t1.Yes");
        System.out.println("\t2.No");

        int beginAnswer = scan.nextInt();

        while (beginAnswer != 1) {
            System.out.println("Shall we start?");
            System.out.println("\t1.Yes");
            System.out.println("\t2.No");

            beginAnswer = scan.nextInt();
        }

        Random random = new Random();
        int x = random.nextInt(20) + 1;
        System.out.println("Please Guess a Number: ");
        int userInput = scan.nextInt();

        int timesTried = 0;
        boolean hasWon = false;
        boolean shouldFinish = false;

        while (!shouldFinish) {
            timesTried++;

            if (timesTried < 5) {
                if (userInput == x) {
                    hasWon = true;
                    shouldFinish = true;
                } else if (userInput > x) {
                    System.out.println("Guess Lower");
                    userInput = scan.nextInt();
                } else {
                    System.out.println("Guess Higher");
                    userInput = scan.nextInt();
                }
            } else {
                shouldFinish = true;
            }
        }
        if (hasWon) {
            System.out.println("Congratulations! You have guessed the number in " + timesTried + " tries.");
        } else {
            System.out.println("Game Over!");
            System.out.println("The number was: " + x);
        }
    }

    public static void main(String[] args) {
        playGuessingGame();
    }
}
