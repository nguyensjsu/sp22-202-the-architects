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
    private Button playButton;
    private Button quitButton;
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
            280,
            96,
            "NEW GAME",
            50,
            Color.YELLOW,
            30,
            22
        );
        quitButton= new Button(
            280,
            96,
            "   QUIT",
            50,
            Color.YELLOW,
            87,
            22
        );
       // addObject(playButton, 300, 400);
        addObject(quitButton, 500, 400);
    }
    
    public void showResult(){
    
    GreenfootImage img = new GreenfootImage(500, 100);
    
    img.setColor(Color.YELLOW);
    img.setFont(new Font("Comic Sans MS", true, false , 50));
    img.drawString(result, 20, 50);
    
    this.getBackground().drawImage(
            img, 
            ((Constants.SCREEN_WIDTH - img.getWidth())/2)+70 , 
            (Constants.SCREEN_HEIGHT - img.getHeight())/2
        );
    }
      
    public void act() {
        if(Greenfoot.mouseClicked(quitButton)) {
            Greenfoot.delay(25);
            //Greenfoot.stop();
            Greenfoot.setWorld(new MainMenu());
            
            
        }
        if(Greenfoot.mouseClicked(playButton)) {
            Greenfoot.delay(25);
            Greenfoot.stop();
            Greenfoot.setWorld(GameScreen.getNewInstance());
            
        }
        
    }
}
