package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GameSaverLoader {

/** The save method saves the level name, the energy levels and the lives into a text document which then is used later
 *  on when the player wants to load the game. The saved values are taken and set when the level is required
 *  to be loaded by the user.   */

    public static void save(GameLevel level, String fileName)

            throws IOException {


        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);
            writer.write(level.getLevelName() + "," + level.getBaby_yoda().getEnergy() + ","+ level.getBaby_yoda().getLiveCount() + "\n");

        } finally {
            if (writer != null) {
                writer.close();

            }
        }
    }

    public static GameLevel load(Game game,String fileName)
            throws IOException
    {

        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();

            String[] tokens = line.split(",");
            String name = tokens[0];
            int Energy = Integer.parseInt(tokens[1]);
            int LiveCount = Integer.parseInt(tokens[2]);


            GameLevel level = null;
            if (name.equals("Level1"))
                level = new Level1(game);
             else if(name.equals("Level2"))
                level = new Level2(game);
             else if (name.equals("Level3"))
                 level = new Level3(game);
             else if (name.equals("Level4"))
                 level = new Level4(game);
             else if (name.equals("Level5"))
                 level = new Level5(game);
            else if (name.equals("Level6"))
                level = new Level6(game);
             else if (name.equals("StartLevel"))
                 level = new StartLevel(game);
             else if (name.equals("EndLevel"))
                 level = new EndLevel(game);



            level.getBaby_yoda().setEnergy(Energy);
            level.getBaby_yoda().setLiveCount(LiveCount);
            return level;


        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }

    }
}
