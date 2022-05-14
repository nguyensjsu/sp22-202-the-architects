import java.util.ArrayList;
import java.util.List; 

public interface IPlayer {
    void drawCard(int amount);
    void renderCards();
    String getPlayerName();
    boolean isHuman();
    void checkAndPlayCard(Card card);
    void sayUno();
    boolean saidUno();
    List<Card> getCards();
}