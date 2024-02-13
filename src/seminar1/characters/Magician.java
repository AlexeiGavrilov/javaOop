package seminar1.characters;

public class Magician extends Character {

    protected int intelligence;
    protected int mana;
    protected int spellAmplification;

    public Magician(int id, String name, int level, int health, int protection, int intelligence,int spellAmplification, int mana) {
        super(id, name, level, health, protection);
        this.health = Math.min(health,80);
        this.protection = Math.min(protection,30);
        this.intelligence = Math.min(intelligence, 5);
        this.spellAmplification = Math.min(spellAmplification, 3);
        this.mana = Math.min(mana, 50);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String toInfo() {
        return String.format("%s ; Intelligence = %d; SpellAmplification = %d; " +
                "Mana = %d;", super.toInfo(), intelligence,spellAmplification,mana);
    }
}
