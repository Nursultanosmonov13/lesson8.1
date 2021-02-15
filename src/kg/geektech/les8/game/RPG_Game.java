package kg.geektech.les8.game;

import kg.geecktech.les8.players.*;

import java.util.Random;

public class RPG_Game {

    public static void startGame() {
        Boss boss = new Boss(700, 50);
        Warrior warrior = new Warrior(270, 20);
        Medic doc = new Medic(220, 5, 15);
        Berserk berserk = new Berserk(240, 10);
        Magic magic = new Magic(250, 25);
        //Medic assistant = new Medic(260, 10, 5);

        //Hero[] heroes = {warrior, doc, berserk, magic, assistant};
        Hero[] heroes = {berserk,magic};//{berserk, doc,warrior};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }


    }

    private static void round(Boss boss, Hero[] heroes) {
        bossHits(boss, heroes);
        //heroesHit(boss, heroes);
        applySuperAbilities(boss, heroes);
        printStatistics(boss, heroes);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("______________");
        System.out.println("Boss health: " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName()
                    + " health: " + heroes[i].getHealth());
        }
        System.out.println("--------------");
    }

    private static void applySuperAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].applySuperAbility(boss, heroes);
            }
        }
    }

   /* private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth());
            }
        }
    }*/

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());

            }
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes WON!!!");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss WON!!!");
        }
        return allHeroesDead;
    }

}
