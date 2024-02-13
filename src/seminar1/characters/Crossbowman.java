package seminar1.characters;

public class Crossbowman extends Character {
    protected int agility;

    protected int stamina;

    protected int accuracy;

    public Crossbowman(int id, String name, int level, int health, int protection, int agility,int accuracy, int stamina) {
        super(id, name, level, health, protection);
        this.health = Math.min(health, 50);
        this.protection = Math.min(protection, 35);
        this.agility = Math.min(agility, 5);
        this.accuracy = Math.min(accuracy, 4);
        this.stamina = Math.min(stamina, 50);
    }


    @Override
    public String toInfo() {
        return String.format("%s Agility = %d; Accuracy = %d; Stamina = %d", super.toInfo(), agility,accuracy,stamina);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
