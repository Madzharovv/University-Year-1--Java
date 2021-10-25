package game;



import city.cs.engine.BodyImage;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class StormTrooperCollision implements CollisionListener {

    private Baby_yoda baby_yoda;
    public StormTrooperCollision(Baby_yoda b){
        this.baby_yoda= b;
    }
    /** upon collision with the main character the lives of the main character
     *  decrease and the StormTrooper body is destroyed.*/
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof StormTrooper) {
            baby_yoda.decrementLiveCount();
            e.getOtherBody().destroy();
        }
    }}