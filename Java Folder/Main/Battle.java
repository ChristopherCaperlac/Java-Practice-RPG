package Main;

import Characters.Character;

public class Battle {
  private static Character player = Main.getPlayer();
  private static Character enemy;

  public static void setEnemy(Character enemy) {
    Battle.enemy = enemy;
  }

  public static int start() { // returns 0 if player wins, 1 if you died, 2 if ran
    System.out.println("You are now fighting a " + enemy);
    System.out.println("");
    player = Main.getPlayer();
    int actualAttack = player.getAttack();
    int actualDefense = player.getDefense();
    int input;
    int roll;
    int turn = 0;
    while (turn < 100) {
      System.out.println(player + ": " + player.getCurrHealth() + " HP");
      System.out.println(enemy + ": " + enemy.getCurrHealth() + " HP");
      System.out.println("");
      System.out.println("What would you like to do?");
      System.out.println("[1] Attack " + enemy);
      System.out.println("[2] Defend");
      System.out.println("[3] Run");
      // Player Turn
      input = 0;
      while (input != 1 && input != 2 && input != 3) {
        input = Main.getScnr().nextInt();
        Main.getScnr().nextLine();
      }
      System.out.println("");
      switch (input) {
        case 1:
          player.attack(enemy);
          break;
        case 2:
          player.setDefense(player.getDefense() + 5);
          break;
        case 3:
          roll = (int) (Math.random() * 20);
          if (roll > 10) {
            System.out.println("You managed to run away");
            return 2;
          } else {
            System.out.println("You failed to run away");
          }
          break;
      }
      System.out.println("");
      Main.sleep();

      if (enemy.getCurrHealth() <= 0) {
        System.out.println("You won!");
        return 0;
      }
      player.setAttack(actualAttack);
      // Enemy Turn
      System.out.println("It's the enemy's turn");
      System.out.println("");
      enemy.attack(player);
      Main.sleep();

      if (player.getCurrHealth() <= 0) {
        System.out.println("You died!");
        return 1;
      }
      turn++;
      player.setDefense(actualDefense);
      System.out.println("");
    }
    try {
      throw new Exception("You exceeded 100 turns");
    } catch (Exception e) {
      return 2;
    }
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
    player.setGold(player.getGold() + enemy.getGold());
    player.setExp(player.getExp() + enemy.getExp());
    System.out.println("You gained " + enemy.getGold() + " gold!");
    System.out.println("You gained " + enemy.getExp() + " exp!");
    Main.getPlayer().levelUp();
    System.out.println("");
  }

  public static void die() { // add death screen here and return to nearest checkpoint
    throw new ArithmeticException("Haven't Finished die Code Here");
  }

  public static void run() { // return to previous screen
    throw new ArithmeticException("Haven't Finished run Code Here");
  }
}