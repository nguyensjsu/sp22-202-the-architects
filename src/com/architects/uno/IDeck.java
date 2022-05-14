import java.util.List;
 
public interface IDeck {
    public void init();
    public void shuffle();
    public Card drawCard();
    void addCard(Card card);
    public List<Card> getDeck();
}
