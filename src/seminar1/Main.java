package seminar1;

import com.sun.source.tree.IfTree;
import seminar1.characters.*;
import seminar1.characters.Character;
import seminar1.characters.forClientCode.FillTeam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        ArrayList<Character> team1 = new ArrayList<>();
        ArrayList<Character> team2 = new ArrayList<>();
        FillTeam.FillTeamRandomChar(team1, team2);
//        ArrayList<Character> all = new ArrayList<>();
//        all.addAll(team1);
//        all.addAll(team2);
//        all.sort((o1, o2) -> o2.getPriority()- o1.getPriority());
//        all.forEach(n->System.out.println(n.toInfo()));

        team1.sort(((o1, o2) -> o2.getPriority()- o1.getPriority()));
        team2.sort(((o1, o2) -> o2.getPriority()- o1.getPriority()));
        team1.forEach(n-> System.out.println(n.toInfo()));
        System.out.println("-".repeat(16));
        team2.forEach(n-> System.out.println(n.toInfo()));
        System.out.println("-".repeat(16));
        team1.forEach(n->n.step(team2));
        System.out.println("-".repeat(16));
        team2.forEach(n->n.step(team1));


    }

}
