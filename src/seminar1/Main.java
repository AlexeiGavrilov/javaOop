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
    public static ArrayList<Character> holyTeam = new ArrayList<>();
    public  static ArrayList<Character> darkTeam = new ArrayList<>();
    public static ArrayList<Character> allTeam = new ArrayList<>();

    public static void main(String[] args) {

        FillTeam.FillTeamRandomChar(holyTeam, darkTeam);

        allTeam.addAll(holyTeam);
        allTeam.addAll(darkTeam);
        allTeam.sort((o1, o2) -> o2.getPriority() - o1.getPriority());
        allTeam.forEach(n -> System.out.println(n.toInfo()));



        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag) {

            View.view();
            scanner.nextLine();
            int summ1HP = 0;
            int summ2HP = 0;
            for (Character unit : holyTeam) {
                summ1HP += unit.getHealth();
            }
            for (Character unit : darkTeam) {
                summ2HP += unit.getHealth();
            }
            if (summ1HP == 0) {

                System.out.println("Победила команда darkTeam");
                flag = false;
            }
            if (summ2HP == 0) {
                System.out.println("Победила команда holyTeam");
                flag = false;
            }
            for (Character unit : allTeam) {
                if (holyTeam.contains(unit)) unit.step(darkTeam, holyTeam);
                else unit.step(holyTeam, darkTeam);
            }


        }


    }

}
