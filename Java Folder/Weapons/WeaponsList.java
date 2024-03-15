package Weapons;

import java.util.ArrayList;

public class WeaponsList {
  private static ArrayList<Weapon> weapons;

  public static void loadWeapons() {
    weapons = new ArrayList<Weapon>();
    weapons.add(new Weapon("Hands", 1));
    weapons.add(new Weapon("Bones", 1));
    weapons.add(new Weapon("Slime Acid", 2));
    weapons.add(new Weapon("Wizard Staff", 3));
    weapons.add(new Weapon("Copper Longsword", 2));
    weapons.add(new Weapon("Iron Longsword", 3));
    weapons.add(new Weapon("Silver Longsword", 4));
  }

  public static Weapon getWeapon(int index) {
    return weapons.get(index);
  }
}