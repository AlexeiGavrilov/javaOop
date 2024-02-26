package seminar1.characters;

import java.util.ArrayList;

public class Spearman extends Character{
    protected int strength;
    protected int agility;
    protected int stamina;
    public Spearman(String name, int x, int y) {
        super(name, x, y);
        this.priority = 2;
        this.health = 100;
        this.protection = 80;
        this.strength = 2;
        this.agility = 2;
        this.stamina = 60;
        this.id = Character.getCount();
    }
    @Override
    protected int dealDamage(int damage, Character target) {
        if (this.stamina<0 || (this.stamina -= this.strength / 2)<0){
            System.out.printf("Игроку %s не хватает ресурсов нанести удар",this.name);
        }else {
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
    public String toString() {return super.toString();}
    @Override
    public String toInfo() {
        return String.format("%s Strength = %d; Agility = %d; Stamina = %d;",super.toInfo(), strength, agility, stamina);
    }
    @Override
    public void step(ArrayList<Character> targetTeam, ArrayList <Character> friends) {
        if (!heroIsDead()) return;
        Character unit = findNearestEnemy(targetTeam);
        if (position.findDistanse(unit) < 2) {
            Attack(unit);
            System.out.println(toInfo());
            return;
        }
        Place diff = this.position.getDiff(unit.position);
        Place currentPos = new Place(position.getX(), position.getY());
        if (Math.abs(diff.getX()) > Math.abs(diff.getY())) {
            position.setX(position.getX() + diff.getX() > 0 ?  1 : -1);
            System.out.println(toInfo());
        } else position.setY(position.getY() + diff.getY() > 0 ?  1 : -1);
        System.out.println(toInfo());
        friends.forEach(n -> {
            if (n.position.equals(position)) {
                this.position = currentPos;
            }
        });
    }
    public int getStrength() {return strength;}
    public int getAgility() {return agility;}
    public int getStamina() {return stamina;}
    protected void setStrength(int strength) {this.strength = strength;}
    protected void setAgility(int agility) {this.agility = agility;}
    protected void setStamina(int stamina) {this.stamina = stamina;}

}
