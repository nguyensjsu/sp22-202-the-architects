import greenfoot.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Strategy class for a player role: User.
 * 
 * @author Ashutosh Ojha (leoAshu) 
 */
public class UserStrategy implements IPlayerStrategy {
    
    @Override
    public void play(IPlayer player) {
        if (GameScreen.getInstance().getCurrentPlayer().equals(player) && GameScreen.getInstance().canPlay()) {
            // Clicked own cards
            if (Greenfoot.mouseClicked(player)) {
                int cardIndex = cardSelected(GameScreen.getInstance().getCurrentPlayer().getCards());
                if (cardIndex != -1) {
                    Card card = GameScreen.getInstance().getCurrentPlayer().getCards().get(cardIndex);
                    checkAndPlayCard(card);
                }
                
            } else if (Greenfoot.mouseClicked(Deck.getInstance())) {
                Card card = Deck.getInstance().drawCard();
                if(card == null) {
                    // empty deck => game draw
                    GameScreen.getInstance().gameIsDraw();
                } else if (GameScreen.getInstance().canPlayCard(card)) {
                    GameScreen.getInstance().replaceTopCard(card);
                } else {
                    GameScreen.getInstance().getCurrentPlayer().addCard(card);
                    GameScreen.getInstance().toggleTurn();
                }
            }
        }
    }
    
    @Override
    public void checkAndPlayCard(Card card) {
        if (GameScreen.getInstance().canPlayCard(card)
            && GameScreen.getInstance().getCurrentPlayer().getCards().contains(card)) {
            GameScreen.getInstance().getCurrentPlayer().removeCard(card);
            GameScreen.getInstance().replaceTopCard(card);
        }
    }

    @Override
    public boolean isHuman() {
        return true;
    }
    
    private int cardSelected(List<Card> cards) {
        int deckSize = Constants.CARD_WIDTH + ((cards.size()-1) * Constants.CARD_GAP);
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();

        while (mouseInfo == null) {
        }
        
        int mouseX = mouseInfo.getX();
        int playerX = GameScreen.getInstance().getCurrentPlayer().getX();
        
        int topLeftX = playerX - deckSize/2;
        int bottomRightX = playerX + deckSize/2 - Constants.CARD_WIDTH;
        
        int index = 0;
        
        for(int i = topLeftX; i <= bottomRightX; i += Constants.CARD_GAP) {
            if(i == bottomRightX) {
                if(mouseX >= i && mouseX < (i + Constants.CARD_WIDTH))
                    return index;
            } else {
                if(mouseX >= i && mouseX < (i + Constants.CARD_GAP))
                    return index;
                index++;
            }
        }
        return -1;
    }

}
