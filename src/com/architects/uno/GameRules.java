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
    private boolean canPlay;
    private int currentPlayer;
    private boolean isFirstTurnFlag;
    
    private Button backButton;
    private Card topCard;
    
    private PlayerRules playerRules;
    private TurnState turnState;
    
    private List<Button> buttons;
    private List<Player> playerOrder;
    

    private static GameRules singleton;
    
    /**
         * An example of a method - replace this comment with your own
         *
         * @param  y   a sample parameter for a method
         * @return     the sum of x and y
         */

    private GameRules() {
        canPlay = true;
        isFirstTurnFlag = true;
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
        GameScreen.getInstance().addObject(turnState, 900, Constants.SCREEN_HEIGHT/2);
        backButton = new Button(100, 40, "Back", 30, Color.WHITE, 23, 5);
        this.buttons.add(backButton);

        Player user = new Player("User #1", new UserStrategy());
        this.playerOrder.add(user);

        Player computer = new Player("Computer #1", new ComputerStrategy());
        this.playerOrder.add(computer);

        this.currentPlayer = 1; //Greenfoot.getRandomNumber(playerOrder.size());
    }

    public void replaceTopCard(Card card) {
        if (topCard == null) {
            GameScreen.getInstance().addObject(card, Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2);  // default coordinates when first card to be played.          
        } else {
            // remove the previous top card first
            GameScreen.getInstance().removeObject(topCard);
            GameScreen.getInstance().repaint();
            GameScreen.getInstance().addObject(card, Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2);
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
                playerRules.reverse();
            } else if (specialCard.getAction() == SpecialAction.SKIP) {
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
        GameScreen.getInstance().repaint();
    }

    public boolean canPlayCard(Card card) {
        if (topCard == null) {
            return true; // allow to play if this is the first card to be played.
        }
        boolean doesNumberMatch = (card.getNumber() == topCard.getNumber()) 
            && card.getNumber() != -1; 
        boolean doesColorMatch = card.getColor() == topCard.getColor();
        boolean doesSpecialActionMatch = (card.getAction() == topCard.getAction())
            && card.isSpecial();
        if(!card.isSpecial()) {
            return doesNumberMatch || doesColorMatch;
        } else {
            return doesSpecialActionMatch || doesColorMatch;
        }
        //boolean isPowerCard = card instanceof SpecialCard;
        //boolean doesColorMatch = card.getColor() != null && getTopCard().getColor() != null && card.getColor().equals(getTopCard().getColor());
        //boolean doesNumberMatch = card instanceof NumberCard && getTopCard() instanceof NumberCard && ((NumberCard) card).getNumber() == ((NumberCard) getTopCard()).getNumber();
        //boolean doesSpecialMatch = card instanceof SpecialCard && getTopCard() instanceof SpecialCard && ((SpecialCard) card).getAction() == ((SpecialCard) getTopCard()).getAction();
        //return isPowerCard || doesColorMatch || doesNumberMatch || doesSpecialMatch;
    }
    
    public Card getTopCard() {
        return topCard;
    }

    public Player getCurrentPlayer() {
        // return the player for current round
        return this.playerOrder.get(this.currentPlayer);
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
    
    public boolean isFirstTurn() {
        return isFirstTurnFlag;
    }
    
    public void firstTurnDone() {
        isFirstTurnFlag = false;
    }
    
    public void gameIsDraw() {
        Greenfoot.setWorld(new GameOverScreen("It's a Draw!"));
    }
    
}
