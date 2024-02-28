package seminar1.characters;

import java.util.ArrayList;

public class Bandit extends Character {
    protected int strength;
    protected int agility;
    protected int stamina;
    public Bandit(String name, int x, int y) {
        super(name, x, y);
        this.priority = 2;
        this.health = 150;
        this.protection = 50;
        this.strength = 6;
        this.agility = 6;
        this.stamina = 400;
        this.id = Character.getCount();
    }
    @Override
    protected int dealDamage(int damage, Character target) {
        if (this.stamina < 0 || (this.stamina -= this.strength / 2) < 0) {
        } else {
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
        return 0;
    }
    @Override
    public void Attack(Character target) {super.Attack(target);}
    @Override
    public String toInfo() {
        return String.format("%s Strength = %d; Agility = %d; Stamina = %d", super.toInfo(), strength, agility, stamina);
    }
    @Override
    public String toString() {return super.toString();}
    public int getStrength() {return strength;}
    public int getAgility() {return agility;}
    public int getStamina() {return stamina;}
    protected void setStrength(int strength) {this.strength = strength;}
    protected void setAgility(int agility) {this.agility = agility;}
    protected void setStamina(int stamina) {this.stamina = stamina;}

    @Override
    public void step(ArrayList<Character> targetTeam, ArrayList <Character> friends) {
        Character unit = findNearestEnemy(targetTeam);
        if (unit==null) return;
        if (position.findDistanse(unit) < 2) {
            Attack(unit);
            System.out.println(toInfo());
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
}
