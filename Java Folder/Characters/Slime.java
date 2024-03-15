package Characters;

import Weapons.WeaponsList;

public class Slime extends Character {

  public Slime(int level) {
    this.name = "Slime";
    this.level = level;
    this.exp = level * 10;
    this.maxHealth = level * 10 + (int) (Math.random() * 6 - 3);
    this.currHealth = this.maxHealth;
    this.attack = level * 1;
    this.defense = (int) (level * 0.5);
    this.magic = 5;
    this.gold = level * 10;
    this.weapon = WeaponsList.getWeapon(2);
  }

  @Override
  public void attack(Character defender) {
    int roll = (int) (Math.random() * 20);
    if (roll > 10) {
      acidAttack(defender);
    } else {
      basicAttack(defender);
    }
  }

  private void acidAttack(Character defender) {
    defender.setDefense(defender.getDefense() - 1);
    int damage = this.attack + 2 * this.weapon.getAttack() - defender.getDefense();
    if (damage < 0) {
      damage = 0;
    }
    defender.setCurrHealth(defender.getCurrHealth() - damage);
    System.out.println(this + " spit acid on " + defender + " for " + damage + " damage!");
  }

}
