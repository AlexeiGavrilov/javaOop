package seminar1.characters;

import javax.lang.model.element.Name;
import java.util.ArrayList;

public class Peasant extends Character {
    protected int strength;
    protected int agility;
    protected int stamina;
    public Peasant(String name, int x, int y) {
        super(name, x, y);
        this.priority = 0;
        this.health = 30;
        this.protection = 20;
        this.strength = 4;
        this.agility = 2;
        this.stamina = 15;
        this.id = Character.getCount();
    }

    @Override
    public void Attack(Character target) {super.Attack(target);}
    @Override
    public String toInfo() {
        return String.format("%s Strength = %d; Agility = %d; Stamina = %d", super.toInfo(), strength, agility, stamina);
    }

    @Override
    public void step(ArrayList<Character> targetTeam, ArrayList <Character> friends) {

    }
    @Override
    public String toString() {return super.toString();}
    public int getStrength() {return strength;}
    public int getAgility() {return agility;}
    public int getStamina() {return stamina;}
    protected void setStrength(int strength) {this.strength = strength;}
    protected void setAgility(int agility) {this.agility = agility;}
    protected void setStamina(int stamina) {this.stamina = stamina;}
}
