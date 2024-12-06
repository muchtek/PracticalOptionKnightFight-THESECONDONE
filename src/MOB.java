public class MOB implements Attributes {

    private int maxHP;
    private int damage = 0;
    private DiceType damageDie;
    private String name;
    private int armor;
    private int hitModifier;

    public MOB(String name, int maxHP, int armor, int hitModifier, DiceType damageDie) {
        this.maxHP = maxHP;
        this.damageDie = damageDie;
        this.armor = armor;
        this.name = name;
        this.hitModifier = hitModifier;
    }


    public String getName() {
        return name;
    }

    @Override
    public int getArmor() {
        // TODO Auto-generated method stub
        return armor;
    }

    public int getHP() {
        return maxHP-damage;
    }

    @Override
    public int getMaxHP() {
        // TODO Auto-generated method stub
        return maxHP;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public DiceType getDamageDie() {
        // TODO Auto-generated method stub
        return damageDie;
    }

    @Override
    public int getHitModifier() {
        // TODO Auto-generated method stub
        return hitModifier;
    }

    public void addDamage(int damage) {
        this.damage += damage;
    }

    public void resetDamage() {
        this.damage = 0;
    }

    public MOB copy() {
        MOB newMob = new MOB(name, maxHP, armor, hitModifier, damageDie);
        return newMob;
    }

    public String toString() {
        return "+============================+\n" +
                String.format("| %-27s|%n", getName()) +
                "|                            |\n" +
                String.format("|         Health: %-10d |%n", getHP())  +
                String.format("|  Power: %-6s  Armor: %-4d|%n", getDamageDie().toString(), getArmor()) +
                "|                            |\n" +
                "+============================+";
    }
    
    public static void main(String[] args) {
        
    }
}
