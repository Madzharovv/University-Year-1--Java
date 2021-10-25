package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class EmperorCollision implements CollisionListener {
private Baby_yoda baby_yoda;

    public EmperorCollision(Baby_yoda b){
        this.baby_yoda = b;
    }
    /** upon collision with the main character the lives of the main
     *  character decrease and the emperor body is destroyed.*/
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Emperor) {
            baby_yoda.superdecrementLiveCount();
            e.getOtherBody().destroy();
        }
    }
}