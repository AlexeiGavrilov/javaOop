package seminar1.characters;

public class Magician extends Character {

    protected int intelligence;
    protected int mana;
    protected int spellAmplification;

    public Magician(int id, String name, int level, int health, int protection, int intelligence,int spellAmplification, int mana) {
        super(id,name, level, health, protection);
        this.health = Math.min(health,80);
        this.protection = Math.min(protection,30);
        this.intelligence = Math.min(intelligence, 5);
        this.spellAmplification = Math.min(spellAmplification, 3);
        this.mana = Math.min(mana, 50);
    }

    @Override
    protected int dealDamage(int damage, Character target) {
        this.mana -=this.intelligence/2;
        setMana(this.mana);
        if (target.getProtection()>0){
            target.protection -= damage*this.intelligence;
            target.setProtection(target.protection);
            target.health -= (damage*this.spellAmplification)/2;
            target.setHealth(target.health);
            return (damage*this.spellAmplification)/2;
        }else {
            target.health -= damage*this.spellAmplification;
            target.setHealth(target.health);
            return damage*this.spellAmplification;
        }
    }

    @Override
    public void Attack(Character target) {
        super.Attack(target);
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

    public int getIntelligence() {
        return intelligence;
    }

    public int getMana() {
        return mana;
    }

    public int getSpellAmplification() {
        return spellAmplification;
    }

    protected void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    protected void setMana(int mana) {
        this.mana = mana;
    }

    protected void setSpellAmplification(int spellAmplification) {
        this.spellAmplification = spellAmplification;
    }
}
