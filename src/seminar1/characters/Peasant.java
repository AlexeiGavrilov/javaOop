package seminar1.characters;

import javax.lang.model.element.Name;

public class Peasant extends Character {

    protected int strength;

    protected int agility;

    protected int stamina;


    public Peasant(int id, String name, int level, int health, int protection, int strength, int agility, int stamina) {
        super(id, name, level, health, protection);
        this.health = Math.min(health, 30);
        this.protection = Math.min(strength, 10);
        this.strength = Math.min(strength, 4);
        this.agility = Math.min(agility, 2);
        this.stamina = Math.min(stamina, 15);
    }

    @Override
    public String toInfo() {
        return String.format("%s Strength = %d; Agility = %d; Stamina = %d", super.toInfo(), strength, agility, stamina);
    }

    @Override
    public String toString() {
        return super.toString();
    }


    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
}
