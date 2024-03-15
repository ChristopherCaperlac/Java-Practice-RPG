package Characters;

import Weapons.Weapon;

public abstract class Character {
  protected String name;
  protected int level;
  protected int exp;
  protected int maxHealth;
  protected int currHealth;
  protected int attack;
  protected int defense;
  protected int gold;
  protected Weapon weapon;

  public Character() {
    this.name = "";
    this.level = 1;
    this.exp = 0;
    this.maxHealth = 0;
    this.currHealth = 0;
    this.attack = 0;
    this.defense = 0;
    this.gold = 0;
    this.weapon = null;
  }

  public Character(int level) {
    this.name = "";
    this.level = level;
    this.exp = 0;
    this.maxHealth = 0;
    this.currHealth = 0;
    this.attack = 0;
    this.defense = 0;
    this.gold = 0;
    this.weapon = null;
  }

  public Character(String name, int level, int maxHealth, int attack, int defense) {
    this.name = name;
    this.level = level;
    this.exp = 0;
    this.maxHealth = maxHealth;
    this.currHealth = this.maxHealth;
    this.attack = attack;
    this.defense = defense;
    this.gold = 0;
    this.weapon = null;
  }

  /**
   * @param defender
   *                 please set up how this character
   *                 will attack the defender
   */
  public abstract void attack(Character defender);

  /**
   * @param defender
   *                 override this method if you want a more complicated
   *                 basic attack
   */
  protected void basicAttack(Character defender) {
    int damage = this.attack + this.weapon.getAttack() - defender.getDefense();
    if (damage < 0) {
      damage = 0;
    }
    defender.setCurrHealth(defender.getCurrHealth() - damage);
    System.out.println(this + " attacked " + defender + " for " + damage + " damage!");
  }

  public String toString() {
    // TODO should print out stats of character
    return ("Lv. " + level + " " + name);
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getExp() {
    return this.exp;
  }

  public void setExp(int exp) {
    this.exp = exp;
  }

  public int getMaxHealth() {
    return this.maxHealth;
  }

  public void setMaxHealth(int maxHealth) {
    this.maxHealth = maxHealth;
  }

  public int getCurrHealth() {
    return this.currHealth;
  }

  public void setCurrHealth(int health) {
    this.currHealth = health;
  }

  public Weapon getWeapon() {
    return this.weapon;
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  public int getAttack() {
    return this.attack;
  }

  public void setAttack(int attack) {
    this.attack = attack;
    if (this.attack < 0)
      this.attack = 0;
  }

  public int getDefense() {
    return this.defense;
  }

  public void setDefense(int defense) {
    this.defense = defense;
    if (this.defense < 0)
      this.defense = 0;
  }

  public int getGold() {
    return this.gold;
  }

  public void setGold(int gold) {
    this.gold = gold;
  }
}