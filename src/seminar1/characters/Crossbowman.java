package seminar1.characters;

import java.util.ArrayList;

public class Crossbowman extends Character {
    protected  int agility;
    protected int stamina;
    protected int accuracy;

    protected int arrows;
    public Crossbowman(String name, int x, int y) {
        super(name, x, y);
        this.priority =3;
        this.arrows = 50;
        this.health = 50;
        this.protection = 40;
        this.agility = 5;
        this.accuracy = 4;
        this.stamina = 500;
        this.id = Character.getCount();
    }
    @Override
    protected int dealDamage(int damage, Character target) {
        if ((!target.heroIsDead()))  return 0;
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
    public String toInfo() {return String.format("%s Agility = %d; Accuracy = %d; Stamina = %d", super.toInfo(), agility,accuracy,stamina);}
    @Override
    public String toString() {return super.toString() + " \u2916 " + arrows;}
    @Override
    public void step(ArrayList<Character> targetTeam, ArrayList<Character> friends) {
        Character target = findNearestEnemy(targetTeam);
        if (heroIsDead() && getArrows() > 0) {
            Attack(target);
            this.arrows -= 1;
            Crossbowman.this.setArrows(this.arrows);
        }
    }
    public int getAgility() {return agility;}
    public int getStamina() {return stamina;}
    public int getAccuracy() {return accuracy;}
    protected void setAgility(int agility) {this.agility = agility;}
    protected void setStamina(int stamina) {this.stamina = stamina;}
    protected void setAccuracy(int accuracy) {this.accuracy = accuracy;}

    public int getArrows() {return arrows;}
    protected void setArrows(int arrows) {this.arrows = arrows;}
}
