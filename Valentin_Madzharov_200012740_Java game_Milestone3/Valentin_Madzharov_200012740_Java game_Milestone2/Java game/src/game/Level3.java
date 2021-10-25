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



public class Level3 extends GameLevel {


    public static SoundClip GameMusic;



    public Level3(Game game){

        super(game);

        /**initialising background music*/
        try { GameMusic= new SoundClip("data/bgm5.wav");
            GameMusic.loop();
        }catch(UnsupportedAudioFileException| IOException | LineUnavailableException e){
            System.out.print(e);
        }
        //creating all platforms for the current level
        // make the ground
        Shape shape = new BoxShape(26, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -22.5f));
        ground.setFillColor(Color.blue);
        // make lid
        Shape lid = new BoxShape(26, 2.5f);
        StaticBody Lid = new StaticBody(this, shape);
        Lid.setPosition(new Vec2(0f, 22f));
        Lid.setFillColor(Color.blue);
        // wall left
        Shape wallShape = new BoxShape(0.5f, 50f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-22.5f, -10));
        wall1.setFillColor(Color.blue);

        // wall right
        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(22.5f, -10));
        wall2.setFillColor(Color.blue);



        Shape obsticleShape1 = new BoxShape(2.5f, 0.25f);
        StaticBody obsticle2 = new StaticBody(this, obsticleShape1);
        obsticle2.setPosition(new Vec2(-15f, -15f));
        obsticle2.setFillColor(Color.blue);

        Shape obsticleShape = new BoxShape(0.25f, 2.5f);
        StaticBody obsticle1 = new StaticBody(this, obsticleShape);
        obsticle1.setPosition(new Vec2(-15f, -15f));
        obsticle1.setFillColor(Color.blue);




//bottom barrier walls
        StaticBody obsticlewall1 = new StaticBody(this, obsticleShape);
        obsticlewall1.setPosition(new Vec2(-17.5f, -20f));
        obsticlewall1.setFillColor(Color.blue);

        StaticBody obsticlewall2 = new StaticBody(this, obsticleShape);
        obsticlewall2.setPosition(new Vec2(-7.5f, -20f));
        obsticlewall2.setFillColor(Color.blue);

        StaticBody obsticlewall3 = new StaticBody(this, obsticleShape);
        obsticlewall3.setPosition(new Vec2(7.5f, -20f));
        obsticlewall3.setFillColor(Color.blue);

        StaticBody obsticlewall4 = new StaticBody(this, obsticleShape);
        obsticlewall4.setPosition(new Vec2(17.5f, -20f));
        obsticlewall4.setFillColor(Color.blue);

        StaticBody obsticlewall5 = new StaticBody(this, obsticleShape);
        obsticlewall5.setPosition(new Vec2(0, -20f));
        obsticlewall5.setFillColor(Color.blue);





//bottom row of obsticles

        StaticBody obsticle3 = new StaticBody(this, obsticleShape1);
        obsticle3.setPosition(new Vec2(15f, -15f));
        obsticle3.setFillColor(Color.blue);


        StaticBody obsticle4 = new StaticBody(this, obsticleShape);
        obsticle4.setPosition(new Vec2(15f, -15f));
        obsticle4.setFillColor(Color.blue);



        StaticBody obsticle5 = new StaticBody(this, obsticleShape1);
        obsticle5.setPosition(new Vec2(5f, -15f));
        obsticle5.setFillColor(Color.blue);


        StaticBody obsticle6 = new StaticBody(this, obsticleShape);
        obsticle6.setPosition(new Vec2(5f, -15f));
        obsticle6.setFillColor(Color.blue);

        StaticBody obsticle7 = new StaticBody(this, obsticleShape1);
        obsticle7.setPosition(new Vec2(-5f, -15f));
        obsticle7.setFillColor(Color.blue);


        StaticBody obsticle8 = new StaticBody(this, obsticleShape);
        obsticle8.setPosition(new Vec2(-5f, -15f));
        obsticle8.setFillColor(Color.blue);

