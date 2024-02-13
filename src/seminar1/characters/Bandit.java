package seminar1.characters;

public class Bandit extends Character {
    protected int strength;

    protected int agility;

    protected int stamina;

    public Bandit(int id, String name, int level, int health, int protection, int strength, int agility, int stamina) {
        super(id, name, level, health, protection);
        this.health = Math.min(health, 80);
        this.protection = Math.min(protection, 30);
        this.strength = Math.min(strength, 5);
        this.agility = Math.min(agility, 6);
        this.stamina = Math.min(stamina, 40);
    }

    @Override
    public String toInfo() {
        return String.format(" %s Strength = %d; Agility = %d; Stamina = %d",super.toInfo(), strength, agility, stamina);
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
