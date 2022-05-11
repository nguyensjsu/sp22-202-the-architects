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
    private boolean canPlay;
    private int currentPlayer;
    private PlayerRules playerRules;
    private TurnState turnState;
    private List<Player> playerOrder;
    private List<Button> buttons;

    private static GameRules singleton;

    /**
         * An example of a method - replace this comment with your own
         *
         * @param  y   a sample parameter for a method
         * @return     the sum of x and y
         */

    private GameRules() {
        canPlay = true;
        turnState = new TurnState();
        playerRules = new PlayerRules();
        buttons = new ArrayList<Button>();
        playerOrder = new ArrayList<Player>();
    }

    public static synchronized GameRules getNewInstance() {
        singleton = new GameRules();
        return singleton;
    }
    
    public static synchronized GameRules getInstance() {
        if (singleton == null) {
            singleton = new GameRules();
        }
        return singleton;
    }

    // game setup relate functions
    public int getPlayerNum() {

        return 2;
    }

    public void gameSetUp() {
        GameScreen.getInstance().addObject(turnState, 900, 300);
        backButton = new Button(100, 40, "Back", 30, Color.BLACK, 23, 5);
        this.buttons.add(backButton);
        deck = Deck.getNewInstance();

        Player user = new Player("User #1", new UserStrategy());
        this.playerOrder.add(user);

        Player computer = new Player("computer #1", new ComputerStrategy());
        this.playerOrder.add(computer);

        this.currentPlayer = 1; //Greenfoot.getRandomNumber(playerOrder.size());
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
        if (topCard == null) {
            GameScreen.getInstance().addObject(card, 475, 300);  // default coordinates when first card to be played.          
        } else {
            // remove the previous top card first
            GameScreen.getInstance().removeObject(topCard);
            GameScreen.getInstance().repaint();
            GameScreen.getInstance().addObject(card, 475, 300);
            GameScreen.getInstance().repaint();
            Greenfoot.delay(30);
        }
        
        topCard = card;
        GameScreen.getInstance().repaint();
        if (card instanceof SpecialCard) {
            // Player Special Colored Cards
            SpecialCard specialCard = (SpecialCard) card;

            if (specialCard.getAction() == SpecialAction.DRAW_TWO) {
                playerRules.draw(2);
            } else if (specialCard.getAction() == SpecialAction.REVERSE) { 
                //this.turnState.switchTurn();
                //this.turnState.showTurn();
                playerRules.reverse();
            } else if (specialCard.getAction() == SpecialAction.SKIP) {
                //toggleTurn();
                playerRules.skip();
            }
            wait(500);
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
        this.currentPlayer = (this.currentPlayer == 0 ? 1 : 0);  
        this.turnState.switchTurn();
    }
    
    public int getNextPlayerIndex() {
        return (this.currentPlayer + 1) % this.playerOrder.size();
    }

    public boolean canPlayCard(Card card) {
        if (topCard == null) {
            return true; // allow to play if this is the first card to be played.
        }
        boolean isPowerCard = card instanceof SpecialCard;
        boolean doesColorMatch = card.getColor() != null && getTopCard().getColor() != null && card.getColor().equals(getTopCard().getColor());
        boolean doesNumberMatch = card instanceof NumberCard && getTopCard() instanceof NumberCard && ((NumberCard) card).getNumber() == ((NumberCard) getTopCard()).getNumber();
        boolean doesSpecialMatch = card instanceof SpecialCard && getTopCard() instanceof SpecialCard && ((SpecialCard) card).getAction() == ((SpecialCard) getTopCard()).getAction();
        return isPowerCard || doesColorMatch || doesNumberMatch || doesSpecialMatch;
    }

    // general getter and setter
    public Card getTopCard() {
        return topCard;
    }

    public void getPlayer(int index) {
        // return specific player : player[index]
    }

    public Player getCurrentPlayer() {
        // return the player for current round
        return this.playerOrder.get(this.currentPlayer);
        //return this.playerOrder[(int)this.currentPlayer];
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

    public Deck getDeck() {
        return Deck.getInstance();
    }
    
    public boolean canPlay() {
        return this.canPlay;
    }
    
    public void toggleCanPlay() {
        this.canPlay = !this.canPlay;
    }
}
