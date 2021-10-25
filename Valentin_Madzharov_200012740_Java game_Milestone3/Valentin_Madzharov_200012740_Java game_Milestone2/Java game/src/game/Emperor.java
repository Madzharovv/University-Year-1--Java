package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Emperor extends Walker implements StepListener {
    /** initialising of the shape of Enemy(Emperor)*/
    private static final Shape emperorShape = new PolygonShape(
            0.15f,0.795f, 0.9f,0.4f, 0.71f,-1.23f, -0.795f,-1.24f, -0.92f,-0.375f, -0.275f,0.75f);

    /**initialising an image for the Emperor*/

    private static final BodyImage image =
            new BodyImage("data/emperor.png", 2.5f);


    public Emperor(World world) {
        super(world, emperorShape);
        addImage(image);
    }

    private enum State {
        ROLL_LEFT, ROLL_RIGHT, STAND_STILL
    }

    public static final float RANGE = 10;
    private Level4 game;
    private State state;

    public Emperor(Level4 game) {
        super(game, emperorShape);
        this.game = game;
        addImage(image);
        state = State.STAND_STILL;
        getWorld().addStepListener(this);
    }

    public boolean inRangeLeft() {
        Body a = game.getBaby_yoda();
        float gap = getPosition().x - a.getPosition().x;
        return gap < RANGE && gap > 0;
    }

    public boolean inRangeRight() {
        Body a = game.getBaby_yoda();
        float gap = getPosition().x - a.getPosition().x;
        return gap > -RANGE && gap < 0;
    }

    // update state
    public void preStep(StepEvent e) {
        if (inRangeRight()) {
            if (state != State.ROLL_RIGHT) {
                state = State.ROLL_RIGHT;

            }
        } else if (inRangeLeft()) {
            if (state != State.ROLL_LEFT) {
                state = State.ROLL_LEFT;

            }
        } else {
            if (state != State.STAND_STILL) {
                state = State.STAND_STILL;
                setAngularVelocity(0);
                setLinearVelocity(new Vec2(0, 0));

            }
        }
        refreshRoll();
    }



    // use this to prevent the balls from slowing
    // down and stopping due to friction when they
    // should be rolling
    private void refreshRoll() {
        switch (state) {
            case ROLL_LEFT:
                setLinearVelocity(new Vec2(-3,0));
                break;
            case ROLL_RIGHT:
                setLinearVelocity(new Vec2(3,0));
                break;
            default: // nothing to do
        }    }

    public void postStep(StepEvent e) {
    }
}
