import java.util.List;
 

public interface IDeck {
    public void init();
    public void shuffle();
    public Card drawCard();
    public List<Card> getDeck();
}
