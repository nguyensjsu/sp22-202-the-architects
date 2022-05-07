import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public class Player extends Actor implements IPlayer {
    private static final int DECK_SIZE = 7;

    String playerName;
    List<ICard> cards;
    IPlayerRole role;

    public Player(String playerName, IDeck deck, IPlayerRole role) {
        this.playerName = playerName;
        this.cards = new ArrayList<>();
        this.role = role;
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
    public void act() {
        role.act();
    }
    
    @Override
    public boolean isHuman() {
        return role.isHuman();
    }
}
