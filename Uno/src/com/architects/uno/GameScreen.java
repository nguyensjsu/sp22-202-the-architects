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
    // Screen resolution
    private static final int WIDTH = 805;
    private static final int HEIGHT = 480;
    private GameRules gr = GameRules.getInstance();
    private static GameScreen UnoGame;
    private List<Button> buttons;
    private List<Player> players;
    public static boolean showEnemyCards = false;
    static TurnState turnState;
    
    /**
     * Constructor for objects of class GameScreen.
     * 
     */
    private GameScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1);
        prepare();

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
        gr.gameSetUp();

        Deck deck = gr.getDeck();
        addObject(deck,70,240);

        buttons = gr.getButtons();
        addObject(buttons.get(0), 60, 30);

        players = gr.getPlayers();
        addObject(players.get(0), 475, 430);
        addObject(players.get(1), 475, 50);       
    }
    
    public void act(){
        if (Greenfoot.mouseClicked(buttons.get(0)))
        {Greenfoot.setWorld(new MainMenu());}
    }
    
    public Player getCurrentPlayer() {
        return gr.getCurrentPlayer();
    }
    
    public IDeck getDeck() {
        return gr.getDeck();
    }
    
    public boolean canPlayCard(Card card) {
        return gr.canPlayCard(card);
    }
    
    public boolean canPlay() {
        return gr.canPlay();
    }
    
    public void toggleCanPlay() {
        gr.toggleCanPlay();
    }
    
    public void toggleTurn() {
        gr.toggleTurn();
    }
    
    public void replaceTopCard(Card card) {
        gr.replaceTopCard(card);
    }
}
