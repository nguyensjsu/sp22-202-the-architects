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
         setImage(new GreenfootImage("Computer", size, Color.WHITE, Color.WHITE));
        }
   
   public void showTurn(){
    setImage(new GreenfootImage("Computer", size, textColor, background));
   //drawImage(new GreenfootImage("Text to display", 64, null, null), 40, 40);

    // getBackground().drawString("Computer", 800, 50);    
}
    public void switchTurn(){
    turnState.setState(turnState.getPlayersTurn());
    }
}

