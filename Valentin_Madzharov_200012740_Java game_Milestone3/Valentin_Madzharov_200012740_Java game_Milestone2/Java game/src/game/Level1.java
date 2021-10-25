package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;
import city.cs.engine.*;
import org.w3c.dom.css.CSS2Properties;

import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;



public class Level1 extends GameLevel {


public static SoundClip GameMusic;



    public Level1(Game game){

        super(game);

        /**initialising background music*/
       try { GameMusic= new SoundClip("data/bgm.wav");
           GameMusic.loop();
   }catch(UnsupportedAudioFileException| IOException | LineUnavailableException e){
         System.out.print(e);
      }
        //creating all platforms for the current level
        // make the ground
        Shape shape = new BoxShape(26, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -22.5f));
        ground.setFillColor(Color.red);
        // make lid
        Shape lid = new BoxShape(26, 2.5f);
        StaticBody Lid = new StaticBody(this, shape);
        Lid.setPosition(new Vec2(0f, 22f));
        Lid.setFillColor(Color.red);

        //  platform 1 bottom to top
        Shape platform1Shape = new BoxShape(25, 0.25f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-8, -16));
        platform1.setFillColor(Color.red);

        //  platform 2  bottom to top
        StaticBody platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(8, -11f));
        platform2.setFillColor(Color.red);

        //  platform 3  bottom to top left
        StaticBody platform3 = new StaticBody(this, platform1Shape);
        platform3.setPosition(new Vec2(-22.5f, -5f));
        platform3.setFillColor(Color.red);

        //  platform 3  bottom to top right
        StaticBody platform4 = new StaticBody(this, platform1Shape);
        platform4.setPosition(new Vec2(35, -5f));
        platform4.setFillColor(Color.red);

        //  platform 4 bottom to top
        StaticBody platform5 = new StaticBody(this, platform1Shape);
        platform5.setPosition(new Vec2(8, 1));
        platform5.setFillColor(Color.red);

        //  platform 5  bottom to top
        StaticBody platform6 = new StaticBody(this, platform1Shape);
        platform6.setPosition(new Vec2(-8, 7f));
        platform6.setFillColor(Color.red);

        //  platform 6 bottom to top
        StaticBody platform7 = new StaticBody(this, platform1Shape);
        platform7.setPosition(new Vec2(8, 12));
        platform7.setFillColor(Color.red);

        //  platform 7  bottom to top
        StaticBody platform8 = new StaticBody(this, platform1Shape);
        platform8.setPosition(new Vec2(-8, 17f));
        platform8.setFillColor(Color.red);

        // wall left
        Shape wallShape = new BoxShape(0.5f, 50f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-22.5f, -10));
        wall1.setFillColor(Color.red);

        // wall right
        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(22.5f, -10));
        wall2.setFillColor(Color.red);

        //obsticle
        Shape obsticleShape = new BoxShape(0.25f, 1.5f);
        StaticBody obsticle1 = new StaticBody(this, obsticleShape);
        obsticle1.setPosition(new Vec2(-12f, -9.8f));
        obsticle1.setFillColor(Color.pink);

        StaticBody obsticle2 = new StaticBody(this, obsticleShape);
        obsticle2.setPosition(new Vec2(-5f, -9.8f));
        obsticle2.setFillColor(Color.pink);

        StaticBody obsticle3 = new StaticBody(this, obsticleShape);
        obsticle3.setPosition(new Vec2(2f, -3.8f));
        obsticle3.setFillColor(Color.pink);

        StaticBody obsticle4 = new StaticBody(this, obsticleShape);
        obsticle4.setPosition(new Vec2(-16.5f, 2.2f));
        obsticle4.setFillColor(Color.pink);

        StaticBody obsticle5 = new StaticBody(this, obsticleShape);
        obsticle5.setPosition(new Vec2(10f, 6.5f));
        obsticle5.setFillColor(Color.pink);


        StaticBody obsticle6 = new StaticBody(this, obsticleShape);
        obsticle6.setPosition(new Vec2(8f, 12f));
        obsticle6.setFillColor(Color.pink);


        StaticBody obsticle7 = new StaticBody(this, obsticleShape);
        obsticle7.setPosition(new Vec2(2f, 17f));
        obsticle7.setFillColor(Color.pink);



        // spawns the specific bodies at their specified locations
        getPortal().setPosition(new Vec2 (-21,20));
        getBaby_yoda().setPosition(new Vec2(-22, -22));


        // this code looks out for specific collisions between specific bodies
        getBaby_yoda().addCollisionListener(new EnergyPickup(getBaby_yoda()));
        getBaby_yoda().addCollisionListener(new SuperEnergyPickup(getBaby_yoda()));
        getBaby_yoda().addCollisionListener(new StormTrooperCollision(getBaby_yoda()));
        JFrame window = new JFrame("A green circle");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // default layout manager is BorderLayout

//for loops which spawn the StormTrooper bodies in a specified diagonal pattern
        for(int i=0; i<5; i++) {
          StormTrooper stormTrooper = new StormTrooper(this);
          stormTrooper.setPosition(new Vec2((i -2) * 4 , ((i-5) *8)+27));
          getBaby_yoda().addCollisionListener(new StormTrooperCollision(getBaby_yoda()));

        }

//for loops which spawn the Energy bodies in a specified diagonal pattern
        for(int i=0; i<5; i++) {
            Energy energy = new Energy(this);
            energy.setPosition(new Vec2(i * 4 - 19, i *5 ));
            getBaby_yoda().addCollisionListener(new EnergyPickup(getBaby_yoda()));
        }

        //for loops which spawn the SuperEnergy bodies in a specified vertical pattern
        for(int i=0; i<5; i++) {
            SuperEnergy superEnergy = new SuperEnergy(this);
            superEnergy.setPosition(new Vec2(i * 4 +1, (i-5) *5+10 ));
            getBaby_yoda().addCollisionListener(new SuperEnergyPickup(getBaby_yoda()));
        }

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
        Image background=new ImageIcon("data/space6.png").getImage();
        return background;
    }

    @Override
    public String getLevelName() {
        return "Level1";
    }

}
