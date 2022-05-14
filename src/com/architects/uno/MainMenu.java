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
    private Button trainingModeOnButton;
    private Button trainingModeOffButton;
    private Button currentTrainingModeButton;
    private boolean currentTrainingModeStatus;
   
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
        currentTrainingModeStatus = GameScreen.showEnemyCards;
        
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
        trainingModeOnButton = new Button(
            Constants.BUTTON_WIDTH,
            Constants.BUTTON_HEIGHT,
            Constants.TRAINING_ON_BUTTON
        );
        trainingModeOffButton = new Button(
            Constants.BUTTON_WIDTH,
            Constants.BUTTON_HEIGHT,
            Constants.TRAINING_OFF_BUTTON
        );
        
        currentTrainingModeButton = currentTrainingModeStatus
            ? trainingModeOnButton
            : trainingModeOffButton;
        
        addObject(
            startGameButton,
            Constants.SCREEN_WIDTH/5,
            Constants.SCREEN_HEIGHT/2 - 92
        );
        addObject(
            currentTrainingModeButton,
            Constants.SCREEN_WIDTH/5,
            Constants.SCREEN_HEIGHT/2
        );
        addObject(
            closeButton,
            Constants.SCREEN_WIDTH/5,
            Constants.SCREEN_HEIGHT/2 + 92
        );
    }
    
     public void act() { 
        if (Greenfoot.mouseClicked(currentTrainingModeButton)) {
            removeObject(currentTrainingModeButton);
            this.repaint();
            
            currentTrainingModeStatus = !currentTrainingModeStatus;
            GameScreen.showEnemyCards = currentTrainingModeStatus;
            
            currentTrainingModeButton = currentTrainingModeStatus
            ? trainingModeOnButton
            : trainingModeOffButton;
            
            addObject(
                currentTrainingModeButton,
                Constants.SCREEN_WIDTH/5,
                Constants.SCREEN_HEIGHT/2
            );
            this.repaint();
        } 
        if (Greenfoot.mouseClicked(startGameButton)) {
            Greenfoot.setWorld(GameScreen.getNewInstance());
        }        
        if (Greenfoot.mouseClicked(closeButton)) {
            Greenfoot.stop();
        }
    }
}
