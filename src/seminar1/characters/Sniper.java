package seminar1.characters;

public class Sniper extends Character {
    protected int agility;
    protected int stamina;
    protected int accuracy;
    public Sniper(String name, int x, int y) {
        super(name, x, y);
        this.health = 60;
        this.protection = 25;
        this.agility = 6;
        this.accuracy = 5;
        this.stamina = 40;
        this.id = Character.getCount();
    }
    @Override
    protected int dealDamage(int damage, Character target) {
        if (this.stamina < 0 || (this.stamina -= this.accuracy / 2) < 0) {
            System.out.printf("Игроку %s не хватает ресурсов нанести удар", this.name);
        }else {
            this.stamina -= this.accuracy / 2;
            setStamina(this.stamina);
            if (target.getProtection() > 0) {
                target.protection -= damage * this.accuracy;
                target.setProtection(target.protection);
                target.health -= (damage * this.agility) / 2;
                target.setHealth(target.health);
                return (damage * this.agility) / 2;
            } else {
                target.health -= damage * this.agility;
                target.setHealth(target.health);
                return damage * this.agility;
            }
        }
        return 0;
    }
    @Override
    public void Attack(Character target) {super.Attack(target);}
    @Override
    public String toInfo() {
        return String.format("%s Agility = %d, Accuracy = %d, Stamina = %d;", super.toInfo(), agility,accuracy,stamina);
    }
    @Override
    public String toString() {return super.toString();}
    public int getAgility() {return agility;}
    public int getStamina() {return stamina;}
    public int getAccuracy() {return accuracy;}
    protected void setAgility(int agility) {this.agility = agility;}
    protected void setStamina(int stamina) {this.stamina = stamina;}
    protected void setAccuracy(int accuracy) {this.accuracy = accuracy;}

}
