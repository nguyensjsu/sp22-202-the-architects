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
    private ArrayList<Card> cardDeck;
    private static Deck singleton;

    private Deck() {
        cardDeck = new ArrayList<Card>();
        init();
        shuffle();
    }
    
    public static synchronized Deck getInstance() {
        if (singleton == null)
        {
            singleton = new Deck();
        }
        return singleton; 
    }
    
    public void init() {
        CardFactory cf = new CardFactory();
        
        // Add Blue Number Cards
        for (int index = 0; index < 10; index++)
        {
            String path = "images/Blue " +  index + ".png";
            Card blue0 = CardFactory.createCard("NUMBER", path, CardColor.BLUE, index);
            addCard(blue0);
        }
        // Add Blue Special Cards
        Card blueSpecial = CardFactory.createCard("SPECIAL", "images/Blue draw 2.png", CardColor.BLUE, SpecialAction.DRAW_TWO);
        addCard(blueSpecial);
        blueSpecial = CardFactory.createCard("SPECIAL", "images/Blue reverse.png", CardColor.BLUE, SpecialAction.REVERSE);
        addCard(blueSpecial);
        blueSpecial = CardFactory.createCard("SPECIAL", "images/Blue skip.png", CardColor.BLUE, SpecialAction.SKIP);
        addCard(blueSpecial);
        
        // Add Red Number Cards
        for (int index = 0; index < 10; index++)
        {
            String path = "images/Red " +  index + ".png";
            Card red0 = CardFactory.createCard("NUMBER", path, CardColor.RED, index);
            addCard(red0);
        }
        // Add Red Special Cards
        Card redSpecial = CardFactory.createCard("SPECIAL", "images/Red draw 2.png", CardColor.RED, SpecialAction.DRAW_TWO);
        addCard(redSpecial);
        redSpecial = CardFactory.createCard("SPECIAL", "images/Red reverse.png", CardColor.RED, SpecialAction.REVERSE);
        addCard(redSpecial);
        redSpecial = CardFactory.createCard("SPECIAL", "images/Red skip.png", CardColor.RED, SpecialAction.SKIP);
        addCard(redSpecial);
        
        // Add Yellow Number Cards
        for (int index = 0; index < 10; index++)
        {
            String path = "images/Yellow " +  index + ".png";
            Card red0 = CardFactory.createCard("NUMBER", path, CardColor.YELLOW, index);
            addCard(red0);
        }
        // Add Yellow Special Cards
        Card yellowSpecial = CardFactory.createCard("SPECIAL", "images/Yellow draw 2.png", CardColor.YELLOW, SpecialAction.DRAW_TWO);
        addCard(yellowSpecial);
        yellowSpecial = CardFactory.createCard("SPECIAL", "images/Yellow reverse.png", CardColor.YELLOW, SpecialAction.REVERSE);
        addCard(yellowSpecial);
        yellowSpecial = CardFactory.createCard("SPECIAL", "images/Yellow skip.png", CardColor.YELLOW, SpecialAction.SKIP);
        addCard(yellowSpecial);        

        // Add Green Number Cards
        for (int index = 0; index < 10; index++)
        {
            String path = "images/Green " +  index + ".png";
            Card green0 = CardFactory.createCard("NUMBER", path, CardColor.GREEN, index);
            addCard(green0);
        }
        // Add Green Special Cards
        Card greenSpecial = CardFactory.createCard("SPECIAL", "images/Green draw 2.png", CardColor.GREEN, SpecialAction.DRAW_TWO);
        addCard(greenSpecial);
        greenSpecial = CardFactory.createCard("SPECIAL", "images/Green reverse.png", CardColor.GREEN, SpecialAction.REVERSE);
        addCard(greenSpecial);
        greenSpecial = CardFactory.createCard("SPECIAL", "images/Green skip.png", CardColor.GREEN, SpecialAction.SKIP);
        addCard(greenSpecial);
    }
    
    public void shuffle() {
        // Shuffle Deck
        Collections.shuffle(this.cardDeck);
    }
    
    /**
     * Act - do whatever the Deck wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void addCard(Card card) 
    {
        cardDeck.add(card);
    }

    public Card drawCard() {
        Card output = cardDeck.get(0);
        cardDeck.remove(0);
        return output;
    }
    
    public List<Card> getDeck() {
        return cardDeck;
    }
}
