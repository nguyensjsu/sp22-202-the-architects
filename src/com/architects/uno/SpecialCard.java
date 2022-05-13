import greenfoot.*;
public class SpecialCard extends Card
{
    private SpecialAction action;
    private CardColor color;

    public SpecialCard(SpecialAction inputAction, String imageFilename, CardColor inputColor) 
    {
        action = inputAction;
        color = inputColor;
        setImage(imageFilename);
    }

    public boolean isSpecial()
    {
        return true;
    }

    public int getNumber() 
    {
        // Returns invalid number 
        return -1;
    }

    public CardColor getColor() 
    {
        return color;
    }

    public SpecialAction getAction()
    {
        return action;
    }
    
    public void act() {
        if(Greenfoot.mouseClicked(this))
            GameScreen.getInstance().getCurrentPlayer().checkAndPlayCard(this);
    }
}