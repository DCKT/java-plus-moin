package com.dck;

import java.util.Random;
import java.util.Scanner;

public class Game {
  private int unknownNumber;
  private int count;

  public int guessNumber(int number) {
    System.out.printf("\nle nombre mystere est %d\n", unknownNumber);
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

    unknownNumber = rand.nextInt(50) + 1;
  
    System.out.println("HELLO TO YOU || JEU DU PLUS OU MOINS");

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