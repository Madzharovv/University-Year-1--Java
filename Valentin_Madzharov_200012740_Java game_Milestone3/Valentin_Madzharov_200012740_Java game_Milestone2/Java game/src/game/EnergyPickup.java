package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class EnergyPickup implements CollisionListener {

    private Baby_yoda baby_yoda;
    public EnergyPickup(Baby_yoda b){
        this.baby_yoda = b;
    }
    /** Upon collision with the main character(Baby_yoda) the energy levels of the main character increase and the energy body is destroyed*/
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Energy) {
            baby_yoda.incrementEnergy();
            e.getOtherBody().destroy();
        }
    }}