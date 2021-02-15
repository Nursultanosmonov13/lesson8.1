package kg.geecktech.les8.players;

public class Berserk extends Hero {

    public Berserk(int health, int damage) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
       for (int i = 0; i < heroes.length; i++) {
            if(heroes[i] == this){
                boss.setHealth(boss.getHealth() - (heroes[i].getDamage() + boss.getDamage())); //Berserk должен получать от босса урон, и потом наносить ему свой урон + часть урона полученного от босса
            }
            System.out.println("Bersek " + boss.getHealth());

        }
    }
}
