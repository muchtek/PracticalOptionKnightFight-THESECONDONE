public class Knight extends MOB {

    private Fortune activeFortune;
    private int id;
    private int xp;

    public Knight(int id, String name, int maxHP, int armor, int hitModifier, DiceType damageDie, int xp) {
        super(name, maxHP, armor, hitModifier, damageDie);
        this.id = id;
        this.xp = xp;
    }

    public int getArmor(){
        if(getActiveFortune() != null) { return super.getArmor() + activeFortune.getArmor(); }
        return super.getArmor();
    }

    public int getMaxHP() {
        if(getActiveFortune() != null) { return super.getMaxHP() + activeFortune.getMaxHP(); }
        return super.getMaxHP();
    }

    public DiceType getDamageDie() {
        if(getActiveFortune() != null) { return activeFortune.getDamageDie(); }
        return super.getDamageDie();
    }

    public int getHitModifier() {
        if(getActiveFortune() != null) { return super.getHitModifier() + activeFortune.getHitModifier(); }
        return super.getHitModifier();
    }

    public int getId() {
        return id;
    }

    public int getXP() {
        return xp;
    }

    public void addXP(int xp) {
        this.xp += xp;
    }

    public Fortune getActiveFortune() {
        return activeFortune;
    }

    public void setActiveFortune(Fortune activeFortune) {
        this.activeFortune = activeFortune;
    }

    public String toCSV() {
        return String.format("%s,%s,%s,%s,%s,%s", getName(), getMaxHP(), getArmor(), getHitModifier(), getDamageDie(), getXP());
    }

    public String toString() {

        return "+============================+\n" +
                String.format("| %-27s|%n", getName()) +
                String.format("| id: %-23d|%n", getId()) +
                "|                            |\n" +
                String.format("| Health: %-6d  XP: %-7d|%n", getHP(), getXP())  +
                String.format("|  Power: %-6s  Armor: %-4d|%n", getDamageDie().toString(), getArmor()) +
                "|                            |\n" +
                "+============================+";
    }

    public static void main(String[] args) {
        
    }
    
}
