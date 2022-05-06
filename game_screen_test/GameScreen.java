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
    
    private void prepare() {
        gr.gameSetUp();
        
        Deck deck = gr.getDeck();
        addObject(deck,70,240);
        
        List<Button> buttons = gr.getButtons();
        addObject(buttons.get(0), 60, 30);
        
        List<Player> players = gr.getPlayers();
        addObject(players.get(0), 475, 430);
        addObject(players.get(1), 475, 50);
        addObject(players.get(2), 200, 260);
        addObject(players.get(3), 750, 260);        
    }
}
