package game;



import city.cs.engine.*;

public class PixelBlock extends StaticBody{
    /** initialising of the shape of the pixel block*/
    public static final Shape PixelBlockShape = new PolygonShape
            (-0.04f,1.25f, 1.23f,1.23f, 1.225f,-1.205f, -1.215f,-1.22f, -1.205f,1.185f, -0.365f,1.25f);
    /** initialising of the image of the Pixel block body.*/
    private static final BodyImage image =
            new BodyImage ("data/pixelblock.png", 2);



    public PixelBlock (World world){
        super( world, PixelBlockShape);
        addImage(image);

    }
}
