package com.architects.uno.player;

import com.architects.uno.IDeck;

public class User implements IPlayer {
    
    @Override
    public void drawCard(IDeck deck, int amount) {
        
    }
    
    @Override
    public void renderCards() {
        
    }
    
    @Override
    public String getPlayerName() {
        return "";
    }
    
    @Override
    public boolean isHuman() {
        return true;
    }
}
