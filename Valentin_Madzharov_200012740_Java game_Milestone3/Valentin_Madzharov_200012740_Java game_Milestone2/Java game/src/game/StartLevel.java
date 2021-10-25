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

public class StartLevel extends GameLevel  {
    public static SoundClip GameMusic;


    public StartLevel(Game game){

        super(game);

        /**initialising background music*/
        try { GameMusic= new SoundClip("data/bgm2.wav");
            GameMusic.loop();
        }catch(UnsupportedAudioFileException| IOException | LineUnavailableException e){
            System.out.print(e);
        }
        //creating all platforms for the current level
        // make the ground
        Shape shape = new BoxShape(26, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -22.5f));
        ground.setFillColor(Color.white);
        // make lid
        Shape lid = new BoxShape(26, 2.5f);
        StaticBody Lid = new StaticBody(this, shape);
        Lid.setPosition(new Vec2(0f, 22f));
        Lid.setFillColor(Color.white);

        // wall left
        Shape wallShape = new BoxShape(0.5f, 50f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-22.5f, -10));
        wall1.setFillColor(Color.white);

        // wall right
        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(22.5f, -10));
        wall2.setFillColor(Color.white);

        // spawns the specific bodies at their specified locations
        getPortal().setPosition(new Vec2 (21,-20));
        getBaby_yoda().setPosition(new Vec2(-22, -22));
        // this code looks out for specific collisions between specific bodies
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
        Image background=new ImageIcon("data/space5.png").getImage();
        return background;
    }
    @Override
    public String getLevelName() {
        return "StartLevel";

    }
}
