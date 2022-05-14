import greenfoot.*;
import java.util.ArrayList;
import java.util.List;

public class ComputerStrategy implements IPlayerStrategy 
{

    @Override
    public void play(IPlayer player) {
        if (GameScreen.getInstance().getCurrentPlayer().equals(player) 
            && GameScreen.getInstance().canPlay()) {
            // Catch other players who did not say Uno
            for(Player p: GameRules.getInstance().getPlayers()) {
                if (p.isHuman() && p.getCards().size() == 1 && !p.saidUno) {
                    p.drawCard(2); // penalize them with +2 cards.
                }
            }
            
            List<Card> playableCards = new ArrayList<>();
            for (Card card : GameScreen.getInstance().getCurrentPlayer().getCards()) {
                if (GameScreen.getInstance().canPlayCard(card)) {
                    playableCards.add(card);
                }
            }
            if (playableCards.size() == 0) {
                Card card  = Deck.getInstance().drawCard();
                if(card == null) {
                    // empty deck => game draw
                    GameScreen.getInstance().gameIsDraw();
                } else if (GameScreen.getInstance().canPlayCard(card)) {
                    GameScreen.getInstance().replaceTopCard(card);
                } else {
                    GameScreen.getInstance().getCurrentPlayer().addCard(card);
                    GameScreen.getInstance().toggleTurn();
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
