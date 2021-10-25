package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class SuperEnergy extends DynamicBody {



    /** initialising of the shape of the super Energy ball*/
    private static final Shape SuperEnergyShape = new CircleShape(1);

    private static final BodyImage image =
            new BodyImage("data/super_energy_ball.gif", 1f);

    public SuperEnergy(World w) {
        super(w, SuperEnergyShape);
        addImage(image);

    }




    private static SoundClip SuperEnergyPickup;
    static{
        try {SuperEnergyPickup= new SoundClip("data/eating2.wav");
        }catch(UnsupportedAudioFileException| IOException | LineUnavailableException e){
            System.out.print(e);
        }
    }

    @Override
    public void destroy()
    { SuperEnergyPickup.play();
        super.destroy();
    }

}
