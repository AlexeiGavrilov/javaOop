package seminar1.characters.archers;

import seminar1.characters.archers.BaseArcher;

import java.util.ArrayList;

public class Crossbowman extends BaseArcher {

    public Crossbowman(String name, int x, int y) {
        super(name, x, y);
    }
    @Override
    public String getInfo() {
        return "Арбалетчик";
    }


}
