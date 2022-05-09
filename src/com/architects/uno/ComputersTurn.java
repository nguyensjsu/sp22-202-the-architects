import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ComputersTurn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComputersTurn extends Actor  implements State
{
     public int size=80;
     public Color textColor=Color.WHITE;
     public Color background=new Color(0, 0, 255, 0);
     TurnState turnState;
     
     public ComputersTurn(TurnState turn)
     {this.turnState=turn;
       //  GreenfootImage img = new GreenfootImage("Computer", 35, Color.BLACK, new Color(0, 0, 0, 0));
//That will make a GreenfootImage with your string with black letters on a transparent ground with a font size of 35;
//setImage(img); //you need to set the image of your actor to the image you created to see it;
    showTurn();
        // setImage(new GreenfootImage("Computer", size, Color.WHITE, Color.WHITE));
        }
   
   public String showTurn(){
    //setImage(new GreenfootImage("Computer", size, textColor, background));
   //drawImage(new GreenfootImage("Text to display", 64, null, null), 40, 40);
    return "Computer";
    // getBackground().drawString("Computer", 800, 50);    
}
    public void switchTurn(){
    turnState.getPlayersTurn();
    }
}

