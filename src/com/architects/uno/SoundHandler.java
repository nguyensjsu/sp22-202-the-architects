import greenfoot.*;

/**
 * Sound Handler handles sound events
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoundHandler implements ISoundObserver
{

    public GreenfootSound track1;
    
    public GreenfootSound track2;
    
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
            case STOP:
                if (track1 != null && track1.isPlaying()) {
                    track1.stop();
                }
                break;
            case PLAY_CARD:
                Greenfoot.playSound("play_card.wav");
                break;
            case BACKGROUND:
                track1 = new GreenfootSound("happy.wav");
                track1.play();
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
