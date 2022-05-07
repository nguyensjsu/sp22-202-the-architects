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
    private GameRules gr = new GameRules(this);
    private static GameScreen UnoGame;
    private List<Button> buttons;
    private List<Player> players;
    
    /**
     * Constructor for objects of class GameScreen.
     * 
     */
    public GameScreen()
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
        addObject(players.get(2), 200, 260);
        addObject(players.get(3), 750, 260);        
    }
    
    public void act(){
        if (Greenfoot.mouseClicked(buttons.get(0)))
        {Greenfoot.setWorld(new MainMenu());}
    }
}
