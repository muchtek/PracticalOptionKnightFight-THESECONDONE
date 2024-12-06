public class GameController {
    private final GameData data;
    private final CombatEngine engine;
    private final GameView view;

    public GameController(GameData data, GameView view, CombatEngine engine) {
        this.data = data;
        this.engine = engine;
        this.view = view;
    }

    public void start() {
        view.splashScreen();
        while(processCommand(view.displayMainMenu())) {}
        view.endGame();
    }

    protected boolean processCommand(String command) {
        if(command.contains("exit") || command.contains("bye")) {
            return false;
        } else if(command.equals("ls") || command.equals("list all")) {
            view.listKnights(data.getKnights());
        } else if(command.equals("list active")){
            view.listKnights(data.getActiveKnights());
        } else if(command.startsWith("show")){
            String arg = command.substring("show".length()).trim();
            view.showKnight(data.getKnight(arg));
        } else if(command.startsWith("set active")) {
            String arg = command.substring("set active".length()).trim();
            data.setActive(data.getKnight(arg));
        } else if(command.startsWith("remove")) {
            String arg = command.substring("remove".length()).trim();
            data.removeActive(data.getKnight(arg));
        } else if(command.startsWith("save")) {
            String arg = command.substring("save".length()).trim();
            data.save(arg);
        } else if(command.equals("explore") || command.equals("adventure") || command.equals("quest")) {
            engine.initialize();
            engine.runCombat();
            engine.clear();
        }
        return true;
    }
}
