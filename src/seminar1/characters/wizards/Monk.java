package seminar1.characters.wizards;

import seminar1.characters.wizards.BaseWizards;

import java.util.ArrayList;

public class Monk extends BaseWizards {

    public Monk(String name, int x, int y) {
        super(name, x, y);
    }
    @Override
    public String getInfo() {
        return "Монах";
    }
}
