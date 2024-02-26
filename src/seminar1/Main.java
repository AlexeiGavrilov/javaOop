package seminar1;

import com.sun.source.tree.IfTree;
import seminar1.characters.*;
import seminar1.characters.Character;
import seminar1.characters.forClientCode.FillTeam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Character> team1 = new ArrayList<>();
        ArrayList<Character> team2 = new ArrayList<>();
        FillTeam.FillTeamRandomChar(team1, team2);
        ArrayList<Character> all = new ArrayList<>();
        all.addAll(team1);
        all.addAll(team2);
        all.sort((o1, o2) -> o2.getPriority()- o1.getPriority());
        all.forEach(n->System.out.println(n.toInfo()));

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            if (scanner.nextLine() == ""){
                for (Character character : all) {
                    if (team1.contains(character)) character.step(team2, team1);
                    else character.step(team1, team2);
                }
            } else flag = false;
        }
    }

}
