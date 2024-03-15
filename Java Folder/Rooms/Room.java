package Rooms;

import Main.Main;
import Main.Battle;
import java.util.ArrayList;
import Characters.Character;
import Characters.Player;
import Weapons.WeaponsList;

public class Room {
  private int roomType;
  private ArrayList<Character> characters;

  public Room() {
    characters = new ArrayList<Character>();
  }

  public Room(int roomType) {
    characters = new ArrayList<Character>();
    this.roomType = roomType;
  }

  public void setType(int roomType) {
    this.roomType = roomType;
  }

  public void start() {
    // TODO fill with different roomTypes
    printDialogue();
    if (roomType == 0) {
      shop();
    } else if (roomType == 1) {
      encounter();
    }
  }

  private void shop() {
    System.out.println("You have a list of options: ");
    System.out.println("[1] " + WeaponsList.getWeapon(2));
    System.out.println("[2] " + WeaponsList.getWeapon(3));
    System.out.println("[3] " + WeaponsList.getWeapon(4));
    int input = 0;
    Player player = Main.getPlayer();
    while (input != 1 && input != 2 && input != 3) {
      input = Main.getScnr().nextInt();
      Main.getScnr().nextLine();
    }
    player.setWeapon(WeaponsList.getWeapon(input + 1));
    System.out.println(player.getName() + " has a " + player.getWeapon().getName());
    System.out.println("");
  }

  private void encounter() {
    Battle.setEnemy(this.getCharacter(0));
    Battle.result(Battle.start());
  }

  private void conversation() {
    // TODO add an NPC you can talk to
  }

  private void printDialogue() {
    // TODO add room dialogue
    if (this.roomType == 0) {
      System.out.println("You enter the shop");
    } else if (this.roomType == 1) {
      System.out.println("You come across a " + this.getCharacter(0).getName() + ", and you decide to fight it.");
    }
    System.out.println("");
    Main.sleep();
  }

  public void addCharacter(Character character) {
    this.characters.add(character);
  }

  public Character getCharacter(int index) {
    return this.characters.get(index);
  }

  @Override
  public String toString() {
    if (characters.size() > 0)
      return ("Room that has " + characters.get(0).getName());
    return ("Exit");
    // TODO fix bug here shop room should return shop not exit
  }
}
