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


    public Character(int id, String name, int level, int health, int protection) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.health = health;
        this.protection = protection;

    }

    public String toInfo() {
        return String.format("Id = %d; Name = %s; Level = %d; Health = %d; Protection = %d", id, name, level, health, protection);
    }

    @Override
    public String toString() {
        return String.format("Type = %s; Name = %s", this.getClass().getSimpleName(), name);
    }

    public void heroIsDead(Character target) {
        if (target.getHealth() <= 0) {
            System.out.printf("%s dead.", target.getName());
        } else System.out.printf("%s is life left %d, protection left %d\n",target.getName(), target.getHealth(),
                target.getProtection());

    }

    protected int dealDamage(int damage, Character target) {
        if (target.protection>0){
            target.protection -= damage*2;
            setProtection(target.protection);
            target.health -= damage/2;
            setHealth(target.health);
            return damage/2;
        }else {
            target.health -= damage+10;
            setHealth(target.health);
            return damage+10;
        }

    }
    public void Attack(Character target) {
        int damage = Character.rnd.nextInt(2, 4);
        System.out.printf("%s caused damage %d to %s!\n",this.getName(),Character.this.dealDamage(damage, target), target.getName());
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
