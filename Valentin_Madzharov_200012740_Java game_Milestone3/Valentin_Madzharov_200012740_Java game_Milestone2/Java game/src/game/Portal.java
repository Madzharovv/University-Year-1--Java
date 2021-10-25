package game;

import city.cs.engine.*;

public class Portal extends StaticBody {
    /** initialising of the shape of the Portal*/
    private static final Shape portalShape = new CircleShape(1);
    /** initialising of the image of the Portal body.*/
    private static final BodyImage image =
            new BodyImage("data/Portal.gif", 2f);

    public Portal(World w) {
       super(w,portalShape);
       addImage(image);
    }
}
