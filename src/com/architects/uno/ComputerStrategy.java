import greenfoot.*;
import java.util.ArrayList;
import java.util.List;

public class ComputerStrategy implements IPlayerStrategy 
{

    @Override
    public void act(IPlayer player, GameScreen game) {
        if (game.getCurrentPlayer().equals(player) && game.canPlay()) {
            List<Card> playableCards = new ArrayList<>();
            for (Card card : GameScreen.getInstance().getCurrentPlayer().getCards()) {
                if (game.canPlayCard(card)) {
                    playableCards.add(card);
                }
            }
            if (playableCards.size() == 0) {
                Card card  = game.getDeck().drawCard();
                GameScreen.getInstance().getCurrentPlayer().addCard(card);
                if (game.canPlayCard(card)) {
                    GameScreen.getInstance().getCurrentPlayer().removeCard(card);
                    game.replaceTopCard(card);
                }
            } else {
                Card playing = playableCards.get(Greenfoot.getRandomNumber(playableCards.size()));
                if(!GameScreen.getInstance().isFirstTurn()) {
                    Greenfoot.delay(100);
                } else {
                    GameScreen.getInstance().firstTurnDone();
                }
                GameScreen.getInstance().getCurrentPlayer().removeCard(playing);
                game.replaceTopCard(playing);
            }
        }
    }

    @Override
    public boolean isHuman() {
        return false;
    }

}
