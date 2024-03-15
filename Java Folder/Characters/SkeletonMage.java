package Characters;

import Weapons.WeaponsList;

public class SkeletonMage extends Skeleton {

  public SkeletonMage(int level) {
    super(level);
    this.name = "Skeleton Mage";
    this.magic = 10;
    this.weapon = WeaponsList.getWeapon(3);
  }

  @Override
  public void attack(Character defender) {
    int roll = (int) (Math.random() * 20);
    if (roll > 12) {
      castFireBall(defender);
    } else if (roll > 5) {
      basicAttack(defender);
    }
    roll = (int) (Math.random() * 20);
    if (roll > 10) {
      armorDown(defender);
    } else if (roll > 5) {
      attackDown(defender);
    }
    roll = (int) (Math.random() * 20);
    if (roll > 10)
      heal();
  }

  private void castFireBall(Character defender) {
    int damage = this.attack + 3 * this.weapon.getAttack();
    if (damage < 0) {
      damage = 0;
    }
    defender.setCurrHealth(defender.getCurrHealth() - damage);
    System.out.println(this + " casted a fire ball at " + defender + " for " + damage + " damage!");
  }

  private void heal() {
    int roll = (int) (Math.random() * 3) + 1;
    currHealth += roll;
    if (currHealth > maxHealth)
      currHealth = maxHealth;
    System.out.println(this + " healed for " + roll + " HP");
  }

  private void attackDown(Character defender) {
    defender.setAttack(defender.getAttack() - 2);
    System.out.println(this + " casted Attack Down on " + defender);
  }

  private void armorDown(Character defender) {
    defender.setDefense(defender.getDefense() - 2);
    System.out.println(this + " casted Armor Down on " + defender);
  }

}