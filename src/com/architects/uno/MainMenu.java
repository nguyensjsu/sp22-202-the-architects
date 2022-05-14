 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
    private int buttonWidth=250;
    private int buttonHeight=80;
    public static final int textSize=50;
    private Button startGameButton;
    private Button closeButton;
    private Button optionButton;
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
            Color.YELLOW,
            30,
            22
        );
        closeButton= new Button(
            buttonWidth,
            buttonHeight,
            "   QUIT",
            textSize,
            Color.YELLOW,
            87,
            22
        );
        optionButton= new Button(
            buttonWidth,
            buttonHeight,
            "Show Enemy Cards",
            textSize,
            Color.YELLOW,
            87,
            22
        );
        addObject(startGameButton, 183, 160);
        addObject(optionButton, 183, 320);
        addObject(closeButton, 183, 480);
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
