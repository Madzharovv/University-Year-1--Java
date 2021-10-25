package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;



public class Level6  extends GameLevel{
private JediDemon jediDemon;
    public static SoundClip GameMusic;



    public Level6(Game game){

        super(game);
        /**initialising background music*/
        try { GameMusic= new SoundClip("data/bgm7.wav");
            GameMusic.loop();
        }catch(UnsupportedAudioFileException| IOException | LineUnavailableException e){
            System.out.print(e);
        }
        //creating all platforms for the current level
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
        //  platform 1 bottom to top
        Shape platform1Shape = new BoxShape(25, 0.25f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(8, -16));
        platform1.setFillColor(Color.orange);

        //  platform 2  bottom to top
        StaticBody platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(-8, -11f));
        platform2.setFillColor(Color.orange);

        //  platform 3  bottom to top left
        StaticBody platform3 = new StaticBody(this, platform1Shape);
        platform3.setPosition(new Vec2(22.5f, -5f));
        platform3.setFillColor(Color.orange);

        //  platform 3  bottom to top right
        StaticBody platform4 = new StaticBody(this, platform1Shape);
        platform4.setPosition(new Vec2(-35, -5f));
        platform4.setFillColor(Color.orange);

        //  platform 4 bottom to top
        StaticBody platform5 = new StaticBody(this, platform1Shape);
        platform5.setPosition(new Vec2(-8, 1));
        platform5.setFillColor(Color.orange);

        //  platform 5  bottom to top
        StaticBody platform6 = new StaticBody(this, platform1Shape);
        platform6.setPosition(new Vec2(8, 7f));
        platform6.setFillColor(Color.orange);

        //  platform 6 bottom to top
        StaticBody platform7 = new StaticBody(this, platform1Shape);
        platform7.setPosition(new Vec2(-8, 12));
        platform7.setFillColor(Color.orange);

        //  platform 7  bottom to top
        StaticBody platform8 = new StaticBody(this, platform1Shape);
        platform8.setPosition(new Vec2(8, 17f));
        platform8.setFillColor(Color.orange);


        // spawns the specific bodies at their specified locations

        for(int i=0; i<5; i++) {
            JediDemonCollision jediDemonCollision = new JediDemonCollision(getBaby_yoda());
            JediDemon jediDemon = new JediDemon(this);
            jediDemon.setPosition(new Vec2((i -2) * 4 , ((i-5) *8)+27));
            getBaby_yoda().addCollisionListener(jediDemonCollision);
}

        // spawns the specific bodies at their specified locations
        getPortal().setPosition(new Vec2 (21,20));
        getBaby_yoda().setPosition(new Vec2(22, -22));
        // this code looks out for specific collisions between specific bodies

        getBaby_yoda().addCollisionListener(new SuperEnergyPickup(getBaby_yoda()));

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
        Image background=new ImageIcon("data/space8.png").getImage();
        return background;
    }
    @Override
    public String getLevelName() {
        return "Level6";
    }
}