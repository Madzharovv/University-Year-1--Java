package game;

import city.cs.engine.*;


/**initialising of the shape of the main character (Baby_yoda)*/
public class Baby_yoda extends Walker{
    public static final Shape Baby_yodaShape = new PolygonShape
            (-0.06f,0.616f, 0.812f,0.26f, 0.568f,-1.0f, -0.556f,-0.984f, -0.9f,0.212f, -0.328f,0.528f);

    private static final BodyImage image =
            new BodyImage ("data/baby-yoda.gif", 2f);

/**The two variables of the main Character (Baby_yoda)*/
    private int  LiveCount;
    private int  Energy;


    public Baby_yoda(World world){
        super( world, Baby_yodaShape);
        addImage(image);

        Energy=0;
        LiveCount=50;
    }
/** The methods bellow are getters  used for the increasing of the energy levels of the main character
 * (Baby_yoda) and also they are used for the decreasing of the lives of the main character (Baby_yoda)
 */
    public int getLiveCount(){

        return this.LiveCount;
    }


    public int  getEnergy(){

        return this.Energy;
    }

    //increases of energy method
    public void incrementEnergy (){
      Energy=Energy+1;
      System.out.println(" Energy level: "+ Energy);
    }

    //increases of SuperEnergy  method
    public void incrementsuperEnergy (){
        Energy=Energy+3;
        System.out.println("Super energy used: Energy level: "+ Energy);
    }

    //decreases lives methods
    public void decrementLiveCount (){
        LiveCount=LiveCount-1 ;
        System.out.println(" Lives level: "+ LiveCount);
    }
//decreases the lives significantly
    public void superdecrementLiveCount (){

        LiveCount=LiveCount-3 ;
        System.out.println(" Lives level: "+ LiveCount);
    }


    public void  superExtradecrementLiveCount (){

        LiveCount=LiveCount-5 ;
        System.out.println(" Lives level: "+ LiveCount);
    }
   /** The setters bellow used to set the values of the variables that are Energy and
    * LiveCount for each level when the game is loaded after it has been saved */

    public void setEnergy(int en){
        Energy=en;
    }

    public void setLiveCount(int li){
        LiveCount=li;
    }

}