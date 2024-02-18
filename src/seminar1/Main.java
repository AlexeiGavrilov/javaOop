package seminar1;

import seminar1.characters.*;
import seminar1.characters.Character;
import seminar1.characters.forClientCode.FillTeam;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

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
        team1.get(2).Attack(team2.get(3));
        System.out.println(team1.get(3).findNearestEnemy(team2));

    }

}
