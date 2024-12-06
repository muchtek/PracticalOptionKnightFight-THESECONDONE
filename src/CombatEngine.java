import java.util.List;
import java.util.Random;

public class CombatEngine {
    private final GameData data;
    private final DiceSet dice;
    private final Random rnd;
    private final GameView view;

    public CombatEngine(GameData data, GameView view) {
        this.data = data;
        this.view = view;

        rnd = new Random();
        dice = new DiceSet();
    }

    public void runCombat() {
        List<MOB> monsters = data.getRandomMonsters();
        view.printBattleText(monsters, data.getActiveKnights());
    }

    public void initialize() {
        for(Knight knight : data.getActiveKnights()) {
            knight.setActiveFortune(data.getRandomFortune());
        }
    }

    public void clear() {
        for(Knight knight: data.getKnights()) {
            knight.setActiveFortune(null);
        }
    }

}
