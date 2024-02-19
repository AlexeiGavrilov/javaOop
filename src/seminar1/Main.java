package seminar1;

import seminar1.characters.*;
import seminar1.characters.Character;
import seminar1.characters.forClientCode.FillTeam;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
/*    public static ArrayList<Character> team1 = new ArrayList<>();
    public static ArrayList<Character> team2 = new ArrayList<>();
     FillTeam.FillTeamRandomChar(team1, team2);
    */ // То что я хотел бы реализовать
    public static void main(String[] args) {
        ArrayList<Character> team1 = new ArrayList<>();
        ArrayList<Character> team2 = new ArrayList<>();
        FillTeam.FillTeamRandomChar(team1, team2);
        for (Character character : team1) {
            System.out.println(character.toInfo());
        }
        System.out.println();
        for (Character character : team2) {
            System.out.println(character.toInfo());
        }

        for (Character character : team2) {
            if (character instanceof Sniper){
                character.step(team1);
            }

        }



    }

}
