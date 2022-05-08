/**
 * class PlayerRules
 * 
 * @author Devansh Modi 
 * @version (a version number or a date)
 */
public class PlayerRules implements IPlayerRules
{
    // instance variables - replace the example below with your own
    private State state;

    /**
     * Constructor for objects of class PlayerRules
     */
    public PlayerRules()
    {
    }

    public void reverse() {
        GameRules.getInstance().toggleTurn();
    }

    public void skip() {
        GameRules.getInstance().toggleTurn();
    }

    public void draw(int num) {
        GameRules.getInstance().getCurrentPlayer().drawCard(num);
    }
}
