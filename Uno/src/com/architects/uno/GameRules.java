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
    private List<Button> buttons = new ArrayList<Button>();
    private static GameRules singleton = null;

        /**
         * An example of a method - replace this comment with your own
         * 
         * @param  y   a sample parameter for a method
         * @return     the sum of x and y 
         */
    
      private GameRules() {}
      
      public static synchronized GameRules getInstance() {
        if (singleton == null)
        {
            singleton = new GameRules();
        }
        return singleton; 
      }
      // game setup relate functions
      public int getPlayerNum() {
    
        return 4;
      }
    
      public void gameSetUp() {          
        backButton = new Button(100, 40, "Back", 30, Color.BLACK, 23, 5);
        this.buttons.add(backButton);
        deck = Deck.getInstance();
        
        Player user = new Player("User #1", new UserStrategy());
        this.playerOrder.add(user);
        
        Player computer = new Player("computer #1", new ComputerStrategy());
        this.playerOrder.add(computer);
    
        this.currentPlayer = Greenfoot.getRandomNumber(playerOrder.size());
        

      }
    
      public List<ICard> getCardFromDeck(int num) {
        List<ICard> cardsDeck = new ArrayList<ICard>();
        for (int i = 0; i < num; i++) {
            ICard newCard = deck.drawCard();
            cardsDeck.add(newCard);
        }
        return cardsDeck;
      }
      
      public void replaceTopCard() {
        // need put the card args in
      }
    
      public boolean canPlayCard(Card card) {
        boolean isPowerCard = card instanceof SpecialCard;
        boolean doesColorMatch = card.getColor() != null && topCard.getColor() != null && card.getColor().equals(topCard.getColor());
        boolean doesNumberMatch = card instanceof NumberCard && topCard instanceof NumberCard && ((NumberCard) card).getValue() == ((NumberCard) topCard).getValue();
        boolean doesSpecialMatch = card instanceof SpecialCard && topCard instanceof SpecialCard && ((SpecialCard) card).getPower().equals(((SpecialCard) topCard).getPower());
        return isPowerCard || doesColorMatch || doesNumberMatch || doesSpecialMatch;
      }
    
      // general getter and setter
      public void getTopCard() {
        // return Card type
      }
    
      public void getPlayer(int index) {
        // return specific player : player[index]
      }
    
      public Player getCurrentPlayer() {
        // return the player for current round
        return this.playerOrder.get(this.currentPlayer);
      }
    
      public void getNextPlayer() {
        // return the next player for current round
      }
      
      public List<Player> getPlayers() {
          return this.playerOrder;
      }
      
      public List<Button> getButtons() {
          return this.buttons;
      }
        
      public Deck getDeck(){
        return Deck.getInstance();
      }
}
