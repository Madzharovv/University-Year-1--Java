package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;



public class Level2  extends GameLevel{

    public static SoundClip GameMusic;



    public Level2(Game game){

        super(game);


        /**initialising background music*/
        try { GameMusic= new SoundClip("data/bgm3.wav");
           GameMusic.loop();
        }catch(UnsupportedAudioFileException| IOException | LineUnavailableException e){
             System.out.print(e);
         }
        //creating all platforms for the current level
        // make the ground
        Shape shape = new BoxShape(26, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -22.5f));
        ground.setFillColor(Color.green);



        // make lid
        Shape lid = new BoxShape(26, 2.5f);
        StaticBody Lid = new StaticBody(this, shape);
        Lid.setPosition(new Vec2(0f, 22f));
        Lid.setFillColor(Color.green);



        //  platform 1 bottom to top
        Shape platform1Shape = new BoxShape(15, 0.25f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(0, -16));
        platform1.setFillColor(Color.green);

        Shape platform8Shape = new BoxShape(5, 0.25f);
        StaticBody platform8 = new StaticBody(this, platform8Shape);
        platform8.setPosition(new Vec2(-22, -13));
        platform8.setFillColor(Color.green);



        StaticBody platform9 = new StaticBody(this, platform8Shape);
        platform9.setPosition(new Vec2(22, -13));
        platform9.setFillColor(Color.green);

        Shape obsticleShape1 = new BoxShape(3.5f, 0.25f);
        StaticBody obsticle2 = new StaticBody(this, obsticleShape1);
        obsticle2.setPosition(new Vec2(-12f, -9.8f));
        obsticle2.setFillColor(Color.pink);

        Shape obsticleShape = new BoxShape(0.25f, 3.5f);
        StaticBody obsticle1 = new StaticBody(this, obsticleShape);
        obsticle1.setPosition(new Vec2(-12f, -9.8f));
        obsticle1.setFillColor(Color.pink);



        StaticBody obsticle3 = new StaticBody(this, obsticleShape);
        obsticle3.setPosition(new Vec2(12f, -9.8f));
        obsticle3.setFillColor(Color.pink);


        StaticBody obsticle4 = new StaticBody(this, obsticleShape1);
        obsticle4.setPosition(new Vec2(12f, -9.8f));
        obsticle4.setFillColor(Color.pink);


        StaticBody obsticle5 = new StaticBody(this, obsticleShape);
        obsticle5.setPosition(new Vec2(0f, 12f));
        obsticle5.setFillColor(Color.pink);


        StaticBody obsticle6 = new StaticBody(this, obsticleShape1);
        obsticle6.setPosition(new Vec2(0f, 12f));
        obsticle6.setFillColor(Color.pink);

