package seminar1.characters;

public class Monk extends Character {

    protected int faith;
    protected int chakra;
    protected int mana;

    public Monk(int id, String name, int level, int health, int protection, int faith, int chakra, int mana) {
        super(id, name, level, health, protection);
        this.health = Math.min(health,60);
        this.protection = Math.min(protection,20);
        this.faith = Math.min(faith,6) ;
        this.chakra = Math.min(chakra,5);
        this.mana = Math.min(mana, 80);
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


}
