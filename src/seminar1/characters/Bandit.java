package seminar1.characters;

public class Bandit extends Character {
    protected int strength;

    protected int agility;

    protected int stamina;

    public Bandit(int id,String name, int level, int health, int protection, int strength, int agility, int stamina) {
        super(id,name, level, health, protection);
        this.health = Math.min(health, 80);
        this.protection = Math.min(protection, 30);
        this.strength = Math.min(strength, 6);
        this.agility = Math.min(agility, 6);
        this.stamina = Math.min(stamina, 40);
    }
    @Override
    protected int dealDamage(int damage, Character target) {
        this.stamina -= this.strength / 2;
        setStamina(this.stamina);
        if (target.getProtection() > 0) {
            target.protection -= damage * this.strength;
            target.setProtection(target.protection);
            target.health -= (damage * this.agility) / 2;
            target.setHealth(target.health);
            return (damage * this.agility) / 2;
        } else {
            target.health -= damage * this.strength;
            target.setHealth(target.health);
            return damage * this.strength;
        }
    }

    @Override
    public void Attack(Character target) {
        super.Attack(target);
    }

    @Override
    public String toInfo() {
        return String.format(" %s Strength = %d; Agility = %d; Stamina = %d",super.toInfo(), strength, agility, stamina);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getStamina() {
        return stamina;
    }

    protected void setStrength(int strength) {
        this.strength = strength;
    }

    protected void setAgility(int agility) {
        this.agility = agility;
    }

    protected void setStamina(int stamina) {
        this.stamina = stamina;
    }
}