        //  platform 2  bottom to top
        Shape platform2Shape = new BoxShape(7, 0.25f);
        StaticBody platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(0, -11f));
        platform2.setFillColor(Color.green);



        //  platform 3  bottom to top left
        StaticBody platform3 = new StaticBody(this, platform1Shape);
        platform3.setPosition(new Vec2(-24.5f, -4f));
        platform3.setFillColor(Color.green);

        //  platform 3  bottom to top right


        Shape platform5Shape = new BoxShape(7, 0.25f);
        StaticBody platform5 = new StaticBody(this, platform5Shape);
        platform5.setPosition(new Vec2(0, -4f));

        platform5.setFillColor(Color.green);
        StaticBody platform4 = new StaticBody(this, platform5Shape);
        platform4.setPosition(new Vec2(22, -4f));
        platform4.setFillColor(Color.green);

        StaticBody platform6 = new StaticBody(this, platform5Shape);
        platform6.setPosition(new Vec2(14f, 2f));
        platform6.setFillColor(Color.green);

        StaticBody platform10 = new StaticBody(this, platform5Shape);
        platform10.setPosition(new Vec2(8f, 7f));
        platform10.setFillColor(Color.green);

        StaticBody platform11 = new StaticBody(this, platform5Shape);
        platform11.setPosition(new Vec2(14f, 11f));
        platform11.setFillColor(Color.green);

        StaticBody platform12 = new StaticBody(this, platform5Shape);
        platform12.setPosition(new Vec2(18f, 17f));
        platform12.setFillColor(Color.green);

        Shape platform13Shape = new BoxShape(5, 0.25f);
        StaticBody platform13 = new StaticBody(this, platform13Shape);
        platform13.setPosition(new Vec2(-14f, 2f));
        platform13.setFillColor(Color.green);

        StaticBody platform14 = new StaticBody(this, platform5Shape);
        platform14.setPosition(new Vec2(-10.5f, 7f));
        platform14.setFillColor(Color.green);

        StaticBody platform15 = new StaticBody(this, platform13Shape);
        platform15.setPosition(new Vec2(-14f, 11f));
        platform15.setFillColor(Color.green);

        StaticBody platform16 = new StaticBody(this, platform5Shape);
        platform16.setPosition(new Vec2(-18f, 17f));
        platform16.setFillColor(Color.green);


        Shape wallShape3 = new BoxShape(0.5f, 10f);
        StaticBody wall3 = new StaticBody(this, wallShape3);
        wall3.setPosition(new Vec2(-5.f, 12f));
        wall3.setFillColor(Color.green);


        // wall left
        Shape wallShape = new BoxShape(0.5f, 50f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-22.5f, -10));
        wall1.setFillColor(Color.green);
        // wall right
        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(22.5f, -10));
        wall2.setFillColor(Color.green);















        for(int i=0; i<2; i++) {
            Energy energy = new Energy(this);
            energy.setPosition(new Vec2(i*3-21.5f, -11));
            getBaby_yoda().addCollisionListener(new EnergyPickup(getBaby_yoda()));
        }

        for(int i=0; i<2; i++) {
            Energy energy = new Energy(this);
            energy.setPosition(new Vec2(i*3+18.5f, -11));
            getBaby_yoda().addCollisionListener(new EnergyPickup(getBaby_yoda()));
        }


//3
        for(int i=0; i<3; i++) {
            Energy energy = new Energy(this);
            energy.setPosition(new Vec2(i*3-21.5f, 2));
            getBaby_yoda().addCollisionListener(new EnergyPickup(getBaby_yoda()));
        }









        for(int i=0; i<2; i++) {
            Energy energy = new Energy(this);
            energy.setPosition(new Vec2(i*3+17f, 18));
            getBaby_yoda().addCollisionListener(new EnergyPickup(getBaby_yoda()));
        }




        for(int i=0; i<2; i++) {
            Energy energy = new Energy(this);
            energy.setPosition(new Vec2(i*3+15f, 12));
            getBaby_yoda().addCollisionListener(new EnergyPickup(getBaby_yoda()));
        }




        for(int i=0; i<3; i++) {
            Energy energy = new Energy(this);
            energy.setPosition(new Vec2(i*3+12f, 7));
            getBaby_yoda().addCollisionListener(new EnergyPickup(getBaby_yoda()));
        }

        for(int i=0; i<2; i++) {
            Energy energy = new Energy(this);
            energy.setPosition(new Vec2(i*3-17f, 18));
            getBaby_yoda().addCollisionListener(new EnergyPickup(getBaby_yoda()));
        }




        for(int i=0; i<2; i++) {
            Energy energy = new Energy(this);
            energy.setPosition(new Vec2(i*3-15f, 12));
            getBaby_yoda().addCollisionListener(new EnergyPickup(getBaby_yoda()));
        }




        for(int i=0; i<3; i++) {
            Energy energy = new Energy(this);
            energy.setPosition(new Vec2(i*3-17f, 7));
            getBaby_yoda().addCollisionListener(new EnergyPickup(getBaby_yoda()));
        }




        for(int i=0; i<5; i++) {
            StormTrooper stormTrooper = new StormTrooper(this);
            stormTrooper.setPosition(new Vec2((i - 2.9f) * 6, ((i - 5) * -8) -24));
            getBaby_yoda().addCollisionListener(new StormTrooperCollision(getBaby_yoda()));

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
        if (getBaby_yoda().getEnergy() >=0 )
            return true;
        else
            return false;
    }
    /**change of the background for the current level*/
    @Override
    public Image paintBackground() {
        Image background=new ImageIcon("data/space2.png").getImage();
        return background;
    }
    @Override
    public String getLevelName() {
        return "Level2";
    }
}

