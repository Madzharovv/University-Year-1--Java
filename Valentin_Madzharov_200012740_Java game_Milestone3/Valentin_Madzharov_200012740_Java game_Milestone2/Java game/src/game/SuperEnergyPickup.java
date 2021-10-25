package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class SuperEnergyPickup implements CollisionListener {

    private Baby_yoda baby_yoda;
    public SuperEnergyPickup( Baby_yoda b){
        this.baby_yoda = b;
    }
    /** Upon collision with the main character(Baby_yoda) the energy levels of the main character increase and the superEnergy body is destroyed*/
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof SuperEnergy) {
            baby_yoda.incrementsuperEnergy();
            e.getOtherBody().destroy();
        }
    }}