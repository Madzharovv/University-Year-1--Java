package game;

import city.cs.engine.World;
import java.awt.*;


public abstract class GameLevel extends World {
    private Baby_yoda baby_yoda;
    private Portal portal;


    public GameLevel(Game game){

        baby_yoda = new Baby_yoda(this);
        portal = new Portal(this);
        PortalEncounter encounter =new PortalEncounter(this,game);
        baby_yoda.addCollisionListener(encounter);
    }


    public Baby_yoda getBaby_yoda(){
        return baby_yoda;
    }
    public Portal getPortal(){
        return portal;
    }
    public abstract boolean isComplete();


    public abstract Image paintBackground();

    public abstract String getLevelName();


}
