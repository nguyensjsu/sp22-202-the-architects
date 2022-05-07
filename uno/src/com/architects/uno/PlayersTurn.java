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
    setImage(new GreenfootImage("Human", size, Color.WHITE, Color.WHITE));

        }
   
   public void showTurn(){
    setImage(new GreenfootImage("Human", size, textColor, background));
    }
    public void switchTurn(){
    turnState.setState(turnState.getComputersTurn());
    }
}
