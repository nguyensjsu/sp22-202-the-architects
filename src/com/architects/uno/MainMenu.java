 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
    public static final int textSize=26;
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
            Constants.BUTTON_WIDTH,
            Constants.BUTTON_HEIGHT,
            Constants.NEW_GAME_BUTTON
        );
        closeButton= new Button(
            Constants.BUTTON_WIDTH,
            Constants.BUTTON_HEIGHT,
            Constants.QUIT_BUTTON
        );
        optionButton = new Button(
            Constants.BUTTON_WIDTH,
            Constants.BUTTON_HEIGHT,
            Constants.SAMPLE_BUTTON
        );
        addObject(startGameButton, Constants.SCREEN_WIDTH/5, 200);
        addObject(optionButton, Constants.SCREEN_WIDTH/5, 300);
        addObject(closeButton, Constants.SCREEN_WIDTH/5, 350);
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
