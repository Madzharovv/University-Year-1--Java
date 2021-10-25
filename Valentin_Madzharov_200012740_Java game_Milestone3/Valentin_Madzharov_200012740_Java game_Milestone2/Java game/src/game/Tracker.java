package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {
    private GameView view;
    private Baby_yoda baby_yoda;
    public Tracker(GameView view, Baby_yoda baby_yoda) {
        this.view = view;
        this.baby_yoda = baby_yoda;
    }
    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) { view.setCentre(new Vec2 (baby_yoda.getPosition()));}

}