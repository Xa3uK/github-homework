package lesson13.characters;

import lesson13.weapons.WeaponBehavior;

public class Knight extends Character{
    public Knight(WeaponBehavior weapon) {
        super(weapon);
    }

    @Override
    public void fight() {
        System.out.println("\nKnight Start Fight");
        weapon.useWeapon();
    }
}
