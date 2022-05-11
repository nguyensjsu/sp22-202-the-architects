import greenfoot.*;
import java.util.ArrayList;
import java.util.List;

public class UserStrategy implements IPlayerStrategy {
    public static final int CARD_WIDTH = 72;
    public static final int CARD_HEIGHT = 96;
    public static final int CARD_GAP = 30;
    private GameScreen gsst = GameScreen.getInstance();
    
    @Override
    public List<Card> act(IPlayer player, List<Card> cards, GameScreen game) {
        //game = (GameScreen) getWorld();
         //game= game.getInsatance();
        IDeck deck = gsst.getDeck();
        
        if (gsst.getCurrentPlayer().equals(player) && gsst.canPlay()) {
            // Clicked own cards
            if (Greenfoot.mouseClicked(player)) {
                int cardIndex = cardSelected(cards);
                
                // System.out.println("Card Index Selected for "+ this.name +": " + cardIndex);
                
                if (cardIndex != -1) {
                    Card card = cards.get(cardIndex);
                    
                    if (gsst.canPlayCard(card)) {
                        cards.remove(cardIndex);
                        // renderCards();
                        gsst.replaceTopCard(card);
                    }
                }
                
            } else if (Greenfoot.mouseClicked(deck)) {
                Card card = deck.drawCard();
                
                if (gsst.canPlayCard(card)) {
                    game.toggleCanPlay();
                    playableDeckCard(gsst, cards, card);
                } else {
                    cards.add(card);
                }
                
                // renderCards();
                
                gsst.toggleTurn();
            }
        }
        return cards;
    }

    @Override
    public boolean isHuman() {
        return true;
    }

    public void playableDeckCard(GameScreen game, List<Card> cards, Card card) {
        int ypos = cards.get(0).getY() - 80;
        
        Button playCardButton = new Button(150, 45, "Play Card", 30, Color.BLACK, 20, 6);
        game.addObject(playCardButton, cards.get(0).getX() - 120, ypos);
        
        game.addObject(card, cards.get(0).getX(), ypos);
        
        Button keepCardButton = new Button(150, 45, "Keep Card", 30, Color.BLACK, 20, 6);
        game.addObject(keepCardButton, cards.get(0).getX() + 120, ypos);
        
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
    
    private int cardSelected(List<Card> cards) {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        
        while (mouseInfo == null) {
        }
        
        int mouseX = mouseInfo.getX();
        
        int topLeftX = cards.get(0).getX(); //getX() - getImage().getWidth() / 2;
        int bottomRightX = cards.get(cards.size()-1).getX(); //getX() + getImage().getWidth() / 2;
        
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
