import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public abstract class Player extends Actor implements IPlayer {
    private static final int DECK_SIZE = 7;

    String playerName;
    List<ICard> cards;

    public Player(String playerName, IDeck deck) {
        this.playerName = playerName;
        this.cards = new ArrayList<>();
        drawCard(deck, DECK_SIZE);
        renderCards();
    }

    @Override
    public void drawCard(IDeck deck, int amount) {
        // adds a card to the deck
    }
    
    @Override
    public void renderCards() {
        // uses appropriate image file to render cards
    }
    
    @Override
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public abstract void act();
    
    @Override
    public abstract boolean isHuman();
}
