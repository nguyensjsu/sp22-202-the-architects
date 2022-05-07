import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public class Player extends Actor implements IPlayer {
    private static final int DECK_SIZE = 7;
    public static final int CARD_WIDTH = 50;
    public static final int CARD_HEIGHT = 72;

    String playerName;
    List<ICard> cards;
    IPlayerStrategy strategy;

    public Player(String playerName, IDeck deck, IPlayerRole role) {
        this.playerName = playerName;
        this.cards = new ArrayList<>();
        this.role = role;
        drawCard(deck, DECK_SIZE);
        renderCards();
    }

    @Override
    public void drawCard(IDeck deck, int amount) {
        for (int i = 0; i < amount; i++) {
            cards.add(deck.drawCard());
        }
        renderCards();
    }
    
    @Override
    public void renderCards() {
        GreenfootImage image = new GreenfootImage(this.cardGap * this.cards.size() + CARD_WIDTH, CARD_HEIGHT);
        int x = CARD_WIDTH / 2;
        for (Card card: this.cards) {
            if (GameScreen.showEnemyCards || isHuman()) {
                image.drawImage(card.getImage(), x, 0);
            } else {
                image.drawImage(new GreenfootImage("Deck.png"), x, 0);
            } 
            x += this.cardGap;
        }
        setImage(image);
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
