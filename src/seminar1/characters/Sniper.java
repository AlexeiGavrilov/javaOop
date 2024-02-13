package seminar1.characters;

public class Sniper extends Character {

    protected int agility;

    protected int stamina;

    protected int accuracy;

    public Sniper(int id, String name, int level, int health, int protection, int agility, int accuracy,int stamina) {
        super(id, name, level, health, protection);
        this.health = Math.min(health, 60);
        this.protection = Math.min(protection, 25);
        this.agility = Math.min(agility, 8);
        this.accuracy = Math.min(accuracy, 5);
        this.stamina = Math.min(stamina, 40);
    }

    @Override
    public String toInfo() {
        return String.format("%s Agility = %d, Accuracy = %d, Stamina = %d", super.toInfo(), agility,accuracy,stamina);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
