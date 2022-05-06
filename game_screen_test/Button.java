import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
     public Button(int width, int height, String text, int textSize, Color textColor, int xOffset, int yOffset) {
        GreenfootImage image = new GreenfootImage("button.png");
        image.scale(width, height);
        image.drawImage(new GreenfootImage(text, textSize, textColor, new Color(255, 255, 255, 0)), xOffset, yOffset);
        setImage(image);
    }
}
