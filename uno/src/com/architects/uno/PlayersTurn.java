import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayersTurn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayersTurn extends Actor implements State
{   private int size=80;
    private Color textColor=Color.WHITE;
     private Color background=new Color(0, 0, 255, 0);
     TurnState turnState;
     
    public PlayersTurn(TurnState turn)
     {this.turnState=turn;
        //GreenfootImage img = new GreenfootImage("Human", 35, Color.BLACK, new Color(0, 0, 0, 0));
//That will make a GreenfootImage with your string with black letters on a transparent ground with a font size of 35;
//setImage(img); //you need to set the image of your actor to the image you created to see it;
    showTurn();
        // setImage(new GreenfootImage("Human", size, Color.WHITE, Color.WHITE));

        }
   
   public String showTurn(){
    //setImage(new GreenfootImage("Human", size, textColor, background));
    return "Human";
    }
    public void switchTurn(){
    turnState.setState(turnState.getComputersTurn());
    }
}
