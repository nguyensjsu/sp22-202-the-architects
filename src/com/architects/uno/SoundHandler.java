import greenfoot.*;

/**
 * Sound Handler handles sound events
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoundHandler implements ISoundObserver
{

    /**
     * Constructor for objects of class SoundManager
     */
    public SoundHandler()
    {
        GreenfootSound sound = new GreenfootSound("filename");// the filename is the same as the one you would use in the playSound method;
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
            case SAY_UNO:
                Greenfoot.playSound("say_uno.wav");
                break;
        }
    }
}
