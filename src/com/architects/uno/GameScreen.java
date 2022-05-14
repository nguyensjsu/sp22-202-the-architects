import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;


/**
 * Write a description of class GameScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameScreen extends World implements ISoundSubject
{
    private static GameScreen UnoGame;
    public static boolean showEnemyCards = false;
    static TurnState turnState;
    private BackButton backButton;
    private Button optionButton;
    private List<Button> buttons;
    private List<Player> players;
    private List<ISoundObserver> observers = new ArrayList<>();
    
    /**
     * Constructor for objects of class GameScreen.
     * 
     */
    private GameScreen() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels
        super(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, 1);
    }
    
    public synchronized static GameScreen getNewInstance() {
        UnoGame = new GameScreen();
        UnoGame.prepare();
        return UnoGame;
    }
    
    public synchronized static GameScreen getInstance() {
        if (UnoGame == null) {
            UnoGame = new GameScreen();
            UnoGame.prepare();
            return UnoGame;
        }
        else
            return UnoGame;
    }
    
    private void prepare() {
        // ensure unique deck before each game
        Deck deck = Deck.getNewInstance();
        addObject(deck,120, Constants.SCREEN_HEIGHT/2);
        
        GameRules.getNewInstance().gameSetUp();
        backButton=new BackButton( 
            120,
            102,
            "",
            1,
            Color.YELLOW,
            30,
            22);
        addObject(backButton,930, 500);
        
        optionButton = new Button(
            100,
            30,
            "Show Enemy Cards",
            100,
            Color.WHITE,
            20,
            8);
        addObject(optionButton,870, 30);
    
        buttons = GameRules.getInstance().getButtons();
        //addObject(buttons.get(2), 60, 30);

        players = GameRules.getInstance().getPlayers();
        addObject(players.get(0), Constants.SCREEN_WIDTH/2, 500);
        addObject(players.get(1), Constants.SCREEN_WIDTH/2, 100);
        
        GameRules.getInstance().getCurrentPlayer().act();
                
        // play background music now
        this.attach(new SoundHandler());
        notifySoundHandler(SoundEvent.BACKGROUND);
    }
    
    public void act(){  
        if (Greenfoot.mouseClicked(backButton)) {
            notifySoundHandler(SoundEvent.STOP);
            Greenfoot.setWorld(new MainMenu());
        }  if (Greenfoot.mouseClicked(buttons.get(1))) {
            notifySoundHandler(SoundEvent.SAY_UNO);
            PlayerRules.getInstance().sayUno();
        } if (Greenfoot.mouseClicked(optionButton)) {
            showEnemyCards = !showEnemyCards;
        }
    }
    
    
    public void attach(ISoundObserver o) {
        this.observers.add(o);
    }
    public void  detach(ISoundObserver o) {
        this.observers.remove(o);
    }
    public void notifySoundHandler(SoundEvent e) {
        for(ISoundObserver o : observers) {
            o.playSound(e);
        }
    }
    
    public Player getCurrentPlayer() {
        return GameRules.getInstance().getCurrentPlayer();
    }
    
    public IDeck getDeck() {
        return Deck.getInstance();
    }
    
    public boolean canPlayCard(Card card) {
        return GameRules.getInstance().canPlayCard(card);
    }
    
    public boolean canPlay() {
        return GameRules.getInstance().canPlay();
    }
    
    public void toggleCanPlay() {
        GameRules.getInstance().toggleCanPlay();
    }
    
    public void toggleTurn() {
        GameRules.getInstance().toggleTurn();
    }
    
    public void replaceTopCard(Card card) {
        notifySoundHandler(SoundEvent.PLAY_CARD);
        GameRules.getInstance().replaceTopCard(card);
    }
    
    public boolean isFirstTurn() {
        return GameRules.getInstance().isFirstTurn();
    }
    
    public void firstTurnDone() {
        GameRules.getInstance().firstTurnDone();
    }
    
    public void gameIsDraw() {
        GameRules.getInstance().gameIsDraw();
    }
    
    public boolean getShowEnemyCardOption() {
        return showEnemyCards;
    }
}
