package seminar1.interfaces;

import seminar1.characters.Character;

import java.util.ArrayList;

public interface ActionsOfChar {

    Character findNearestEnemy(ArrayList<Character> targetTeam);
}
