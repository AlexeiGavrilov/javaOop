package seminar1.characters;

public class Sniper extends Character {

    protected int agility;

    protected int stamina;

    protected int accuracy;

    public Sniper(int id,String name, int level, int health, int protection, int agility, int accuracy,int stamina) {
        super(id,name, level, health, protection);
        this.health = Math.min(health, 60);
        this.protection = Math.min(protection, 25);
        this.agility = Math.min(agility, 8);
        this.accuracy = Math.min(accuracy, 5);
        this.stamina = Math.min(stamina, 40);
    }

    @Override
    protected int dealDamage(int damage, Character target) {
        this.stamina -=this.accuracy/2;
        setStamina(this.stamina);
        if (target.getProtection()>0){
            target.protection -= damage*this.accuracy;
            target.setProtection(target.protection);
            target.health -= (damage*this.agility)/2;
            target.setHealth(target.health);
            return (damage*this.agility)/2;
        }else {
            target.health -= damage*this.agility;
            target.setHealth(target.health);
            return damage*this.agility;
        }
    }

    @Override
    public void Attack(Character target) {
        super.Attack(target);
    }

    @Override
    public String toInfo() {
        return String.format("%s Agility = %d, Accuracy = %d, Stamina = %d", super.toInfo(), agility,accuracy,stamina);
    }

    @Override
    public String toString() {
        return super.toString();
    }


    public int getAgility() {
        return agility;
    }

    public int getStamina() {
        return stamina;
    }

    public int getAccuracy() {
        return accuracy;
    }

    protected void setAgility(int agility) {
        this.agility = agility;
    }

    protected void setStamina(int stamina) {
        this.stamina = stamina;
    }

    protected void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
}
