import java.util.List;
import java.util.Scanner;

public class ConsoleView implements GameView {
    private final Scanner in;

    public ConsoleView() {
        in = new Scanner(System.in);
    }

    @Override
    public void splashScreen() {
        System.out.println(" ____  __.      .__       .__     __    ___________.__       .__     __  ._.\n" +
                "|    |/ _| ____ |__| ____ |  |___/  |_  \\_   _____/|__| ____ |  |___/  |_| |\n" +
                "|      <  /    \\|  |/ ___\\|  |  \\   __\\  |    __)  |  |/ ___\\|  |  \\   __\\ |\n" +
                "|    |  \\|   |  \\  / /_/  >   Y  \\  |    |     \\   |  / /_/  >   Y  \\  |  \\|\n" +
                "|____|__ \\___|  /__\\___  /|___|  /__|    \\___  /   |__\\___  /|___|  /__|  __\n" +
                "        \\/    \\/  /_____/      \\/            \\/      /_____/      \\/      \\/");
    }

    @Override
    public void endGame() {
        System.out.println("You finished! Good job.");
    }

    @Override
    public String displayMainMenu() {
        System.out.print("What would you like to do? ");
        String userInput = in.nextLine().toLowerCase();
        return userInput;
    }

    @Override
    public void printHelp() {
        System.out.println(" Unsure what to do, here are some options:\n" +
                "            ls or list all  - listing the knights\n" +
                "            list active  - list the active knights knights only\n" +
                "            show name or id - show the knight details card\n" +
                "            set active name or id - set knight as active (note: only 4 knights can be active) \n" +
                "            remove active name or id - remove a knight from active status (heals knight)\n" +
                "            explore or adventure or quest - find random monsters to fight\n" +
                "            save filename - save the game to the file name (default: saveData.csv)\n" +
                "            exit or goodbye - to leave the game\n" +
                "\n" +
                " Game rules: You can have four active knights. As long as they are active, they won't heal, \n" +
                " but they can gain XP by going on adventures.\n" +
                " When you make a knight inactive, they will heal. How many monsters can you defeat \n" +
                " before, you have to heal?\n");
    }

    @Override
    public void listKnights(List<Knight> knights) {
        for(Knight knight : knights) {
            System.out.println(knight.getId() + ": " + knight.getName());
        }
    }

    @Override
    public void knightNotFound() {
        System.out.println("No knights to list");
    }

    @Override
    public void showKnight(Knight knight) {
        System.out.println(knight);
    }

    @Override
    public void setActiveFailed() {
        System.out.println("Unable to set active knight. Only four can be active at a time.");
    }

    @Override
    public void printBattleText(List<MOB> monsters, List<Knight> activeKnights) {
        System.out.printf("%-27s %n \n", "Knights", "Foes");
        if(monsters.size() < activeKnights.size()) {
            for(int i = 0; i < monsters.size(); i++) {
                System.out.printf("%-27s %n \n", activeKnights.get(i).getName(), monsters.get(i).getName());
            }
            for(int i = monsters.size(); i < activeKnights.size(); i++) {
                System.out.printf("%-27s\n", activeKnights.get(i).getName());
            }
        }
        else {
            for(int i = 0; i < activeKnights.size(); i++) {
                System.out.printf("%-27s %n \n", activeKnights.get(i), monsters.get(i));
            }
        }
    }

    @Override
    public void printBattleText(MOB dead) {
        System.out.println(dead.getName() + " was defeated!");
    }

    @Override
    public void printFortunes(List<Knight> activeKnights) {
        for(Knight knight : activeKnights) {
            System.out.println(knight.getName() + " drew");
            System.out.println(knight.getActiveFortune().toString());
        }
    }

    @Override
    public boolean checkContinue() {
        System.out.print("Would you like to continue on your quest (y/n)? ");
        String userInput = in.nextLine();
        if(userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) { return true; }
        return false;
    }

    @Override
    public void printDefeated() {
        System.out.println("All active knights have been defeated!");
    }
}
