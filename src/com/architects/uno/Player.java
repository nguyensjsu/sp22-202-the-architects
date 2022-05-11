import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public class Player extends Actor implements IPlayer {
    private static final int DECK_SIZE = 7;
    public static final int CARD_WIDTH = 72;
    public static final int CARD_HEIGHT = 96;
    public static final int CARD_GAP = 30;

    String playerName;
    List<Card> cards;
    IPlayerStrategy strategy;

    public Player(String playerName, IPlayerStrategy strategy) {
        this.playerName = playerName;
        this.cards = new ArrayList<>();
        this.strategy = strategy;
        drawCard(DECK_SIZE);
        renderCards();
    }

    @Override
    public void drawCard(int amount) {
        for (int i = 0; i < amount; i++) {
            cards.add(Deck.getInstance().drawCard());
        }
        renderCards();
    }
    
    @Override
    public void renderCards() {
        GreenfootImage image = new GreenfootImage(CARD_GAP * this.cards.size() + 80, 96);
        int x = CARD_WIDTH / 2;
        for (Card card: this.cards) {
            if (GameScreen.showEnemyCards || isHuman()) {
                //image.drawImage(card.getImage(), x, 0);
                GameScreen.getInstance().addObject(card, 475 + x, 500);
                card.setImage(card.getImage());
            } else {
                image.drawImage(new GreenfootImage("Deck.png"), x, 0);
            } 
            x += CARD_GAP;
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

        cards = strategy.act(this, cards, game);
        renderCards();

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
