package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class PortalEncounter implements CollisionListener {

    private GameLevel level;
    private Game game;

    public PortalEncounter(GameLevel level, Game game){
        this.level = level;
        this.game = game;
    }



    @Override
    public void collide(CollisionEvent e) {

        /**if the main character(Baby_yoda) collided with Portal and the conditions for completing the level are fulfilled goToNextLevel*/

        if (e.getOtherBody() instanceof Portal
                && level.isComplete()){
            game.goToNextLevel();
        }
    }
}
