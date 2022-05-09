 
import greenfoot.Color;

public interface ICard {
    public boolean isSpecial();
    public int getNumber();
    public CardColor getColor();
    public SpecialAction getAction();
}
