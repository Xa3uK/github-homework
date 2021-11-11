package lesson13.characters;

import lesson13.weapons.WeaponBehavior;

public abstract class Character {
    private WeaponBehavior weapon;
    private final String name;

    public Character(WeaponBehavior weapon, String name) {
        this.weapon = weapon;
        this.name = name;
    }

    public void fight() {
        System.out.println(getClass().getSimpleName() + " " + name + " start fight!");
        weapon.useWeapon();
        System.out.println();
    }

    public void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }
}
