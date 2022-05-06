import greenfoot.*; 
import java.util.*;

/**
 * Write a description of class GameRules here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameRules  
{
    // instance variables - replace the example below with your own
    private Button backButton;
    private World world;
    private Deck deck;
    private int currentPlayer;
    private List<Player> playerOrder = new ArrayList<Player>();

    /**
     * Constructor for objects of class GameRules
     */
    public GameRules(World world)
    {
        this.world = world;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
      // game setup relate functions
      public int getPlayerNum() {
    
        return 4;
      }
    
      public void gameSetUp() {
        backButton = new Button(100, 40, "Back", 30, Color.BLACK, 23, 5);
        world.addObject(backButton,60,30);
        System.out.println("hello world");
        
        deck = new Deck();
        world.addObject(deck,70,240);
        
        User user = new User();
        world.addObject(user, 475, 430);
        this.playerOrder.add(user);
        
        Computer computerOne = new Computer();
        world.addObject(computerOne, 475, 50);
        this.playerOrder.add(computerOne);
        
        Computer computerTwo = new Computer();
        world.addObject(computerTwo, 200, 260);
        this.playerOrder.add(computerTwo);
        
        Computer computerThree = new Computer();
        world.addObject(computerThree, 750, 260);
        this.playerOrder.add(computerThree);
        
        this.currentPlayer = Greenfoot.getRandomNumber(playerOrder.size());

      }
    
      public void replaceTopCard() {
        // need put the card args in
      }
    
      // general getter and setter
      public void getTopCard() {
        // return Card type
      }
    
      public void getPlayer(int index) {
        // return specific player : player[index]
      }
    
      public void getCurrentPlayer() {
        // return the player for current round
      }
    
      public void getNextPlayer() {
        // return the next player for current round
      }
}
