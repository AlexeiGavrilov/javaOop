package seminar1.characters;

import com.sun.source.tree.IfTree;

import java.util.Random;
import java.util.SortedMap;

/*Проанализировать персонажей "Крестьянин, Разбойник, Снайпер, Колдун, Копейщик, Арбалетчик, Монах".
Для каждого определит 8 полей данных(здоровье, сила итд) 3-4 поля поведения(методов атаковать, вылечить итд).
Создать абстрактный класс и иерархию наследников. Расположить классы в пакет так, чтобы в основной программе небыло видно их полей.
В не абстрактных классах переопределить метод toString() так чтобы он возвращал название класса или имя.
Создать в основной программе по одному обьекту каждого не абстрактного класса и вывести в консоль его имя.

Формат сдачи:*/
abstract public class Character {
    protected int id;
    protected String name;
    protected int level;
    protected int health;
    protected int protection;

    private static Random rnd = new Random();



    public Character(int id, String name, int level, int health,int protection) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.health = health;
        this.protection = protection;

    }

    public String toInfo() {
        return String.format("Id = %d; Name = %s; Level = %d; Health = %d; Protection = %d", id,name,level,health,protection);
    }

    @Override
    public String toString() {
        return String.format("Type = %s; Name = %s", this.getClass().getSimpleName(), name );
    }

    public void heroIsDead(Character target){
        if (target.getHealth()<=0){
            System.out.printf("%s dead.", target.getName());
        }else System.out.printf("There is life left %d", target.getHealth());

    }

    protected int GetDamage(int damage,Character target){
       target.health -= damage;
       return target.health;

    }
    public void Attack(Character target) {
        int damage = Character.rnd.nextInt(1,5);
        System.out.printf("Нанесено урона %d\n", damage);
//        target.GetDamage(damage,target);
        System.out.println(target.getHealth()+ " текущее здоровье\n");
        target.setHealth(target.GetDamage(damage,target));
        System.out.println(target.getHealth()+ " после сета\n");
        heroIsDead(target);

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }


    //    public void healed(int Hp) {
//        this.hp = Hp + this.hp > this.maxHp ? this.maxHp : Hp + this.hp;
//    }
//
//    public void GetDamage(int damage) {
//        if (this.hp - damage > 0) {
//            this.hp -= damage;
//        }
//        // else { die(); }
//    }
//
//    public void Attack(BaseHero target) {
//        int damage = BaseHero.r.nextInt(10, 20);
//        target.GetDamage(damage);
//    }







    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getProtection() {
        return protection;
    }




}
