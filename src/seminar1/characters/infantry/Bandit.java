package seminar1.characters.infantry;

import seminar1.characters.infantry.BaseInfantry;

import java.util.ArrayList;

public class Bandit extends BaseInfantry {

    public Bandit(String name, int x, int y) {
        super(name, x, y);
    }

    public String getInfo() {
        return "Воин";
    }
}
