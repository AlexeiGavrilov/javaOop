package seminar1.characters;

import seminar1.characters.interfaces.ActionsOfChar;
import seminar1.characters.interfaces.Step;

import java.util.ArrayList;
import java.util.Random;

/*Проанализировать персонажей "Крестьянин, Разбойник, Снайпер, Колдун, Копейщик, Арбалетчик, Монах".
Для каждого определит 8 полей данных(здоровье, сила итд) 3-4 поля поведения(методов атаковать, вылечить итд).
Создать абстрактный класс и иерархию наследников. Расположить классы в пакет так, чтобы в основной программе небыло видно их полей.
В не абстрактных классах переопределить метод toString() так чтобы он возвращал название класса или имя.
Создать в основной программе по одному обьекту каждого не абстрактного класса и вывести в консоль его имя.

Формат сдачи:*/
abstract public class Character implements ActionsOfChar, Step {
    private static int count;
    protected String name;
    public int health;
    public int protection;
    protected Place position;
    protected int id;
    protected int priority;

    static {count =0;}
    private static Random rnd = new Random();


    public Character(String name, int x, int y) {
        count++;
        this.priority =0;
        this.position = new Place(x,y);
        this.name = name;
        this.health = 1;
        this.protection = 1;
    }

    public Character findNearestEnemy(ArrayList<Character> targetTeam){
        double minDistanse = Double.MAX_VALUE;
        Character target = null;
        for (Character character : targetTeam) {
            if (position.findDistanse(character) < minDistanse && character.getHealth()>0){
                minDistanse = position.findDistanse(character);
                target = character;
            }
        }
        return target;

    }

    public String toInfo() {
        return String.format("Type = %s; ID = %d; Name = %s; %s; Health = %d; Protection = %d",
                this.getClass().getSimpleName(),id, name, position.toString(),health, protection);
    }
    @Override
    public String toString() {
        return String.format("%s = Name; Type = %s; \u2665 = %d; \u2699 = %d;", name, this.getClass().getSimpleName(),
                health,protection);}
    public boolean heroIsDead() {
        return this.getHealth() > 0;
    }

    protected int dealDamage(int damage, Character target) {
       return 0;
    }
    public void Attack(Character target) {
        int damage = Character.rnd.nextInt(2, 4);
        Character.this.dealDamage(damage, target);
    }

    protected void setName(String name) {this.name = name;}

    public void setHealth(int health) {this.health = health;}

    public void setProtection(int protection) {this.protection = protection;}

    public String getName() {return name;}

    public int getHealth() {return health;}

    public int getProtection() {return protection;}

    public int getId() {return id;}

    public Place getPosition() {return position;}

    public static int getCount(){return count;}
    public int getPriority() {return priority;}



}
