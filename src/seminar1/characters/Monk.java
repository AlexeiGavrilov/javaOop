package seminar1.characters;

public class Monk extends Character {

    protected int faith;
    protected int chakra;
    protected int mana;

    public Monk(int id,String name, int level, int health, int protection, int faith, int chakra, int mana) {
        super(id,name, level, health, protection);
        this.health = Math.min(health,60);
        this.protection = Math.min(protection,20);
        this.faith = Math.min(faith,4) ;
        this.chakra = Math.min(chakra,3);
        this.mana = Math.min(mana, 80);
    }

    @Override
    protected int dealDamage(int damage, Character target) {
        this.mana -=this.faith/2;
        setMana(this.mana);
        if (target.getProtection()>0){
            target.protection -= damage*this.faith;
            target.setProtection(target.protection);
            target.health -= (damage*this.chakra)/2;
            target.setHealth(target.health);
            return (damage*this.chakra)/2;
        }else {
            target.health -= damage*this.chakra;
            target.setHealth(target.health);
            return damage*this.chakra;
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
        return String.format("%s ; Faith = %d; Chakra = %d; " +
                " Mana = %d", super.toInfo(), faith,chakra,mana);
    }

    public int getFaith() {
        return faith;
    }

    public int getChakra() {
        return chakra;
    }

    public int getMana() {
        return mana;
    }

    protected void setFaith(int faith) {
        this.faith = faith;
    }

    protected void setChakra(int chakra) {
        this.chakra = chakra;
    }

    protected void setMana(int mana) {
        this.mana = mana;
    }
}
