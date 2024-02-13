package seminar1;

import seminar1.characters.*;
import seminar1.characters.Character;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Character hero1 = new Peasant(1,"Frodo",1,8,8,2,2,15);
        Character hero2 = new Bandit(2,"Aragorn", 70,60,20,15,23,60);
        Character hero3 = new Sniper(3,"Legolas", 80,50,15,3,7,40);
        Character hero4 = new Magician(4,"Gendalf", 1000, 25,13,4, 3,70);
        Character hero5 = new Spearman(5,"Boromir", 50,50,70,3,3,60);
        Character hero6 = new Crossbowman(6, "Faramir", 40,60,45,3,3,50);
        Character hero7 = new Monk(7,"Sam", 5,35,25,5,6,50);

        ArrayList<Character> ourteam = new ArrayList<>(Arrays.asList(hero1,hero2,hero3,hero4,hero5,hero6,hero7));

//        for (Character character : ourteam) {
//            System.out.println(character.toString());
//            System.out.println(character.toInfo());
//            System.out.println("--------------");
//        }



        System.out.println(hero1.getHealth());
        System.out.println();
        hero1.setHealth(10);
        System.out.println(hero1.toInfo());
        System.out.println(hero1.getHealth());


    }

}
