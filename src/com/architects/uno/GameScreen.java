import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;


/**
 * Write a description of class GameScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameScreen extends World
{
    private static GameScreen UnoGame;
    public static boolean showEnemyCards = true;
    static TurnState turnState;
    private BackButton backButton;
    private List<Button> buttons;
    private List<Player> players;
    
    /**
     * Constructor for objects of class GameScreen.
     * 
     */
    private GameScreen() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, 1);
    }
    
    public synchronized static GameScreen getNewInstance() {
        UnoGame = new GameScreen();
        UnoGame.prepare();
        return UnoGame;
    }
    
    public synchronized static GameScreen getInstance() {
        if (UnoGame == null) {
            UnoGame = new GameScreen();
            UnoGame.prepare();
            return UnoGame;
        }
        else
            return UnoGame;
    }
    
    private void prepare() {
        GameRules.getNewInstance().gameSetUp();
        
        backButton=new BackButton( 
            120,
            102,
            "",
            1,
            Color.YELLOW,
            30,
            22);
        addObject(backButton,930, 500);
        
        
        Deck deck = GameRules.getInstance().getDeck();
        addObject(deck,120, Constants.SCREEN_HEIGHT/2);

       // buttons = GameRules.getInstance().getButtons();
        //addObject(buttons.get(0), 60, 30);

        players = GameRules.getInstance().getPlayers();
        addObject(players.get(0), Constants.SCREEN_WIDTH/2, 500);
        addObject(players.get(1), Constants.SCREEN_WIDTH/2, 100);
        
        GameRules.getInstance().getCurrentPlayer().act();
    }
    
    public void act(){
        if (Greenfoot.mouseClicked(backButton))
            Greenfoot.setWorld(new MainMenu());
    }
    
    public Player getCurrentPlayer() {
        return GameRules.getInstance().getCurrentPlayer();
    }
    
    public IDeck getDeck() {
        return GameRules.getInstance().getDeck();
    }
    
    public boolean canPlayCard(Card card) {
        return GameRules.getInstance().canPlayCard(card);
    }
    
    public boolean canPlay() {
        return GameRules.getInstance().canPlay();
    }
    
    public void toggleCanPlay() {
        GameRules.getInstance().toggleCanPlay();
    }
    
    public void toggleTurn() {
        GameRules.getInstance().toggleTurn();
    }
    
    public void replaceTopCard(Card card) {
        GameRules.getInstance().replaceTopCard(card);
    }
    
    public boolean isFirstTurn() {
        return GameRules.getInstance().isFirstTurn();
    }
    
    public void firstTurnDone() {
        GameRules.getInstance().firstTurnDone();
    }
    
    public void gameIsDraw() {
        GameRules.getInstance().gameIsDraw();
    }
}
