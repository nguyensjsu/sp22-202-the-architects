import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class of type World to display the game results after a game ends.
 * 
 * @author Ashutosh Ojha (leoAshu) 
 */
public class GameOverScreen extends World
{
    private String result;
    private Button playButton;
    private Button menuButton;
    /**
     * Constructor for objects of class GameOverScreen.
     * 
     */
    public GameOverScreen(String result)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, 1);
        this.result = result;
        showResult();
        
        playButton = new Button(
            160,
            Constants.BUTTON_HEIGHT,
            Constants.PLAY_AGAIN_BUTTON
        );
        menuButton= new Button(
            160,
            Constants.BUTTON_HEIGHT,
            Constants.MENU_BUTTON
        );
        addObject(
            playButton,
            Constants.SCREEN_WIDTH/2 - 96, 
            Constants.SCREEN_HEIGHT/2 + 76
        );
        addObject(
            menuButton,
            Constants.SCREEN_WIDTH/2 + 96,
            Constants.SCREEN_HEIGHT/2 + 76
        );
    }
    
    public void showResult() {
        GreenfootImage img = new GreenfootImage(500, 100);
    
        img.setColor(Constants.YELLOW);
        img.setFont(new Font("Comic Sans MS", true, false , 50));
        img.drawString(result, 20, 50);
    
        this.getBackground().drawImage(
            img, 
            ((Constants.SCREEN_WIDTH - img.getWidth())/2)+70 , 
            (Constants.SCREEN_HEIGHT - img.getHeight())/2
        );
    }
    
    public void act() {
        if(Greenfoot.mouseClicked(menuButton)) {
            Greenfoot.delay(25);
            Greenfoot.setWorld(new MainMenu());
        }
        if(Greenfoot.mouseClicked(playButton)) {
            Greenfoot.delay(25);
            Greenfoot.setWorld(GameScreen.getNewInstance());
        }
    }
}
