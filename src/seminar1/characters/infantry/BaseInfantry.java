package seminar1.characters.infantry;

import seminar1.characters.Character;
import seminar1.characters.Place;

import java.util.ArrayList;

public class BaseInfantry extends Character {

    protected int strength;
    protected int agility;
    protected int stamina;
    public BaseInfantry(String name, int x, int y) {
        super(name, x, y);
        this.priority = 2;
        this.health = 70;
        this.protection = 100;
        this.strength = 3;
        this.agility = 3;
        this.stamina = 40;
        this.id = Character.getCount();
    }
    @Override
    protected void dealDamage(int damage, Character target) {
        if (stamina <= 0 || (stamina -= strength * 2) < 0) {
            stamina+=20;
        } else {
            stamina -= strength * 2;
            if (target.getProtection() > 0) {
                target.protection -= damage * strength;
                target.health -= (damage * agility) / 2;
            } else {target.health -= damage * agility;}
        }
        if (target.health<0) target.health = 0;
    }
    @Override
    public void Attack(Character target) {super.Attack(target);}
    @Override
    public String toInfo() {
        return String.format("%s Strength = %d; Agility = %d; Stamina = %d", super.toInfo(), strength, agility, stamina);
    }

    @Override
    public void step(ArrayList<Character> targetTeam, ArrayList <Character> friends) {
        if (health <= 0) return;
        Character unit = findNearestEnemy(targetTeam);
        if (unit==null) return;
        if (position.findDistanse(unit) < 2) {
           Attack(unit);
           return;
        }
        Place diff = position.getDiff(unit.position);
        Place newPosition = new Place(position.x, position.y);
        if (Math.abs(diff.x) > Math.abs(diff.y))

            newPosition.x += diff.x < 0 ? 1 : -1;
        else
            newPosition.y += diff.y < 0 ? 1 : -1;
        for (Character character : friends) {
            if (character.position.equals(newPosition) && character.health > 0) return;

        }
        this.position = newPosition;
    }


    @Override
    public String toString() {return super.toString();}
    public int getStrength() {return strength;}
    public int getAgility() {return agility;}
    public int getStamina() {return stamina;}
    protected void setStrength(int strength) {this.strength = strength;}
    protected void setAgility(int agility) {this.agility = agility;}
    protected void setStamina(int stamina) {this.stamina = stamina;}

/**/

}
