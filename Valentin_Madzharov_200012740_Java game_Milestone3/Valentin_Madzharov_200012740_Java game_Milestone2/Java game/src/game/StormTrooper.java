package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class StormTrooper extends Walker implements StepListener {
    /** initialising of the shape of Enemy(Stormtrooper)*/
    private static final Shape stormTrooperShape = new PolygonShape(
            -0.354f,1.005f, 1.231f,0.202f, 0.473f,-0.984f, -1.172f,-0.979f, -1.191f,-0.093f, -0.61f,0.916f);
    /** initialising of the image of the StormTrooper body.*/
    private static final BodyImage image =
            new BodyImage("data/StormTrooper.png", 2f);


    public StormTrooper(World world) {
        super(world, stormTrooperShape);
        addImage(image);
    }
    private enum State {
        ROLL_LEFT, ROLL_RIGHT, STAND_STILL
    }

    public static final float RANGE = 10;
    private Level1 game;
    private State state;

    public StormTrooper(Level1 game) {
        super(game, stormTrooperShape);
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



    /** use this to prevent the balls from slowing down and stopping due to friction when they should be rolling*/

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



