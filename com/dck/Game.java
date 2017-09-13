package com.dck;

import java.util.Random;
import java.util.Scanner;

public class Game {
  private int unknownNumber;
  private int count;

  public int guessNumber(int number) {
    if (number > unknownNumber) {
      return -1;
    } else if (number < unknownNumber) {
      return 1;
    } else {
      return 0;
    }
  }

  public void start() {
    int count = 0;
    int number = 0;
    Random rand = new Random();
    int[] LEVELS = {50, 200, 500};
  
    System.out.println("HELLO TO YOU || JEU DU PLUS OU MOINS");
    int difficulty = this.askUserDifficulty();

    unknownNumber = rand.nextInt(LEVELS[difficulty - 1]) + 1;

    do {
      count++;
      number = guessNumber(this.askUserInput());

      if (number == 1) {
        System.out.println("C'est plus !");
      } else if (number == -1) {
        System.out.println("C'est moins !");
      }

    } while (number != 0);

    System.out.printf("Bravo ! Vous avez gagné en %d coups \n", count);
  }

  private int askUserDifficulty() {
    Scanner sc = new Scanner(System.in);
    int validNumber = 0;

    System.out.println("Veuillez séléctionner la difficultée : ");
    System.out.println("1 - Entre 1 et 50 (noob)");
    System.out.println("2 - Entre 1 et 200 (mouai)");
    System.out.println("3 - Entre 1 et 500 (bogoss)");

    do {
      String input = sc.nextLine();

      try {
        validNumber = Integer.parseInt(input);
        if (validNumber < 1 || validNumber > 3) {
          System.out.println("---> Veuillez choisir 1, 2 ou 3 -_-'");
        }
      } catch(NumberFormatException nfe) {
        System.out.println("---> CHIFFRES ONLY PLS");
      }
    } while(validNumber < 1 || validNumber > 3);

    return validNumber;
  }

  private int askUserInput() {
    Scanner sc = new Scanner(System.in);
    int validNumber = 0;
    boolean error = false;

    do {
      System.out.printf("Devine : ");
      String input = sc.nextLine();

      try {
        validNumber = Integer.parseInt(input);
        error = false;
      } catch(NumberFormatException nfe) {
        error = true;
        System.out.println("---> CHIFFRES ONLY PLS");
      }
    } while (error);

    return validNumber;
  }
}