//middle bottom row of obsticles


        StaticBody obsticle9 = new StaticBody(this, obsticleShape1);
        obsticle9.setPosition(new Vec2(-15f, -7.5f));
        obsticle9.setFillColor(Color.blue);


        StaticBody obsticle10 = new StaticBody(this, obsticleShape);
        obsticle10.setPosition(new Vec2(-15f, -7.5f));
        obsticle10.setFillColor(Color.blue);



        StaticBody obsticle11 = new StaticBody(this, obsticleShape1);
        obsticle11.setPosition(new Vec2(15f, -7.5f));
        obsticle11.setFillColor(Color.blue);


        StaticBody obsticle12 = new StaticBody(this, obsticleShape);
        obsticle12.setPosition(new Vec2(15f, -7.5f));
        obsticle12.setFillColor(Color.blue);



        StaticBody obsticle13 = new StaticBody(this, obsticleShape1);
        obsticle13.setPosition(new Vec2(5f, -7.5f));
        obsticle13.setFillColor(Color.blue);


        StaticBody obsticle14 = new StaticBody(this, obsticleShape);
        obsticle14.setPosition(new Vec2(5f, -7.5f));
        obsticle14.setFillColor(Color.blue);

        StaticBody obsticle15 = new StaticBody(this, obsticleShape1);
        obsticle15.setPosition(new Vec2(-5f, -7.5f));
        obsticle15.setFillColor(Color.blue);


        StaticBody obsticle16 = new StaticBody(this, obsticleShape);
        obsticle16.setPosition(new Vec2(-5f, -7.5f));
        obsticle16.setFillColor(Color.blue);

        //middle top row of obsticles

        Shape platform1Shape = new BoxShape(19.5f, 0.25f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-2.5f, -2.5f));
        platform1.setFillColor(Color.blue);

        Shape platform2Shape = new BoxShape(2, 0.25f);
        StaticBody platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(22f, -2.5f));
        platform2.setFillColor(Color.blue);



        StaticBody obsticle17 = new StaticBody(this, obsticleShape1);
        obsticle17.setPosition(new Vec2(-15f, 2.5f));
        obsticle17.setFillColor(Color.blue);


        StaticBody obsticle18 = new StaticBody(this, obsticleShape);
        obsticle18.setPosition(new Vec2(-15f, 2.5f));
        obsticle18.setFillColor(Color.blue);



        StaticBody obsticle19 = new StaticBody(this, obsticleShape1);
        obsticle19.setPosition(new Vec2(15f, 2.5f));
        obsticle19.setFillColor(Color.blue);


        StaticBody obsticle20 = new StaticBody(this, obsticleShape);
        obsticle20.setPosition(new Vec2(15f, 2.5f));
        obsticle20.setFillColor(Color.blue);



        StaticBody obsticle21 = new StaticBody(this, obsticleShape1);
        obsticle21.setPosition(new Vec2(5f, 2.5f));
        obsticle21.setFillColor(Color.blue);


        StaticBody obsticle22 = new StaticBody(this, obsticleShape);
        obsticle22.setPosition(new Vec2(5f, 2.5f));
        obsticle22.setFillColor(Color.blue);

        StaticBody obsticle23 = new StaticBody(this, obsticleShape1);
        obsticle23.setPosition(new Vec2(-5f, 2.5f));
        obsticle23.setFillColor(Color.blue);


        StaticBody obsticle24 = new StaticBody(this, obsticleShape);
        obsticle24.setPosition(new Vec2(-5f, 2.5f));
        obsticle24.setFillColor(Color.blue);

//top row of obsticles


        StaticBody obsticle25 = new StaticBody(this, obsticleShape1);
        obsticle25.setPosition(new Vec2(-15f, 10f));
        obsticle25.setFillColor(Color.blue);


        StaticBody obsticle26 = new StaticBody(this, obsticleShape);
        obsticle26.setPosition(new Vec2(-15f, 10f));
        obsticle26.setFillColor(Color.blue);



        StaticBody obsticle27 = new StaticBody(this, obsticleShape1);
        obsticle27.setPosition(new Vec2(15f, 10f));
        obsticle27.setFillColor(Color.blue);


        StaticBody obsticle28 = new StaticBody(this, obsticleShape);
        obsticle28.setPosition(new Vec2(15f, 10f));
        obsticle28.setFillColor(Color.blue);



        StaticBody obsticle29 = new StaticBody(this, obsticleShape1);
        obsticle29.setPosition(new Vec2(5f, 10f));
        obsticle29.setFillColor(Color.blue);


        StaticBody obsticle30 = new StaticBody(this, obsticleShape);
        obsticle30.setPosition(new Vec2(5f, 10f));
        obsticle30.setFillColor(Color.blue);

        StaticBody obsticle31 = new StaticBody(this, obsticleShape1);
        obsticle31.setPosition(new Vec2(-5f, 10f));
        obsticle31.setFillColor(Color.blue);


        StaticBody obsticle32 = new StaticBody(this, obsticleShape);
        obsticle32.setPosition(new Vec2(-5f, 10f));
        obsticle32.setFillColor(Color.blue);

