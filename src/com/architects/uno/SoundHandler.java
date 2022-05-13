import greenfoot.*;

/**
 * Sound Handler handles sound events
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoundHandler implements ISoundObserver
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class SoundManager
     */
    public SoundHandler()
    {
    }
    
    public void playSound(SoundEvent e) {
        // handle the Sound Event and Play the required Sound
        switch (e) {
            case START:
                Greenfoot.playSound("start.wav");
                break;
            case PLAY_CARD:
                Greenfoot.playSound("play_card.wav");
                break;
            case BACKGROUND:
                Greenfoot.playSound("happy.wav");
                break;
            case DRAW_CARDS:
                Greenfoot.playSound("draw.wav");
                break;
        }
    }
}
