import greenfoot.*;
import java.util.ArrayList;
import java.util.List;

public class ComputerStrategy implements IPlayerStrategy {

    @Override
    public List<Card> act(IPlayer player, List<Card> cards, GameScreen game) {
        
        try {
        GameScreen.getInstance().wait(1000); } 
        catch(Exception e) {

        }

        if (game.getCurrentPlayer().equals(player) && game.canPlay()) {
            List<Card> playableCards = new ArrayList<>();
            for (Card card : cards) {
                if (game.canPlayCard(card)) {
                    playableCards.add(card);
                }
            }
            
            if (playableCards.size() == 0) {
                Card card  = game.getDeck().drawCard();
                cards.add(card);
                // renderCards();
                
                if (game.canPlayCard(card)) {
                    cards.remove(card);
                    // renderCards();
                    game.replaceTopCard(card);
                }
            } else {
                Card playing = playableCards.get(Greenfoot.getRandomNumber(playableCards.size()));
                cards.remove(playing);
                // renderCards();
                game.replaceTopCard(playing);
            }
        }
        return cards;
    }

    @Override
    public boolean isHuman() {
        return false;
    }

}
