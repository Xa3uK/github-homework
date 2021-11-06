package lesson13.characters;

import lesson13.weapons.WeaponBehavior;

public class Troll extends Character{
    public Troll(WeaponBehavior weapon) {
        super(weapon);
    }

    @Override
    public void fight() {
        System.out.println("\nTroll Start Fight");
        weapon.useWeapon();
    }
}
