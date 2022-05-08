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
    private Card topCard;
    private Deck deck;
    private boolean canPlay = true;
    private GameScreen gs = GameScreen.getInstance();
    private int currentPlayer;
    private TurnState turnState = new TurnState();
    private List<Player> playerOrder = new ArrayList<Player>();
    private List<Button> buttons = new ArrayList<Button>();
    private static GameRules singleton = null;

    /**
         * An example of a method - replace this comment with your own
         *
         * @param  y   a sample parameter for a method
         * @return     the sum of x and y
         */

    private GameRules() {
    }

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
      gs.addObject(turnState, 900, 45);
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

    public void replaceTopCard(Card card) {
        gs.addObject(card, topCard.getX(), topCard.getY());
        topCard = card;
        gs.repaint();
        if (card instanceof SpecialCard) {
            // Player Special Colored Cards
            SpecialCard specialCard = (SpecialCard) card;

            if (specialCard.getAction() == SpecialAction.DRAW_TWO) {
                this.playerOrder.get(getNextPlayerIndex()).drawCard(2);
                toggleTurn();
            } else if (specialCard.getAction() == SpecialAction.REVERSE) {
                this.turnState.switchTurn();
                this.turnState.showTurn();
            } else if (specialCard.getAction() == SpecialAction.SKIP) {
                toggleTurn();
            }
            wait(100);
            toggleTurn();
        } else {
            toggleTurn();
        }
    }

        public static void wait(int microseconds) {
        try {
            Thread.sleep(microseconds);
        } catch (InterruptedException e) {
            System.out.println("Sleep stopped!");
        }
    }
    
        public void toggleTurn() {
        this.currentPlayer = (this.currentPlayer + 1) % 2;  
        this.turnState.showTurn();
    }
    
    public int getNextPlayerIndex() {
      return (this.currentPlayer + 1) % this.playerOrder.size();
    }

    public boolean canPlayCard(Card card) {
      boolean isPowerCard = card instanceof SpecialCard;
      boolean doesColorMatch = card.getColor() != null && topCard.getColor() != null && card.getColor().equals(topCard.getColor());
      boolean doesNumberMatch = card instanceof NumberCard && topCard instanceof NumberCard && ((NumberCard) card).getNumber() == ((NumberCard) topCard).getNumber();
      boolean doesSpecialMatch = card instanceof SpecialCard && topCard instanceof SpecialCard && ((SpecialCard) card).getAction() == ((SpecialCard) topCard).getAction();
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
    
    public boolean canPlay() {
        return this.canPlay;
    }
    
    public void toggleCanPlay() {
        this.canPlay = !this.canPlay;
    }
}
