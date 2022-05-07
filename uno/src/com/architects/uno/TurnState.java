import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Turn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TurnState extends Actor
{
    State playersTurn;
    State computersTurn;
    State state = computersTurn;
    
    public TurnState() {
        playersTurn = new PlayersTurn(this);
        computersTurn = new ComputersTurn(this);
       
        state = computersTurn;
        setImage(new GreenfootImage("Turn:", 30, Color.WHITE, Color.BLUE));
        showTurn();
        
       
    }
    
    // public void changeTurn() {
      //  state.turn();
   // }
   
   void showTurn(){
    state.showTurn();
    }
     void setState(State statex) {
        this.state = statex;
    }
    
     protected State getComputersTurn() {
        return computersTurn;
    }
    
    protected State getPlayersTurn() {
        return playersTurn;
    }
   
}
