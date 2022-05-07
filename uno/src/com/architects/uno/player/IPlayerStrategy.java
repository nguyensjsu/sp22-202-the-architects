public interface IPlayerStrategy {
    List<ICard> act(IPlayer player, List<ICard> cards);
    boolean isHuman();
}
