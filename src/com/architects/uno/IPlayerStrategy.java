import java.util.List;
/**
 * Interface for various player strategies.
 * 
 * @author Ashutosh Ojha (leoAshu) 
 */
public interface IPlayerStrategy {
    void play(IPlayer player);
    void checkAndPlayCard(Card card);
    boolean isHuman();
}
