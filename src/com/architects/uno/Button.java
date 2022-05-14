 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    
    public Button(int w, int h, String fileName) {
        GreenfootImage button = new GreenfootImage(fileName);
        button.scale(w, h);
        setImage(button);
    }

}
