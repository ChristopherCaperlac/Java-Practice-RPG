package Weapons;

public class Weapon {
  private String name;
  private int attack;

  public Weapon(String name, int attack) {
    this.name = name;
    this.attack = attack;
  }

  public String getName() {
    return this.name;
  }

  public int getAttack() {
    return this.attack;
  }

  @Override
  public String toString() {
    return (name + ": " + attack + " attack");
  }
}