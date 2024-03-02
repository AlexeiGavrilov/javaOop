package seminar1.forClientCode;

import seminar1.characters.Character;
import seminar1.characters.archers.Crossbowman;
import seminar1.characters.archers.Sniper;
import seminar1.enums.Names;
import seminar1.characters.infantry.Bandit;
import seminar1.characters.infantry.Peasant;
import seminar1.characters.infantry.Spearman;
import seminar1.characters.wizards.Magician;
import seminar1.characters.wizards.Monk;

import java.util.ArrayList;
import java.util.Random;

public class FillTeam {
    public static void FillTeamRandomChar(ArrayList<Character> team1, ArrayList<Character> team2) {
        Random rnd = new Random();
        for (int i = 1; i < 11; i++) {
            switch (rnd.nextInt(0, 7)) {
                case 0:
                    team1.add(new Peasant(getName(), i, 1));
                    break;
                case 1:
                    team1.add(new Bandit(getName(), i, 1));
                    break;
                case 2:
                    team1.add(new Crossbowman(getName(), i, 1));
                    break;
                case 3:
                    team1.add(new Magician(getName(), i, 1));
                    break;
                case 4:
                    team1.add(new Monk(getName(), i, 1));
                    break;
                case 5:
                    team1.add(new Sniper(getName(), i, 1));
                    break;
                case 6:
                    team1.add(new Spearman(getName(), i, 1));
                    break;
            }

        }
        for (int i = 1; i < 11; i++) {
            switch (rnd.nextInt(0, 7)) {
                case 0:
                    team2.add(new Peasant(getName(), i, 10));
                    break;
                case 1:
                    team2.add(new Bandit(getName(), i, 10));
                    break;
                case 2:
                    team2.add(new Crossbowman(getName(), i, 10));
                    break;
                case 3:
                    team2.add(new Magician(getName(), i, 10));
                    break;
                case 4:
                    team2.add(new Monk(getName(), i, 10));
                    break;
                case 5:
                    team2.add(new Sniper(getName(), i, 10));
                    break;
                case 6:
                    team2.add(new Spearman(getName(), i, 10));
                    break;
            }
        }

    }

    private static String getName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length - 1)]);
    }
}
