package lesson13.characters;

import lesson13.weapons.WeaponBehavior;

public abstract class Character {
    protected WeaponBehavior weapon;

    public Character(WeaponBehavior weapon) {
        this.weapon = weapon;
    }

    public void fight() {
        System.out.println("Simple fight");
    }

    public void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }
}
