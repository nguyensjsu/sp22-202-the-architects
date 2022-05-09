import java.util.List;

public interface IPlayerStrategy {
    List<Card> act(IPlayer player, List<Card> cards, GameScreen game);
    boolean isHuman();
}
