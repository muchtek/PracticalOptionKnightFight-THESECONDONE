import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVGameData extends GameData {
    CSVGameData(String gamedata, String saveData) {
        loadGameData(gamedata);
        loadSaveData(saveData);
    }

    void loadSaveData(String saveData) {
        int counter = 0;
        Scanner file = readFile(saveData);
        if (file == null) return;
        while (file.hasNextLine()) {
            Scanner line = new Scanner(file.nextLine());
            line.useDelimiter(",");
            Knight kt = new Knight(
                    ++counter,
                    line.next().trim(),
                    line.nextInt(),
                    line.nextInt(),
                    line.nextInt(),
                    DiceType.valueOf(line.next()),
                    line.nextInt());
            knights.add(kt);
        }
    }

    private Scanner readFile(String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(fileName));
            return new Scanner(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    void loadGameData(String gamedata) {
        Scanner file = readFile(gamedata);
        while(file.hasNextLine()) {
            Scanner line = new Scanner(file.nextLine());
            line.useDelimiter(",");


            if(line.next().equals("MOB")){
                MOB mob = new MOB(
                        line.next(),
                        line.nextInt(),
                        line.nextInt(),
                        line.nextInt(),
                        DiceType.valueOf(line.next())
                );
                monsters.add(mob);

            } else if(line.next().equals("FORTUNE")){
                String name = line.next();
                int hp = line.nextInt();
                int armor = line.nextInt();
                int hitModifier = line.nextInt();
                String diceType = line.next();

                if(diceType.equals("-")){
                    Fortune fortune = new Fortune(name, hp, armor, hitModifier);
                    fortunes.add(fortune);
                } else {
                    Fortune fortune = new Fortune(name, hp, armor, hitModifier, DiceType.valueOf(diceType));
                    fortunes.add(fortune);
                }

            }
        }
    }

    public void save(String filename){
        for(Knight kt : knights){
            System.out.print(kt.toCSV());
        }
    }



}