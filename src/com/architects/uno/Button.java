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
                GreenfootImage button = new GreenfootImage("button4.png");
                button.scale(w, h);   
                button.drawImage(
                        new GreenfootImage(text, textSize, textColor, new greenfoot.Color(0, 0, 0,0),
                        new greenfoot.Color(181, 180, 180, 255)), h_space, v_space
                );
                setImage(button);
        }

}
