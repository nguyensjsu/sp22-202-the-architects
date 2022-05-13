import greenfoot.*;
import java.util.ArrayList;
import java.util.List;

public class UserStrategy implements IPlayerStrategy {
    
    @Override
    public void act(IPlayer player, GameScreen game) {
        IDeck deck = GameScreen.getInstance().getDeck();
        if (GameScreen.getInstance().getCurrentPlayer().equals(player) && GameScreen.getInstance().canPlay()) {
            // Clicked own cards
            if (Greenfoot.mouseClicked(player)) {
                int cardIndex = cardSelected(GameScreen.getInstance().getCurrentPlayer().getCards());
                if (cardIndex != -1) {
                    Card card = GameScreen.getInstance().getCurrentPlayer().getCards().get(cardIndex);
                    checkAndPlayCard(card);
                }
                
            } else if (Greenfoot.mouseClicked(deck)) {
                Card card = deck.drawCard();
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
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();

        while (mouseInfo == null) {
        }
        
        int mouseX = mouseInfo.getX();
        
        int topLeftX = cards.get(0).getX(); //getX() - getImage().getWidth() / 2;
        int bottomRightX = cards.get(cards.size()-1).getX(); //getX() + getImage().getWidth() / 2;
        
        int index = 0;
        for (int i = topLeftX - Constants.CARD_WIDTH / 2; i < bottomRightX; i += Constants.CARD_GAP) {
            if (mouseX >= i && mouseX <= i + Constants.CARD_GAP - 10) {
                return index;
            }
            index++;
        }
        
        return -1;
    }

}
