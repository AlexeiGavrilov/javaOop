package seminar1.characters.infantry;

import seminar1.characters.infantry.BaseInfantry;

import java.util.ArrayList;

public class Spearman extends BaseInfantry {
    public Spearman(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public String getInfo() {
        return "Копейщик";
    }

}
