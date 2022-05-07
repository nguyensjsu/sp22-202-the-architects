import java.util.List;
 

public interface IDeck {
    public ICard drawCard();
    public List<ICard> getDeck();
}
