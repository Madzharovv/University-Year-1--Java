package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;



public class Level4  extends GameLevel{

    public static SoundClip GameMusic;


    public Level4(Game game){

        super(game);
        /**initialising background music*/
        try { GameMusic= new SoundClip("data/bgm4.wav");
            GameMusic.loop();
        }catch(UnsupportedAudioFileException| IOException | LineUnavailableException e){
            System.out.print(e);
        }
        //creating all platforms for the current level
        // make the ground
        Shape shape = new BoxShape(26, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -22.5f));
        ground.setFillColor(Color.yellow);

        // make lid
        Shape lid = new BoxShape(26, 2.5f);
        StaticBody Lid = new StaticBody(this, shape);
        Lid.setPosition(new Vec2(0f, 22f));
        Lid.setFillColor(Color.yellow);

        // wall left
        Shape wallShape = new BoxShape(0.5f, 50f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-22.5f, -10));
        wall1.setFillColor(Color.yellow);

        // wall right
        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(22.5f, -10));
        wall2.setFillColor(Color.yellow);

        Shape platform37Shape = new BoxShape(22, 0.25f);
        StaticBody platform37 = new StaticBody(this, platform37Shape);
        platform37.setPosition(new Vec2(-3f, 0f));
        platform37.setFillColor(Color.yellow);
        //obsticle
        Shape obsticleShape = new BoxShape(0.25f, 1.5f);
        StaticBody obsticle1 = new StaticBody(this, obsticleShape);
        obsticle1.setPosition(new Vec2(17f, 0f));
        obsticle1.setFillColor(Color.pink);
        StaticBody platform38 = new StaticBody(this, platform37Shape);
        platform38.setPosition(new Vec2(3f, 5.5f));
        platform38.setFillColor(Color.yellow);

        for(int i=0; i<3; i++) {
            Emperor emperor = new Emperor(this);
            emperor.setPosition(new Vec2(i*10-15,3));
            getBaby_yoda().addCollisionListener(new EmperorCollision(getBaby_yoda()));
        }
        // spawns the specific bodies at their specified locations
        getPortal().setPosition(new Vec2 (-21,20));
        getBaby_yoda().setPosition(new Vec2(-22, -22));
        // this code looks out for specific collisions between specific bodies
        getBaby_yoda().addCollisionListener(new EnergyPickup(getBaby_yoda()));
        getBaby_yoda().addCollisionListener(new SuperEnergyPickup(getBaby_yoda()));
        getBaby_yoda().addCollisionListener(new StormTrooperCollision(getBaby_yoda()));

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
        Image background=new ImageIcon("data/space4.png").getImage();
        return background;
    }
    @Override
    public String getLevelName() {
        return "Level4";
    }
}