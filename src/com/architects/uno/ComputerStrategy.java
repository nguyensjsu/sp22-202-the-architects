import greenfoot.*;
import java.util.ArrayList;
import java.util.List;

public class ComputerStrategy implements IPlayerStrategy 
{

    @Override
    public void play(IPlayer player) {
        if (GameScreen.getInstance().getCurrentPlayer().equals(player) 
            && GameScreen.getInstance().canPlay()) {
            List<Card> playableCards = new ArrayList<>();
            for (Card card : GameScreen.getInstance().getCurrentPlayer().getCards()) {
                if (GameScreen.getInstance().canPlayCard(card)) {
                    playableCards.add(card);
                }
            }
            if (playableCards.size() == 0) {
                Card card  = Deck.getInstance().drawCard();
                GameScreen.getInstance().getCurrentPlayer().addCard(card);
                if (GameScreen.getInstance().canPlayCard(card)) {
                    GameScreen.getInstance().getCurrentPlayer().removeCard(card);
                    GameScreen.getInstance().replaceTopCard(card);
                }
            } else {
                Card playing = playableCards.get(Greenfoot.getRandomNumber(playableCards.size()));
                if(!GameScreen.getInstance().isFirstTurn()) {
                    Greenfoot.delay(100);
                } else {
                    GameScreen.getInstance().firstTurnDone();
                }
                GameScreen.getInstance().getCurrentPlayer().removeCard(playing);
                GameScreen.getInstance().replaceTopCard(playing);
            }
        }
    }
    
    @Override
    public void checkAndPlayCard(Card card) {
        // do nothing
    }

    @Override
    public boolean isHuman() {
        return false;
    }

}
