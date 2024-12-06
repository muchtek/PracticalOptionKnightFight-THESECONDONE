public class Fortune implements Attributes {
    private String name;
    private int hitModifier;
    private DiceType diceType;
    private int hpBonus;
    private int armor;

    public Fortune(String name, int hpBonus, int armor, int hitModifier) {
        this(name, hpBonus, armor, hitModifier, null);
    }

    public Fortune(String name, int hpBonus, int armor, int hitModifier, DiceType type) {
        this.hpBonus = hpBonus;
        this.armor = armor;
        this.name = name;
        this.hitModifier = hitModifier;
        this.diceType = type;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public int getMaxHP() {
        // TODO Auto-generated method stub
        return hpBonus;
    }

    @Override
    public DiceType getDamageDie() {
        // TODO Auto-generated method stub
        return diceType;
    }

    @Override
    public int getHitModifier() {
        // TODO Auto-generated method stub
        return hitModifier;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "+======================+\n" +
                String.format("|%-22s|%n", getName()) +
                String.format("|HP Bonus: %12s|%n", "+" + getMaxHP()) +
                String.format("|AC Bonus: %12s|%n", "+" + getArmor()) +
                String.format("|Hit Bonus: %11s|%n", "+" + getHitModifier()) +
                String.format("|Damage Adj: %10s|%n", getDamageDie() != null ? getDamageDie() : "-") +
                "+======================+";
    }

    public static void main(String[] args) {
        Fortune ftn = new Fortune("Merlin Luck", 10, 5, 2, DiceType.D12);
        System.out.println("TESTING Armor in fortune " + ftn.getArmor());
    }
    
}
