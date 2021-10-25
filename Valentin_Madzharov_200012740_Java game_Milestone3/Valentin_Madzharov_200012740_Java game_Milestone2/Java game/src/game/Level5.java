package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;



public class Level5  extends GameLevel {

    public static SoundClip GameMusic;

    public Level5(Game game) {

        super(game);
        /**initialising background music*/
        try {
            GameMusic = new SoundClip("data/bgm6.wav");
            GameMusic.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.print(e);
        }
        //creating all platforms for the current level
        // make the ground
        Shape shape = new BoxShape(26, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -22.5f));
        ground.setFillColor(Color.pink);

        // make lid
        Shape lid = new BoxShape(26, 2.5f);
        StaticBody Lid = new StaticBody(this, shape);
        Lid.setPosition(new Vec2(0f, 22f));
        Lid.setFillColor(Color.pink);

        // wall left
        Shape wallShape = new BoxShape(0.5f, 50f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-22.5f, -10));
        wall1.setFillColor(Color.pink);
        // wall right
        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(22.5f, -10));
        wall2.setFillColor(Color.pink);

        Shape wall3 = new BoxShape(0.25f, 24);
        StaticBody wall4 = new StaticBody(this, wall3);
        wall4.setPosition(new Vec2(20f, -6));
        wall4.setFillColor(Color.pink);

        StaticBody wall5 = new StaticBody(this, wall3);
        wall5.setPosition(new Vec2(17.5f, 6));
        wall5.setFillColor(Color.pink);

        Shape platform1Shape = new BoxShape(17, 0.25f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(0.8f, -18));
        platform1.setFillColor(Color.pink);

        Shape platform3Shape = new BoxShape(15, 0.25f);
        StaticBody platform2 = new StaticBody(this, platform3Shape);
        platform2.setPosition(new Vec2(-10f, -13));
        platform2.setFillColor(Color.pink);

        Shape platform30Shape = new BoxShape(3f ,0.25f);
        StaticBody platform30 = new StaticBody(this, platform30Shape);
        platform30.setPosition(new Vec2(14.5f, -13));
        platform30.setFillColor(Color.pink);

        Shape platform5Shape = new BoxShape(7, 0.25f);
        StaticBody platform5 = new StaticBody(this, platform5Shape);
        platform5.setPosition(new Vec2(0f, -7.7f));
        platform5.rotate(40);
        platform5.setFillColor(Color.pink);

        StaticBody platform7 = new StaticBody(this, platform5Shape);
        platform7.setPosition(new Vec2(7f, -7.7f));
        platform7.rotate(40);
        platform7.setFillColor(Color.pink);

        StaticBody platform20 = new StaticBody(this, platform3Shape);
        platform20.setPosition(new Vec2(-10f, 10));
        platform20.setFillColor(Color.pink);

        Shape platform31Shape = new BoxShape(5f ,0.25f);
        StaticBody platform31 = new StaticBody(this, platform31Shape);
        platform31.setPosition(new Vec2(12.5f, 10));
        platform31.setFillColor(Color.pink);

        StaticBody platform6 = new StaticBody(this, platform5Shape);
        platform6.setPosition(new Vec2(-1.9f, 3.65f));
        platform6.rotate(20);
        platform6.setFillColor(Color.pink);

        StaticBody platform8 = new StaticBody(this, platform5Shape);
        platform8.setPosition(new Vec2(4.9f, 3.65f));
        platform8.rotate(20);
        platform8.setFillColor(Color.pink);

        StaticBody platform40 = new StaticBody(this, platform1Shape);
        platform40.setPosition(new Vec2(0.8f, 14));
        platform40.setFillColor(Color.pink);

//for loops which spawn the Emperor bodies in a specified horizontal pattern
        for(int i=0; i<3; i++) {
            Emperor emperor = new Emperor(this);
            emperor.setPosition(new Vec2(i*10-15,-14));
            getBaby_yoda().addCollisionListener(new EmperorCollision(getBaby_yoda()));
        }
//for loops which spawn the Emperor bodies in a specified horizontal pattern
        for(int i=0; i<3; i++) {
            Emperor emperor = new Emperor(this);
            emperor.setPosition(new Vec2(i*10-15,15));
            getBaby_yoda().addCollisionListener(new EmperorCollision(getBaby_yoda()));

        }
        //for loops which spawn the Energy bodies in a specified horizontal pattern
        for(int i=0; i<10; i++) {
            Energy energy = new Energy(this);
            energy.setPosition(new Vec2(i*3-18f, -18));
            getBaby_yoda().addCollisionListener(new EnergyPickup(getBaby_yoda()));
        }
        //for loops which spawn the Energy bodies in a specified horizontal pattern
        for(int i=0; i<5; i++) {
            Energy energy = new Energy(this);
            energy.setPosition(new Vec2(i*3-18f, 12));
            getBaby_yoda().addCollisionListener(new EnergyPickup(getBaby_yoda()));
        }
        //for loops which spawn the SuperEnergy bodies in a specified horizontal pattern
        for(int i=0; i<3; i++) {
            SuperEnergy superEnergy = new SuperEnergy(this);
            superEnergy.setPosition(new Vec2(i*3+10f, 12));
            getBaby_yoda().addCollisionListener(new SuperEnergyPickup(getBaby_yoda()));
        }

        // spawns the specific bodies at their specified locations
        getPortal().setPosition(new Vec2 (-21,20));
        getBaby_yoda().setPosition(new Vec2(22, -22));
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
        Image background = new ImageIcon("data/space7.png").getImage();
        return background;
    }
    @Override
    public String getLevelName() {
        return "Level5";
    }
}

