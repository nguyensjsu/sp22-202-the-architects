 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    
        public Button(int w, int h, String text, int textSize, greenfoot.Color textColor, int h_space, int v_space) {
                GreenfootImage button = new GreenfootImage("main menu buttons.png");
                button.scale(270, 60);
                button.setColor(Color.YELLOW);
                button.setFont(new Font("Comic Sans MS", true, false , 34));
                button.drawString(text, 40, 45);
                button.drawImage(
                        new GreenfootImage("", textSize, textColor, new greenfoot.Color(0, 0, 0,0),
                        new greenfoot.Color(181, 180, 180, 255)), h_space, v_space
               );
                //button.setFont(new Font("Comic Sans MS", true, false , 80));
                setImage(button);
        }

}
