package seminar1.characters;

import java.util.ArrayList;

public class Magician extends Character {
    protected int intelligence;
    protected int mana;
    protected int spellAmplification;
    public Magician(String name, int x, int y) {
        super(name, x, y);
        this.priority = 1;
        this.health = 60;
        this.protection = 40;
        this.intelligence = 5;
        this.spellAmplification = 3;
        this.mana = 50;
        this.id = Character.getCount();
    }

    @Override
    public void Attack(Character target) {super.Attack(target);}
    @Override
    public String toString() {return super.toString();}
    @Override
    public String toInfo() {
        return String.format("%s ; Intelligence = %d; SpellAmplification = %d; " +
                "Mana = %d;", super.toInfo(), intelligence, spellAmplification, mana);
    }

    @Override
    public void step(ArrayList<Character> targetTeam, ArrayList <Character> friends) {

    }
    public int getIntelligence() {return intelligence;}
    public int getMana() {return mana;}
    public int getSpellAmplification() {return spellAmplification;}
    protected void setIntelligence(int intelligence) {this.intelligence = intelligence;}
    protected void setMana(int mana) {this.mana = mana;}
    protected void setSpellAmplification(int spellAmplification) {this.spellAmplification = spellAmplification;}


}

