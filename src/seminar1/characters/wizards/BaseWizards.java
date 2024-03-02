package seminar1.characters.wizards;

import seminar1.characters.Character;

import java.util.ArrayList;

public class BaseWizards extends Character{
    protected int intelligence;
    protected int mana;
    protected int spellAmplification;


    boolean flag;
    public BaseWizards(String name, int x, int y) {
        super(name, x, y);
        this.priority = 1;
        this.health = 60;
        this.protection = 40;
        this.mana = 25;
        this.id = Character.getCount();
        this.flag = false;


    }
    @Override
    public void Attack(Character target) {super.Attack(target);}
    @Override
    public String toString() {return super.toString() + "☯\uFE0F;" + mana;}
    @Override
    public String toInfo() {
        return String.format("%s ; Intelligence = %d; SpellAmplification = %d; " +
                "Mana = %d;", super.toInfo(), intelligence, spellAmplification, mana);
    }

    @Override
    public void step(ArrayList<Character> targetTeam, ArrayList <Character> friends) {
        if (getHealth()<= 0) return;
        ArrayList<Character> sortlist = new ArrayList<>(friends);
        ArrayList<Character> deadlist = new ArrayList<>();
        sortlist.sort((o1, o2) -> o1.getHealth() - o2.getHealth());
        for (Character character : sortlist) {
            if (character.getHealth()<=0) deadlist.add(character);
        }
        if (deadlist.size() >= 3 ) {flag = true;}
        if (flag && mana == 10) {
            deadlist.sort((o1, o2) -> o2.getPriority() - o1.getPriority());
            deadlist.get(0).health = maxHealth;
            mana = 0;
            flag = false;
            return;
        }
        if (flag) {
            mana++;
            return;
        }
        if (mana < 2) {
            mana++;
            return;
        }
        for (int i = 0; i < sortlist.size(); i++) {
            if (sortlist.get(i).heroIsDead()) {
                sortlist.get(i).health += 10;
                mana -= 2;
                break;
            }
        }


    }

    public int getIntelligence() {return intelligence;}
    public int getMana() {return mana;}
    public int getSpellAmplification() {return spellAmplification;}
    protected void setIntelligence(int intelligence) {this.intelligence = intelligence;}
    protected void setMana(int mana) {this.mana = mana;}
    protected void setSpellAmplification(int spellAmplification) {this.spellAmplification = spellAmplification;}

}
