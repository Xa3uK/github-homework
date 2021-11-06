package lesson13;

import lesson13.characters.*;
import lesson13.characters.Character;
import lesson13.weapons.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Character> characters = characterFactory();
        doFight(characters);
        massWeaponSetter(characters, new AxeBehavior());
        System.out.println("\nFight after switch weapons:");
        doFight(characters);
    }

    public static List<Character> characterFactory() {
        return List.of(
                new King(new SwordBehavior()),
                new Queen(new BowAndArrowBehavior()),
                new Knight(new AxeBehavior()),
                new Troll(new KnifeBehavior())
        );
    }

    public static void doFight(List<Character> characters) {
        for (Character c : characters) {
            c.fight();
        }
    }

    public static void massWeaponSetter(List<Character> characters, WeaponBehavior weapon) {
        for (Character c : characters) {
            c.setWeapon(weapon);
        }
    }
}
