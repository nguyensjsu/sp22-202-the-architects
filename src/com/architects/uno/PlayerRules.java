/**
 * class PlayerRules
 * 
 * @author Devansh Modi 
 * @version (a version number or a date)
 */
public class PlayerRules implements IPlayerRules
{
    // instance variables - replace the example below with your own    
    private static PlayerRules singleton;


    /**
     * Constructor for objects of class PlayerRules
     */
    private PlayerRules() {
    }
    
    public static synchronized PlayerRules getNewInstance() {
        singleton = new PlayerRules();
        return singleton;
    }
    
    public static synchronized PlayerRules getInstance() {
        if (singleton == null) {
            singleton = new PlayerRules();
        }
        return singleton;
    }

    public void reverse() {
        GameRules.getInstance().toggleTurn();
    }

    public void skip() {
        GameRules.getInstance().toggleTurn();
    }

    public void draw(int num) {
        GameRules.getInstance().toggleTurn();
        GameRules.getInstance().getCurrentPlayer().drawCard(num);
    }
    
    public void sayUno() {
        GameRules.getInstance().getCurrentPlayer().sayUno();
    }
}
