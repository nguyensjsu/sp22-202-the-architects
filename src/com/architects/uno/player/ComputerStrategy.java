import greenfoot.*;
import java.util.ArrayList;
import java.util.List;

public class ComputerStrategy implements IPlayerStrategy {

    @Override
    public List<ICard> act(IPlayer player, List<ICard> cards, GameScreen game) {
        GameScreen.wait(2000);

        if (game.getCurrentPlayer().equals(player) && game.canPlay()) {
            List<ICard> playableCards = new ArrayList<>();
            for (ICard card : cards) {
                if (game.canPlayCard(card)) {
                    playableCards.add(card);
                }
            }
            
            if (playableCards.size() == 0) {
                ICard card  = game.getDeck().drawCard();
                cards.add(card);
                // renderCards();
                
                if (game.canPlayCard(card)) {
                    cards.remove(card);
                    // renderCards();
                    game.replaceTopCard(card);
                }
            } else {
                ICard playing = playableCards.get(Greenfoot.getRandomNumber(playableCards.size()));
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
