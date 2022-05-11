import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public class Player extends Actor implements IPlayer {
    private static final int DECK_SIZE = 7;
    public static final int CARD_WIDTH = 72;
    public static final int CARD_HEIGHT = 96;
    public static final int CARD_GAP = 30;
    public static final int SCREEN_WIDTH = 1000;

    String playerName;
    List<Card> cards;
    IPlayerStrategy strategy;

    public Player(String playerName, IPlayerStrategy strategy) {
        this.playerName = playerName;
        this.cards = new ArrayList<>();
        this.strategy = strategy;
        drawCard(DECK_SIZE);
    }

    @Override
    public void drawCard(int amount) {
        for (int i = 0; i < amount; i++) {
            cards.add(Deck.getInstance().drawCard());
        }
        renderCards();
    }
    
    public List<Card> getCards() {
        return this.cards;
    }
    
    public void addCard(Card card) {
        for (int i=0; i<cards.size(); i++) {
            GameScreen.getInstance().removeObject(cards.get(i));
        }
        cards.add(card);
        renderCards();
    }
    
    public void removeCard(Card card) {
        for (int i=0; i<cards.size(); i++) {
            GameScreen.getInstance().removeObject(cards.get(i));
        }
        cards.remove(card);
        renderCards();
    }
    
    public void removeCard(int index) {
        for (int i=0; i<cards.size(); i++) {
            GameScreen.getInstance().removeObject(cards.get(i));
        }
        cards.remove(index);
        renderCards();
    }
    
    @Override
    public void renderCards() {
        int deckSize = CARD_WIDTH + ((cards.size()-1) * CARD_GAP);
        int x = (SCREEN_WIDTH - deckSize + CARD_WIDTH)/2;
        GreenfootImage image = new GreenfootImage(deckSize, CARD_HEIGHT);
        
        for (int i=0; i<cards.size(); i++) {
            if (GameScreen.showEnemyCards || isHuman()) {
                GameScreen.getInstance().addObject(cards.get(i), x + (i * CARD_GAP), 500);
                cards.get(i).setImage(cards.get(i).getImage());
            } else {
                image.drawImage(new GreenfootImage("Deck.png"), i * CARD_GAP, 0);
            } 
        }
        setImage(image);
    }
    
    @Override
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public void act() {
        GameScreen game = (GameScreen) getWorld();
        strategy.act(this, game);
        if (cards.size() == 0) {
        //    Text text = new Text(playerName + " Wins!", 60, Color.WHITE);
        //    game.addObject(text, game.getWidth() / 2, game.getHeight() / 2);
            Greenfoot.stop();
        }
        return;
    }
    
    @Override
    public boolean isHuman() {
        return strategy.isHuman();
    }
}
