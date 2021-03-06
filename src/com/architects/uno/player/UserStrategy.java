import greenfoot.*;
import java.util.ArrayList;
import java.util.List;

public class UserStrategy implements IPlayerStrategy {
    public static final int CARD_WIDTH = 50;
    public static final int CARD_HEIGHT = 72;
    public static final int CARD_GAP = 10;
    
    @Override
    public List<ICard> act(IPlayer player, List<ICard> cards, GameScreen game) {
        IDeck deck = game.getDeck();
        
        if (game.getCurrentPlayer().equals(player) && game.canPlay()) {
            // Clicked own cards
            if (Greenfoot.mouseClicked(player)) {
                int cardIndex = cardSelected();
                
                // System.out.println("Card Index Selected for "+ this.name +": " + cardIndex);
                
                if (cardIndex != -1) {
                    ICard card = cards.get(cardIndex);
                    
                    if (game.canPlayCard(card)) {
                        cards.remove(cardIndex);
                        // renderCards();
                        game.replaceTopCard(card);
                    }
                }
                
            } else if (Greenfoot.mouseClicked(deck)) {
                ICard card = deck.drawCard();
                
                if (game.canPlayCard(card)) {
                    game.toggleCanPlay();
                    playableDeckCard(game, card);
                } else {
                    cards.add(card);
                }
                
                // renderCards();
                
                game.toggleTurn();
            }
        }
        return cards;
    }

    @Override
    public boolean isHuman() {
        return true;
    }

    public void playableDeckCard(GameScreen game, ICard card) {
        int ypos = getY() - 80;
        
        Button playCardButton = new Button(150, 45, "Play Card", 30, Color.BLACK, 20, 6);
        game.addObject(playCardButton, getX() - 120, ypos);
        
        game.addObject(card, getX(), ypos);
        
        Button keepCardButton = new Button(150, 45, "Keep Card", 30, Color.BLACK, 20, 6);
        game.addObject(keepCardButton, getX() + 120, ypos);
        
        while (true) {
            if (Greenfoot.mouseClicked(playCardButton)) {
                game.replaceTopCard(card);
                game.toggleCanPlay();
                break;
            }
            
            if (Greenfoot.mouseClicked(keepCardButton)) {
                cards.add(card);
                game.toggleCanPlay();
                break;
            }
        }
    }
    
    private int cardSelected() {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        
        while (mouseInfo == null) {
        }
        
        int mouseX = mouseInfo.getX();
        int topLeftX = getX() - getImage().getWidth() / 2;
        int bottomRightX = getX() + getImage().getWidth() / 2;
        
        int index = 0;
        for (int i = topLeftX + CARD_WIDTH / 2; i < bottomRightX; i += CARD_GAP) {
            if (mouseX >= i && mouseX <= i + CARD_GAP - 10) {
                return index;
            }
            index++;
        }
        
        return -1;
    }

}
