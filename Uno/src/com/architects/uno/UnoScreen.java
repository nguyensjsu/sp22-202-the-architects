 

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class UnoScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UnoScreen extends World
{

     public static final int WIDTH =1000;
     public static final int HEIGHT =600;
     private int buttonWidth=70;
     private int buttonHeight=30;
       public static final int textSize=25;
     private Button backButton;
     static TurnState turnState;
    
     private static UnoScreen UnoGame=null;
     
     private UnoScreen() {super(WIDTH, HEIGHT, 1); }
     
     public synchronized static UnoScreen getNewInstance() {
        UnoGame = new UnoScreen();
        UnoGame.prepare();
        return UnoGame;
    }
    
    
    public synchronized static UnoScreen getInstance() {
        if (UnoGame == null) {
            UnoGame = new UnoScreen();
            UnoGame.prepare();
            return UnoGame;
        }
        else
            return UnoGame;
    }
    
    // public UnoScreen()
    //{    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
     //   super(WIDTH, HEIGHT, 1); 
      //  prepare();
    //}
    public void prepare(){
    backButton=new Button(buttonWidth,buttonHeight,"BACK",textSize, Color.WHITE,10,4);
    addObject(backButton,35,50);
    TurnState turnState=new TurnState();
    
    
    }
    
    public void act(){
    if (Greenfoot.mouseClicked(backButton))
    {Greenfoot.setWorld(new MainMenu());}
    }
}
