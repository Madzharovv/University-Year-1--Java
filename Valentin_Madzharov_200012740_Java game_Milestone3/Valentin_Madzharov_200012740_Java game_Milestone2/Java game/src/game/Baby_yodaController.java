package game;

import city.cs.engine.SoundClip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Baby_yodaController implements KeyListener {
    /**declaring the speed of  the main characters movement*/
    private static final float WALKING_SPEED = 8;

    private Baby_yoda baby_yoda;
    private Game game ;


    public Baby_yodaController(Game game ) {
        this.game = game ;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    /** if the A key is pressed the main character (Baby_yoda) moves left*/
    /** if the D key is pressed the main character (Baby_yoda) moves right*/
    /** if the W key is pressed the main character (Baby_yoda) jumps and plays a jumping sound */
    /** if the S key is pressed the game is saved on that level */
    /** if the L key is pressed the game is loaded  from the last level where the game was saved */

    @Override
    public void keyPressed(KeyEvent e) {
        //movement controls upon a pressing of a key
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            game.getLevel().getBaby_yoda().startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_D) {
            game.getLevel().getBaby_yoda().startWalking(WALKING_SPEED);
        } else if (code == KeyEvent.VK_W) {
            game.getLevel().getBaby_yoda().jump(13);
            Baby_yodaController.jumpsound.play();
        } else if (code == KeyEvent.VK_S) {

            try {
                GameSaverLoader.save(game.getLevel(), "data/save.txt");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }
        else if (code == KeyEvent.VK_L) {
            try {
                GameLevel level = GameSaverLoader.load(game, "data/save.txt");
                game.setLevel(level);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }


    }
    /** This introduces the jumping sound file*/
    private static SoundClip jumpsound;
    static{
        try {jumpsound= new SoundClip("data/jumpsound.wav");
        }catch(UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.print(e);
        }
    }

    /** if the A key is released the main character (Baby_yoda) stops moving left*/
    /** if the D key is released the main character (Baby_yoda) stops moving right*/
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            game.getLevel().getBaby_yoda().stopWalking();
        } else if (code == KeyEvent.VK_D) {
            game.getLevel().getBaby_yoda().stopWalking();
        }
    }

    public void updateBaby_yoda(Baby_yoda baby_yoda){
        this.baby_yoda=baby_yoda;
  }
}
