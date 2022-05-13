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
        setImage(new GreenfootImage("Turn: "+state.showTurn(), 25, Color.WHITE, Color.RED));
        //showTurn();    
    }
    
    public void switchTurn() {
        this.state.switchTurn();
        setImage(new GreenfootImage("Turn:"+state.showTurn(), 25, Color.WHITE, Color.RED));
    }
   
    void showTurn() {
        state.showTurn();
    }

    void setState(State statex) {
        this.state = statex;
    }

    protected void getComputersTurn() {
        this.state=computersTurn;
        
    }
    
    protected void getPlayersTurn() {
        this.state= playersTurn;
    }
   
}
