package game;

import javax.swing.JFrame;
import city.cs.engine.DebugViewer;
import java.awt.*;

public class Game {


    private GameLevel level;

    private GameView view;
    private Baby_yodaController controller;

    /** Initialise a new Game. */
    public Game() {
        level =  new StartLevel(this);
        /** A graphical display of the world (a specialised JPanel). */




        view = new GameView(level, level.getBaby_yoda(), 1000, 1000);
        view.setZoom(20);
        view.setBack(level.paintBackground());
        view.addMouseListener(new MouseHandler(level, view));
        view.addMouseListener(new GiveFocus(view));
        controller = new Baby_yodaController(this);
        view.addKeyListener(controller);
        final JFrame frame = new JFrame("Basic world");
        frame.add(view);
        ControlPanel controlPanel=new ControlPanel(this);
        frame.add(controlPanel.getMainPanel(),BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        JFrame debugView = new DebugViewer(level, 500, 500);

        // start our game world simulation!
        level.start();

    }



public void pauseButton() {level.stop();}

public void resumeButton() {level.start();}



/** The If statement bellow  is used to load the next level once the current level is completed.
 * Each else if/statement contains code that allows all variables and features to be transferred to the next level*/
    public void goToNextLevel(){
        //changing from StartLevel  to level 1
        if (level instanceof  StartLevel){

            level.stop();

            level = new Level1(this);

            view.setWorld(level);
            view.setZoom(20);
            view.setBack(level.paintBackground());
            controller.updateBaby_yoda(level.getBaby_yoda());
            view.addMouseListener(new GiveFocus(view));
            view.addMouseListener(new MouseHandler(level, view));
            view.updateCount(level.getBaby_yoda());
            view.updateLivesCount(level.getBaby_yoda());
            level.start();

        }
        //changing from level 1 to level 2
        else if (level instanceof Level1){
            //stop the current level
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level2(this);
            //change the view to look into new level
            view.setWorld(level);
            view.setBack(level.paintBackground());
            controller.updateBaby_yoda(level.getBaby_yoda());
            //start the simulation in the new level
            view.addMouseListener(new GiveFocus(view));
            view.addMouseListener(new MouseHandler(level, view));
            view.updateCount(level.getBaby_yoda());
            view.updateLivesCount(level.getBaby_yoda());
            level.start();
        }
        //changing from level 2 to level 3
         else if (level instanceof Level2){
            //stop the current level
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level3(this);
            //change the view to look into new level
            view.setWorld(level);
            view.setBack(level.paintBackground());
            controller.updateBaby_yoda(level.getBaby_yoda());
            //start the simulation in the new level
            view.addMouseListener(new GiveFocus(view));
            view.addMouseListener(new MouseHandler(level, view));
            view.updateCount(level.getBaby_yoda());
            view.updateLivesCount(level.getBaby_yoda());
            level.start();
        }
        //changing from level 3 to level 4
        else if (level instanceof Level3){
            //stop the current level
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level4(this);
            //change the view to look into new level
            view.setWorld(level);
            view.setBack(level.paintBackground());
            controller.updateBaby_yoda(level.getBaby_yoda());
            //start the simulation in the new level
            view.addMouseListener(new GiveFocus(view));
            view.addMouseListener(new MouseHandler(level, view));
            view.updateCount(level.getBaby_yoda());
            view.updateLivesCount(level.getBaby_yoda());
            level.start();
        }
        //changing from level 4 to level 5
        else if (level instanceof Level4){
            //stop the current level
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level5(this);
            //change the view to look into new level
            view.setWorld(level);
            view.setBack(level.paintBackground());
            controller.updateBaby_yoda(level.getBaby_yoda());
            //start the simulation in the new level
            view.addMouseListener(new GiveFocus(view));
            view.addMouseListener(new MouseHandler(level, view));
            view.updateCount(level.getBaby_yoda());
            view.updateLivesCount(level.getBaby_yoda());
            level.start();
        }
        //changing from level 5 to end level
        else if (level instanceof Level5){
            //stop the current level
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level6(this);
            //change the view to look into new level
            view.setWorld(level);
            view.setBack(level.paintBackground());
            controller.updateBaby_yoda(level.getBaby_yoda());
            //start the simulation in the new level
            view.addMouseListener(new GiveFocus(view));
            view.addMouseListener(new MouseHandler(level, view));
            view.updateCount(level.getBaby_yoda());
            view.updateLivesCount(level.getBaby_yoda());
            level.start();

        }
        else if (level instanceof Level6){
            //stop the current level
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new EndLevel(this);
            //change the view to look into new level
            view.setWorld(level);
            view.setBack(level.paintBackground());
            controller.updateBaby_yoda(level.getBaby_yoda());
            //start the simulation in the new level
            view.addMouseListener(new GiveFocus(view));
            view.addMouseListener(new MouseHandler(level, view));
            view.updateCount(level.getBaby_yoda());
            view.updateLivesCount(level.getBaby_yoda());
            level.start();

        }
    }
    /** The code below creates the level when the loading option is picked*/
    public void setLevel(GameLevel level){
        this.level.stop();
        this.level = level;
        view.setWorld(this.level);
        view.setBack(this.level.paintBackground());
        controller.updateBaby_yoda(this.level.getBaby_yoda());
        view.addMouseListener(new MouseHandler(level, view));
        view.updateCount(level.getBaby_yoda());
        view.updateLivesCount(level.getBaby_yoda());
        this.level.start();

    }



    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }

    public GameLevel getLevel() {
    return level;}
}
