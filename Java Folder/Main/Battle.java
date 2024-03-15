package Main;

import java.util.ArrayList;

import Characters.Character;

public class Battle {
  private static Character player = Main.getPlayer();
  private static ArrayList<Character> enemy = new ArrayList<Character>();
  private static ArrayList<Character> defeatedEnemy = new ArrayList<Character>();

  public static void setEnemy(ArrayList<Character> enemy) {
    Battle.enemy = enemy;
  }

  public static int start() { // returns 0 if player wins, 1 if you died, 2 if ran
    System.out.println("You are now fighting " + enemy);
    System.out.println("");
    player = Main.getPlayer();
    int actualAttack = player.getAttack();
    int actualDefense = player.getDefense();
    int input;
    int roll;
    int turn = 0;
    while (turn < 100) {
      System.out.println(player + ": " + player.getCurrHealth() + " HP");
      for (int i = 0; i < enemy.size(); i++) {
        System.out.println(enemy.get(i) + ": " + enemy.get(i).getCurrHealth() + " HP");
      }
      System.out.println("");
      System.out.println("What would you like to do?");
      for (int i = 1; i < enemy.size() + 1; i++) {
        System.out.println("[" + i + "]" + " Attack " + enemy.get(i - 1));
      }
      System.out.println("[" + (enemy.size() + 1) + "] Defend");
      System.out.println("[" + (enemy.size() + 2) + "] Run");
      // Player Turn
      input = 0;
      while (input < 1 || input > enemy.size() + 2) {
        input = Main.getScnr().nextInt();
        Main.getScnr().nextLine();
      }
      System.out.println("");
      if (input <= enemy.size())
        player.attack(enemy.get(input - 1));
      if (input == enemy.size() + 1)
        player.setDefense(player.getDefense() + 5);
      if (input == enemy.size() + 2) {
        roll = (int) (Math.random() * 20);
        if (roll > 10) {
          System.out.println("You managed to run away");
          return 2;
        } else {
          System.out.println("You failed to run away");
        }
      }
      System.out.println("");
      Main.sleep();

      if (!enemy.get(input - 1).getIsAlive())
        defeatedEnemy.add(enemy.remove(input - 1));
      if (enemy.isEmpty()) {
        System.out.println("You won!");
        return 0;
      }
      player.setAttack(actualAttack);
      // Enemy Turn
      System.out.println("It's the enemy's turn");
      System.out.println("");
      for (int i = 0; i < enemy.size(); i++) {
        enemy.get(i).attack(player);
        Main.sleep();
        if (player.getIsAlive())
          continue;
        System.out.println("You died!");
        return 1;
      }
      turn++;
      player.setDefense(actualDefense);
      System.out.println("");
      // TODO add turn based status effects here
      if (!enemy.isEmpty())
        continue;
      System.out.println("You won!");
      return 0;
    }
    System.out.println("You exceeded 100 turns");
    return 2;
  }

  public static void result(int result) { // if 0, reward(). if 1, die(), if 2 run()
    switch (result) {
      case 0:
        reward();
        break;
      case 1:
        die();
        break;
      case 2:
        run();
        break;
      default:
        throw new ArithmeticException("Incorrect Result: Must be 0, 1, or 2!");
    }
    Main.sleep();
  }

  public static void reward() { // player is rewarded
    int sumGold = 0;
    int sumExp = 0;
    for (int i = 0; i < defeatedEnemy.size(); i++) {
      sumGold += defeatedEnemy.get(i).getGold();
      sumExp += defeatedEnemy.get(i).getExp();
    }
    player.setGold(player.getGold() + sumGold);
    player.setExp(player.getExp() + sumExp);
    System.out.println("You gained " + sumGold + " gold!");
    System.out.println("You gained " + sumExp + " exp!");
    Main.getPlayer().levelUp();
    System.out.println("");
  }

  public static void die() {
    // TODO add death screen here and return to nearest checkpoint
    throw new ArithmeticException("Haven't Finished die Code Here");
  }

  public static void run() {
    // TODO add return to previous screen
    throw new ArithmeticException("Haven't Finished run Code Here");
  }
}