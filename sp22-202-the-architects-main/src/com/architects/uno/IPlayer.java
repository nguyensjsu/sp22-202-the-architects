public interface IPlayer {
    void drawCard(int amount);
    void renderCards();
    String getPlayerName();
    boolean isHuman();
    void checkAndPlayCard(Card card);
}