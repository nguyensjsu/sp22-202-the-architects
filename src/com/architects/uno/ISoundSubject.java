/**
 * Write a description of class ISoundSubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ISoundSubject  
{
    void attach(ISoundObserver o);
    void  detach(ISoundObserver o);
    void notifySoundHandler(SoundEvent e);
}
