import java.util.List;

public interface IPlayerStrategy {
    void act(IPlayer player, GameScreen game);
    void checkAndPlayCard(Card card);
    boolean isHuman();
}
