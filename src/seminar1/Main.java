package seminar1;

import seminar1.characters.*;
import seminar1.characters.Character;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static Character hero1 = new Peasant(1, "Frodo", 1, 30, 10, 4, 2, 15);
    public static Character hero2 = new Bandit(2, "Aragorn", 70, 60, 20, 15, 23, 60);
    public static Character hero3 = new Sniper(3, "Legolas", 80, 50, 15, 3, 7, 40);
    public static Character hero4 = new Magician(4, "Gendalf", 1000, 25, 13, 4, 3, 70);
    public static Character hero5 = new Spearman(5, "Boromir", 50, 50, 70, 2, 2, 60);
    public static Character hero6 = new Crossbowman(6, "Faramir", 40, 60, 45, 3, 3, 50);
    public static Character hero7 = new Monk(7, "Sam", 5, 35, 25, 5, 6, 50);

    public static void main(String[] args) {


        ArrayList<Character> ourteam = new ArrayList<>(Arrays.asList(hero1, hero2, hero3, hero4, hero5, hero6, hero7));

        for (Character character : ourteam) {
            System.out.println(character.toString());
            System.out.println(character.toInfo());
            System.out.println("--------------");
        }

        hero1.Attack(hero2);
        System.out.println(hero2.toInfo());
        System.out.println();
        hero1.heroIsDead(hero1);





    }

}
