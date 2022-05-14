import java.util.ArrayList;
import java.util.List; 

public interface IPlayer {
    void drawCard(int amount);
    void addCard(Card card);
    void removeCard(Card card);
    List<Card> getCards();
    void renderCards();
    String getPlayerName();
    boolean isHuman();
    void checkAndPlayCard(Card card);
    void sayUno();
    boolean saidUno();
}