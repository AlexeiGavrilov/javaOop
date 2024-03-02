package seminar1.characters.archers;

import seminar1.characters.Character;
import seminar1.characters.infantry.Peasant;

import java.util.ArrayList;

public class BaseArcher extends Character {

    protected int agility;
    protected int stamina;
    protected int accuracy;
    protected int arrows;

    public BaseArcher(String name, int x, int y) {
        super(name, x, y);
        this.priority = 3;
        this.arrows = 20;
        this.health = 80;
        this.protection = 50;
        this.agility = 4;
        this.accuracy = 4;
        this.stamina = 400;
        this.id = Character.getCount();
    }

    @Override
    protected void dealDamage(int damage, Character target) {
        if (stamina < 0 || (stamina -= accuracy / 2) < 0) {
            stamina+=20;
        } else {
            stamina -= accuracy / 2;
            if (target.getProtection() > 0) {
                target.protection -= damage * accuracy;
                target.health -= (damage * agility) / 2;

            } else {target.health -= damage * agility;}
        }
        if (target.health<0) target.health = 0;
    }
    @Override
    public void Attack(Character target) {super.Attack(target);}
    @Override
    public String toInfo() {
        return String.format("%s Agility = %d, Accuracy = %d, Stamina = %d;", super.toInfo(), agility,accuracy,stamina);
    }
    @Override
    public void step(ArrayList<Character> targetTeam, ArrayList<Character> friends) {
        if ((health <=0 || arrows <=0 )) return;
        Character target = findNearestEnemy(targetTeam);
        if (target == null) return;
        Attack(target);
        for (Character friend : friends) {
            if (friend.getInfo().equals("Фермер") && !((Peasant)friend).flag){
                ((Peasant)friend).flag = true;
                return;
            }
        }
        arrows--;
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
