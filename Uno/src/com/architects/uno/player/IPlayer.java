package com.architects.uno.player;

import com.architects.uno.IDeck;

public interface IPlayer {
    void drawCard(IDeck deck, int amount);
    void renderCards();
    String getPlayerName();
    boolean isHuman();
}