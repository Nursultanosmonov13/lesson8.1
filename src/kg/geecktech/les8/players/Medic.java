package kg.geecktech.les8.players;

public class Medic extends Hero {

    private int healPoints;

    public Medic(int health, int damage, int healPoints) {
        super(health, damage, SuperAbility.HEAL);
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] != this && heroes[i].getHealth() > 0) {

                heroes[i].setHealth(heroes[i].getHealth() + healPoints);
                // System.out.println("_________________________");
                System.out.println("Медик лечил " + heroes[i].getClass().getSimpleName() + " - " + healPoints + "=" + heroes[i].getHealth());
            } else {
                boss.setHealth(boss.getHealth() - (heroes[i].getDamage()));
            }
        }
    }

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }
}
