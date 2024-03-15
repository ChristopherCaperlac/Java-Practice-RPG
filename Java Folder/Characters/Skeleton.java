package Characters;

import Weapons.WeaponsList;

public class Skeleton extends Character {

  public Skeleton(int level) {
    this.name = "Skeleton";
    this.level = level;
    this.exp = level * 10;
    this.maxHealth = level * 10 + (int) (Math.random() * 6 - 3);
    this.currHealth = this.maxHealth;
    this.attack = level * 1;
    this.defense = (int) (level * 0.5);
    this.gold = level * 10;
    this.weapon = WeaponsList.getWeapon(1);
  }

  @Override
  public void attack(Character defender) {
    int roll = (int) (Math.random() * 20);
    if (roll > 10) {
      boneAttack(defender);
    } else {
      basicAttack(defender);
    }
  }

  private void boneAttack(Character defender) {
    int damage = this.attack + 2 * this.weapon.getAttack();
    if (damage < 0) {
      damage = 0;
    }
    defender.setCurrHealth(defender.getCurrHealth() - damage);
    System.out.println(this + " bludgeoned " + defender + " for " + damage + " damage!");
  }
}