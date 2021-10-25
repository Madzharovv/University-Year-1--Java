package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;
import city.cs.engine.*;
import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class EndLevel extends GameLevel  {
    public static SoundClip GameMusic;
    private Baby_yoda baby_yoda;
    private Game game;
/** This is the End level of the game*/
    public EndLevel(Game game){

        super(game);

        /**initialising background music*/
        try { GameMusic= new SoundClip("data/bgm2.wav");
            GameMusic.loop();
        }catch(UnsupportedAudioFileException| IOException | LineUnavailableException e){
            System.out.print(e);
        }

        // make the ground
        Shape shape = new BoxShape(26, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -22.5f));
        ground.setFillColor(Color.orange);
        // make lid
        Shape lid = new BoxShape(26, 2.5f);
        StaticBody Lid = new StaticBody(this, shape);
        Lid.setPosition(new Vec2(0f, 22f));
        Lid.setFillColor(Color.orange);




        // wall left
        Shape wallShape = new BoxShape(0.5f, 50f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-22.5f, -10));
        wall1.setFillColor(Color.orange);

        // wall right
        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(22.5f, -10));
        wall2.setFillColor(Color.orange);





        getPortal().setPosition(new Vec2 (-15,5));

        getBaby_yoda().setPosition(new Vec2(-22, -22));

        getBaby_yoda().addCollisionListener(new EnergyPickup(getBaby_yoda()));
        getBaby_yoda().addCollisionListener(new SuperEnergyPickup(getBaby_yoda()));
        getBaby_yoda().addCollisionListener(new StormTrooperCollision(getBaby_yoda()));


        JFrame window = new JFrame("A green circle");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // default layout manager is BorderLayout





    }
    /**stop the current music that is playing when the level finishes*/
    @Override
    public boolean isComplete() {
        GameMusic.stop();
        if (getBaby_yoda().getEnergy() >= 0)
            return true;
        else
            return false;
    }

    /**change of the background for the current level*/
    @Override
    public Image paintBackground() {
        Image background=new ImageIcon("data/space.png").getImage();
        return background;
    }

    @Override
    public String getLevelName() {
        return "EndLevel";
    }
}
