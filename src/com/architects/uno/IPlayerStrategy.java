import java.util.List;

public interface IPlayerStrategy {
    void play(IPlayer player);
    void checkAndPlayCard(Card card);
    boolean isHuman();
}
