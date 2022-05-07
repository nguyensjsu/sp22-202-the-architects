import java.util.ArrayList;
import java.util.List;

public interface IPlayerStrategy {
    List<ICard> act(IPlayer player, List<ICard> cards, GameScreen game);
    boolean isHuman();
}
