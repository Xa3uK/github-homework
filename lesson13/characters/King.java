package lesson13.characters;


import lesson13.weapons.WeaponBehavior;

public class King extends Character{
    public King(WeaponBehavior weapon) {
        super(weapon);
    }

    @Override
    public void fight() {
        System.out.println("\nKing Start Fight");
        weapon.useWeapon();
    }
}
