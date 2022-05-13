import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public class Player extends Actor implements IPlayer {
    String playerName;
    List<Card> cards;
    IPlayerStrategy strategy;

    public Player(String playerName, IPlayerStrategy strategy) {
        this.playerName = playerName;
        this.cards = new ArrayList<>();
        this.strategy = strategy;
        drawCard(Constants.DECK_SIZE);
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
        int deckSize = Constants.CARD_WIDTH + ((cards.size()-1) * Constants.CARD_GAP);
        int x = (Constants.SCREEN_WIDTH - deckSize + Constants.CARD_WIDTH)/2;
        GreenfootImage image = new GreenfootImage(deckSize, Constants.CARD_HEIGHT);
        
        for (int i=0; i<cards.size(); i++) {
            if (isHuman()) {
                GameScreen.getInstance().addObject(cards.get(i), x + (i * Constants.CARD_GAP), 500);
                cards.get(i).setImage(cards.get(i).getImage());
            } else {
                if(GameScreen.showEnemyCards)
                    image.drawImage(new GreenfootImage(cards.get(i).getImage()), i * Constants.CARD_GAP, 0);
                else
                    image.drawImage(new GreenfootImage("Deck.png"), i * Constants.CARD_GAP, 0);
            } 
        }
        setImage(image);
        GameScreen.getInstance().repaint();
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
            Greenfoot.setWorld(new GameOverScreen(playerName + " Wins!"));
        }
        return;
    }
    
    @Override
    public boolean isHuman() {
        return strategy.isHuman();
    }
}
