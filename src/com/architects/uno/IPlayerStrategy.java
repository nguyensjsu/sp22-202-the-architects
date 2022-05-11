import java.util.List;

public interface IPlayerStrategy {
    void act(IPlayer player, GameScreen game);
    boolean isHuman();
}
