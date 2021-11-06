package lesson13.characters;

import lesson13.weapons.WeaponBehavior;

public class Queen extends Character{
    public Queen(WeaponBehavior weapon) {
        super(weapon);
    }

    @Override
    public void fight() {
        System.out.println("\nQueen Start Fight");
        weapon.useWeapon();
    }
}
