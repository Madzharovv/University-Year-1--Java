package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Energy extends DynamicBody {



    /** initialising of the shape of the super Energy ball*/
    private static final Shape energyShape = new CircleShape(1);

    private static final BodyImage image =
            new BodyImage("data/energy_ball.gif", 1f);

    public Energy(World w) {
        super(w, energyShape);
        addImage(image);

    }


    private static SoundClip energypickup;
    static{
        try {energypickup= new SoundClip("data/eating.wav");
    }catch(UnsupportedAudioFileException| IOException | LineUnavailableException e){
        System.out.print(e);
    }
    }

    @Override
    public void destroy()
    { energypickup.play();
    super.destroy();
    }

}
