import java.util.ArrayList;
import java.util.List; 

public interface IPlayer {
    void drawCard(IDeck deck, int amount);
    void renderCards();
    String getPlayerName();
    boolean isHuman();
}