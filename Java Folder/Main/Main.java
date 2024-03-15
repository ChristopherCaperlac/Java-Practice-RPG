package Main;

import java.util.Scanner;

import Characters.Player;
import Weapons.WeaponsList;

public class Main {
  private static int waitTime = 700;
  private static Player player;
  private static Scanner scnr;

  public static void main(String[] args) {
    WeaponsList.loadWeapons();
    Overworld.loadLocations();
    scnr = new Scanner(System.in);
    System.out.print("Please Type In Your Name: ");
    player = new Player(scnr.next());
    scnr.nextLine();
    System.out.println("");
    System.out.println(player.getName() + "'s journey is about to being!");
    System.out.println("");

    Main.sleep();
    // Overworld.getLocation(0).start();
    System.out.println("You make your way out of the cave and follow a erected path");
    // Overworld.getLocation(1).start();
    System.out.println("You leave the village for now and come upon the entrance of a forest");
    Overworld.getLocation(2).start();
    // TODO implement rest of locations and overworld traversal
    scnr.close();
  }

  public static Player getPlayer() {
    return player;
  }

  public static Scanner getScnr() {
    return scnr;
  }

  public static void sleep() {
    try {
      Thread.sleep(waitTime);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}