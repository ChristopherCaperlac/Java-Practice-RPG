package Characters;

import Weapons.WeaponsList;

public class Player extends Character {

  public Player(String name) {
    this.name = name;
    this.level = 1;
    this.exp = 0;
    this.maxHealth = 100;
    this.currHealth = this.maxHealth;
    this.attack = 5;
    this.defense = 1;
    this.gold = 0;
    this.weapon = WeaponsList.getWeapon(0);
  }

  /**
   * checks if player can level up
   * and levels them up if they can
   */
  public void levelUp() {
    while (exp >= level * 20) {
      exp -= level * 20;
      level++;
      maxHealth += 10;
      currHealth = maxHealth;
      attack++;
      System.out.println(name + " leveled up!");
    }
  }

  @Override
  public void attack(Character defender) {
    // TODO More possible ways of player attacking
    basicAttack(defender);
  }

  @Override
  public String toString() { // remove this when this get fixed
    return name;
  }

}