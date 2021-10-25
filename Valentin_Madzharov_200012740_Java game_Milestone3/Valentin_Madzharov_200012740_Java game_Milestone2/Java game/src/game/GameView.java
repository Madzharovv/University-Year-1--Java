package game;

import city.cs.engine.UserView;
import city.cs.engine.World;


import java.awt.*;

public class GameView extends UserView {
    private Baby_yoda baby_yoda;
    public Image back;

    public GameView(World w,Baby_yoda b , int width, int height) {
        super(w,900, 900);
           // background = new ImageIcon("data/space.png").getImage();
            this.baby_yoda = b ;

    }

    public void setBack(Image background){
        this.back=background;
    }


    @Override
    protected void paintBackground(Graphics2D g) {

        g.drawImage(back, 0, 0, this);
    }
/** The Paint Foreground method is used to display the two variables of the main character (Baby_yoda) which are Energy
 *  levels and Lives. The values are retrieved by the use of getters. */
    @Override
    protected void paintForeground(Graphics2D g) {
        //displaying energy score and lives left
        g.drawString("Energy level:" + this.baby_yoda.getEnergy(), 70, 15);


        g.drawString("Lives:" + this.baby_yoda.getLiveCount(), 10, 15);

        if (this.baby_yoda.getLiveCount() < 0) {
            System.exit(0);
        }

    }

            public void updateCount(Baby_yoda baby_yoda){
                this.baby_yoda=baby_yoda;
            }

            public void updateLivesCount(Baby_yoda baby_yoda){
                this.baby_yoda=baby_yoda;
            }
        }
