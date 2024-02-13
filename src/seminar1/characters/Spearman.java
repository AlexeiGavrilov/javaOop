package seminar1.characters;

public class Spearman extends Character{

    protected int strength;
    protected int agility;
    protected int stamina;

    public Spearman(int id, String name, int level, int health, int protection, int strength, int agility, int stamina) {
        super(id, name, level, health, protection);
        this.health = Math.min(health, 100);
        this.protection = Math.min(protection, 80);
        this.strength = Math.min(strength, 2);
        this.agility = Math.min(agility, 2);
        this.stamina = Math.min(stamina, 60);
    }


    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String toInfo() {
        return String.format(" %s Strength = %d; Agility = %d; Stamina = %d",super.toInfo(), strength, agility, stamina);
    }
}
