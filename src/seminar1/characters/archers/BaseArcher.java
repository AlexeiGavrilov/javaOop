package seminar1.characters.archers;

import seminar1.characters.Character;
import seminar1.characters.Sniper;

import java.util.ArrayList;

public class BaseArcher extends Character {

    protected int agility;
    protected int stamina;
    protected int accuracy;
    protected int arrows;

    public BaseArcher(String name, int x, int y) {
        super(name, x, y);
        this.priority = 3;
        this.arrows = 60;
        this.health = 50;
        this.protection = 50;
        this.agility = 6;
        this.accuracy = 5;
        this.stamina = 400;
        this.id = Character.getCount();
    }

    @Override
    protected int dealDamage(int damage, Character target) {
        if (stamina < 0 || (stamina -= accuracy / 2) < 0) {
            return 0;
        } else {
            stamina -= accuracy / 2;
            if (target.getProtection() > 0) {
                target.protection -= damage * accuracy;
                target.setProtection(target.protection);
                target.health -= (damage * agility) / 2;
                target.setHealth(target.health);
                return (damage * agility) / 2;
            } else {
                target.health -= damage * agility;
                target.setHealth(target.health);
                return damage * agility;
            }
        }

    }
    @Override
    public void Attack(Character target) {super.Attack(target);}
    @Override
    public String toInfo() {
        return String.format("%s Agility = %d, Accuracy = %d, Stamina = %d;", super.toInfo(), agility,accuracy,stamina);
    }
    @Override
    public void step(ArrayList<Character> targetTeam, ArrayList<Character> friends) {
        Character target = findNearestEnemy(targetTeam);
        if (heroIsDead() && getArrows() > 0) {
            Attack(target);
            this.arrows -= 1;
        }
    }
    @Override
    public String toString() {return super.toString()+ " \u2916 " + arrows;}
    public int getAgility() {return agility;}
    public int getStamina() {return stamina;}
    public int getAccuracy() {return accuracy;}
    protected void setAgility(int agility) {this.agility = agility;}
    protected void setStamina(int stamina) {this.stamina = stamina;}
    protected void setAccuracy(int accuracy) {this.accuracy = accuracy;}
    public int getArrows() {return arrows;}
    public void setArrows(int arrows) {this.arrows = arrows;}





}
