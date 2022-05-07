import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Deck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Deck extends Actor implements IDeck
{
    private ArrayList<ICard> cardDeck = new ArrayList<ICard>();
    private static Deck singleton = null;

    private Deck() {
        CardFactory cf = new CardFactory();
            }

    
    public static Deck getInstance() {
        if (singleton == null)
        {
        // Add Blue Number Cards
        ICard blue0 = CardFactory.createCard("NUMBER", "images/Blue 0.png", CardColor.BLUE, 0);

            singleton = new Deck();
        }
        return singleton; 
    }
    
    /**
     * Act - do whatever the Deck wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void addCard(ICard card) 
    {
        cardDeck.add(card);
    }

    public ICard drawCard() {
        ICard output = cardDeck.get(0);
        cardDeck.remove(0);
        return output;
    }
    
    public List<ICard> getDeck() {
        return cardDeck;
    }
}
