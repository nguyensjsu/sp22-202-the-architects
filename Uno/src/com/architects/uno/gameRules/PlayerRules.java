public class PlayerRules {

    private State currentTurnState;

    public PlayerRules(State turnState) {
        this.currentTurnState = turnState;
    }

    // Player relate rules
    public void reverse() {
        // For two players, reverse will give current player another chance.
        State current = currentTurnState.showTurn();

        if(current != null) {
            current.setState(current);
        }
    }

    public void skip() {
        // toggle turn
        State current = currentTurnState.showTurn();

        if(current != null) {
            current.setState(current);
        }
    }

    public void draw(int num) {
        // draw nums cards
        for (int i = 0; i < num; ) {
            ICard card = Deck.getInstance().drawCard();
            GameRules.getInstance().getCurrentPlayer().addCard(card);
        }
    }

    // Game play relate functions
    public boolean canPlayCard() {
        // need put the player args in
        try {
            if (GameRules.getInstance().getCurrentPlayer().getCards().size() > 0)
                return true;
        } catch (NullPointerException e) {
            return false;
        }

        return false;
    }
}