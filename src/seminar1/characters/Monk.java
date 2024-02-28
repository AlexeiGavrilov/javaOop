package seminar1.characters;

import java.util.ArrayList;

public class Monk extends Character {
    protected int faith;
    protected int chakra;
    protected int mana;
    public Monk(String name, int x, int y) {
        super(name, x, y);
        this.priority = 1;
        this.health = 80;
        this.protection = 30;
        this.faith = 4;
        this.chakra = 3;
        this.mana = 80;
        this.id = Character.getCount();
    }

    @Override
    public void Attack(Character target) {super.Attack(target);}
    @Override
    public String toString() {return super.toString();}
    @Override
    public String toInfo() {
        return String.format("%s ; Faith = %d; Chakra = %d; " +
                " Mana = %d;", super.toInfo(), faith,chakra,mana);
    }

    @Override
    public void step(ArrayList<Character> targetTeam, ArrayList <Character> friends) {

    }
    public int getFaith() {return faith;}
    public int getChakra() {return chakra;}
    public int getMana() {return mana;}
    protected void setFaith(int faith) {this.faith = faith;}
    protected void setChakra(int chakra) {this.chakra = chakra;}
    protected void setMana(int mana) {this.mana = mana;}


}
