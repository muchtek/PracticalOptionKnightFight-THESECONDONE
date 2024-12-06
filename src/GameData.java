import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class GameData {
    protected final List<Knight> activeKnights;
    protected final List<Fortune> fortunes;
    protected final List<Knight> knights;
    protected final List<MOB> monsters;
    private static final Random random = new Random();
    private static final int MAX_ACTIVE = 4;

    public GameData() {
        activeKnights = new ArrayList<Knight>();
        fortunes = new ArrayList<Fortune>();
        knights = new ArrayList<Knight>();
        monsters = new ArrayList<MOB>();
    }


    public List<Knight> getKnights() {
        return knights;
    }

    public List<Knight> getActiveKnights() {
        return activeKnights;
    }

    public Knight getKnight(String nameOrId) {
        return findKnight(nameOrId, knights);
    }

    public Knight getActive(String nameOrId) {
        return findKnight(nameOrId, activeKnights);
    }

    public boolean setActive(Knight kt) {
        if(activeKnights.size() < MAX_ACTIVE) {
            return activeKnights.add(kt);
        }
        return false;
    }

    public void removeActive(Knight kt) {
        activeKnights.remove(kt);
        kt.resetDamage();
    }

    public Fortune getRandomFortune() {
        return fortunes.get(random.nextInt(fortunes.size()));
    }

    public List<MOB> getRandomMonsters() {
        int nextInt = random.nextInt(activeKnights.size() + 1);
        return getRandomMonsters(nextInt == 0 ? 1 : nextInt);
    }

    public List<MOB> getRandomMonsters(int number) {
        List<MOB> randomMonsters = new ArrayList<>();
        for(int i = 0; i < number; i++) {
            randomMonsters.add(monsters.get(random.nextInt(monsters.size())).copy());
        }
        return randomMonsters;
    }

    protected Knight findKnight(String nameOrId, List<Knight> list) {
        for(Knight knight : list) {
            if (nameOrId.equals(Integer.toString(knight.getId())) || knight.getName().toLowerCase().contains(nameOrId)) {
                return knight;
            }
        }
        return null;
    }

    public abstract void save(String filename); {}
}