//bottom side platforms


        Shape sideplatformsShape = new BoxShape(5, 0.25f);
        StaticBody platform33 = new StaticBody(this, sideplatformsShape);
        platform33.setPosition(new Vec2(-22, -11.5f));
        platform33.setFillColor(Color.blue);



        StaticBody platform34 = new StaticBody(this, sideplatformsShape);
        platform34.setPosition(new Vec2(22, -11.5f));
        platform34.setFillColor(Color.blue);

        StaticBody platform35 = new StaticBody(this, sideplatformsShape);
        platform35.setPosition(new Vec2(-22, 6f));
        platform35.setFillColor(Color.blue);



        StaticBody platform36 = new StaticBody(this, sideplatformsShape);
        platform36.setPosition(new Vec2(22, 6f));
        platform36.setFillColor(Color.blue);

//top lid platforms

        Shape platform37Shape = new BoxShape(20, 0.25f);
        StaticBody platform37 = new StaticBody(this, platform37Shape);
        platform37.setPosition(new Vec2(3f, 15f));
        platform37.setFillColor(Color.blue);

        StaticBody platform38 = new StaticBody(this, platform37Shape);
        platform38.setPosition(new Vec2(-10f, 19f));
        platform38.setFillColor(Color.blue);



        StaticBody obsticle39 = new StaticBody(this, obsticleShape1);
        obsticle39.setPosition(new Vec2(0f, -12f));
        obsticle39.setFillColor(Color.blue);


        for(int i=0; i<5; i++) {
            StormTrooper stormTrooper = new StormTrooper(this);
            stormTrooper.setPosition(new Vec2((i - 2.9f) * 6, ((i - 5) * -8) -24));
            getBaby_yoda().addCollisionListener(new StormTrooperCollision(getBaby_yoda()));

        }


        for(int i=0; i<4; i++) {
            Energy energy = new Energy(this);
            energy.setPosition(new Vec2(i*10-15f, 6));
            getBaby_yoda().addCollisionListener(new EnergyPickup(getBaby_yoda()));
        }


        for(int i=0; i<4; i++) {
            Energy energy = new Energy(this);
            energy.setPosition(new Vec2(i*10-15f, -6));
            getBaby_yoda().addCollisionListener(new EnergyPickup(getBaby_yoda()));
        }

        for(int i=0; i<4; i++) {
            Energy energy = new Energy(this);
            energy.setPosition(new Vec2(i*10-15f, -12));
            getBaby_yoda().addCollisionListener(new EnergyPickup(getBaby_yoda()));
        }

        for(int i=0; i<4; i++) {
            Energy energy = new Energy(this);
            energy.setPosition(new Vec2(i*10-15f, 12));
            getBaby_yoda().addCollisionListener(new EnergyPickup(getBaby_yoda()));
        }








        // spawns the specific bodies at their specified locations
        getPortal().setPosition(new Vec2 (-21,20));
        getBaby_yoda().setPosition(new Vec2(-22, -22));
        // spawns the specific bodies at their specified locations
        getBaby_yoda().addCollisionListener(new EnergyPickup(getBaby_yoda()));
        getBaby_yoda().addCollisionListener(new SuperEnergyPickup(getBaby_yoda()));
        getBaby_yoda().addCollisionListener(new StormTrooperCollision(getBaby_yoda()));
        JFrame window = new JFrame("A green circle");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        Image background=new ImageIcon("data/space3.png").getImage();
        return background;
    }
    @Override
    public String getLevelName() {
        return "Level3";
    }
}
