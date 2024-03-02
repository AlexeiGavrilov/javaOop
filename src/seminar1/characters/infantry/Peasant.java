package seminar1.characters.infantry;

import seminar1.characters.Character;
import seminar1.characters.infantry.BaseInfantry;

import javax.lang.model.element.Name;
import java.util.ArrayList;

public class Peasant extends BaseInfantry {

    public boolean flag;

    public Peasant(String name, int x, int y) {
        super(name, x, y);
        this.priority = 0;
        this.health = 30;
        this.protection = 80;
        this.strength = 4;
        this.agility = 2;
        this.stamina = 15;
        this.flag = false;
        this.id = Character.getCount();
    }

    @Override
    public void step(ArrayList<Character> targetTeam, ArrayList <Character> friends) {
        if (health <= 0) return;
        flag = false;
    }
    @Override
    public String getInfo() {
        return "Фермер";
    }

}
