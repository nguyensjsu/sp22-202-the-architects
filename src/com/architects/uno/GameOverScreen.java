import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverScreen extends World
{
    private String result;
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
    }
    
    public void showResult() {
        GreenfootImage resultImage = new GreenfootImage(
            result,
            60,
            new Color(255, 223, 43),
            new Color(0, 0, 0, 0)
        );
        
        this.getBackground().drawImage(
            resultImage, 
            (Constants.SCREEN_WIDTH - resultImage.getWidth())/2, 
            (Constants.SCREEN_HEIGHT - resultImage.getHeight())/2
        );
    }
    
    public void act() {
        if(Greenfoot.mouseClicked(this)) {
            Greenfoot.delay(25);
            Greenfoot.setWorld(new MainMenu());
        }
    }
}
