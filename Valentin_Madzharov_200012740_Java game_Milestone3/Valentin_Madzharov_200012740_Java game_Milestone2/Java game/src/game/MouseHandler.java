package game;

import org.jbox2d.common.Vec2;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseHandler extends MouseAdapter {

    private GameLevel level;
    private GameView view;
    public int PixelBlockCount;
    public MouseHandler(GameLevel w, GameView v){

       level = w;
        view = v;

        PixelBlockCount=30;
    }

        @Override
/**The Mouse pressed method works by creating a block everytime a mouse button is pressed. */
        public void mousePressed(MouseEvent e) {


          if (PixelBlockCount >= 1) {
               PixelBlock pixelBlock = new PixelBlock(level);
                Point mousePoint = e.getPoint();
                Vec2 worldPoint = view.viewToWorld(mousePoint);
                pixelBlock.setPosition(worldPoint);
                PixelBlockCount=PixelBlockCount -1;

            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }

    }






