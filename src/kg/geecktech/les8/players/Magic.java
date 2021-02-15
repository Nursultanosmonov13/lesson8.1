package kg.geecktech.les8.players;

import java.util.Random;

public class Magic extends Hero {

    public Magic(int health, int damage) {
        super(health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int diff = 15;
        Random random = new Random();
        int df = random.nextInt(diff + 1);
        System.out.println("i - " + df);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 ) {
                boss.setHealth(boss.getHealth() - (heroes[i].getDamage() + df));
            }
            System.out.println("Магик " + df + " Добавил " + heroes[i].getClass().getSimpleName()  +" "+ heroes[i].getDamage());
        }

    }
}
