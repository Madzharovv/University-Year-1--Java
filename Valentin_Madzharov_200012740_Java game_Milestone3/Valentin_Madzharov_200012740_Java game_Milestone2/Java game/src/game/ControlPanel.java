package game;

import city.cs.engine.SoundClip;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControlPanel {
    private final Game game;
    private JPanel mainPanel;
    private JButton pauseButton ;
    private JButton resumeButton;
    private JButton quitButton;
    private JSlider slider1;


    public ControlPanel(Game game) {
        this.game=game;


        slider1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent v) {
                super.mouseReleased(v);
                StartLevel.GameMusic.setVolume(0.01* (MouseInfo.getPointerInfo().getLocation().x/10));
                Level1.GameMusic.setVolume(0.01* (MouseInfo.getPointerInfo().getLocation().x/10));
                Level2.GameMusic.setVolume(0.01* (MouseInfo.getPointerInfo().getLocation().x/10));
                Level3.GameMusic.setVolume(0.01* (MouseInfo.getPointerInfo().getLocation().x/10));
                Level4.GameMusic.setVolume(0.01* (MouseInfo.getPointerInfo().getLocation().x/10));
                Level5.GameMusic.setVolume(0.01* (MouseInfo.getPointerInfo().getLocation().x/10));

            }
        });



        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.pauseButton();
            }
        });
        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.resumeButton();
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }

    public JPanel getMainPanel(){
        return mainPanel;
    }

}

