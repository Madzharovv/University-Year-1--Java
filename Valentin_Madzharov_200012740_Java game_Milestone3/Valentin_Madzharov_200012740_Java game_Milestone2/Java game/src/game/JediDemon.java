package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class JediDemon extends Walker implements StepListener{
    /** initialising of the shape of Enemy(JediDemon)*/
    private static final Shape JediDemonShape = new PolygonShape(
            0.749f,1.0f, 0.971f,-0.325f, 1.033f,-0.995f, -0.185f,-1.0f, -1.024f,-0.72f, -1.029f,-0.58f, 0.613f,0.992f);

    /**initialising an image for the JediDemon*/

    private static final BodyImage image =
            new BodyImage("data/JediDemon.png", 2f);


    public JediDemon(World world) {
        super(world, JediDemonShape);
        addImage(image);
    }
    private enum State {
        ROLL_LEFT, ROLL_RIGHT, STAND_STILL
    }

    public static final float RANGE = 10;
    private Level6 game;
    private State state;

    public JediDemon(Level6 game) {
        super(game, JediDemonShape);
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

