package kg.geecktech.les8.players;

import java.util.Random;

public class Warrior extends Hero {

    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int a = 2;
        int b = 4;
        int df = a + (int) (Math.random() * ((b - a) + 1));
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] == this) {
                boss.setHealth(boss.getHealth() - (heroes[i].getDamage() * df)); //Warrior каждый раз при атаке критикует. Т.е. каждая атака умножается на случайное число от 2 до 4.
            }
            System.out.println("Warrior " + heroes[i].getDamage() + " diff " + df);

        }


    }
}
