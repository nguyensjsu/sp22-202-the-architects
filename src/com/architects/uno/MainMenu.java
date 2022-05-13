 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
    private int buttonWidth=200;
    private int buttonHeight=50;
    public static final int textSize=35;
    private Button startGameButton;
    private Button closeButton;
    private Color RED;
   
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MainMenu() {    
        // Create a new main menu  screen with WIDTHxHEIGHT cells with a cell size of 1x1 pixels.
        super(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, 1);
        prepare();
    }
    
    public void prepare() {
        startGameButton = new Button(
            buttonWidth,
            buttonHeight,
            "NEW GAME",
            textSize,
            Color.WHITE,
            25,
            7
        );
        closeButton= new Button(
            buttonWidth,
            buttonHeight,
            "QUIT",
            textSize,
            Color.WHITE,
            65,
            8
        );
        addObject(startGameButton, Constants.SCREEN_WIDTH/2, 250);
        addObject(closeButton, Constants.SCREEN_WIDTH/2, 400);
    }
    
     public void act() {  
        if (Greenfoot.mouseClicked(startGameButton)) {
            Greenfoot.setWorld(GameScreen.getNewInstance());
        }        
        if (Greenfoot.mouseClicked(closeButton)) {
            Greenfoot.stop();
        }
    }
}
