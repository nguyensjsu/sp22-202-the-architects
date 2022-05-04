package com.architects.uno.player;

import com.architects.uno.IDeck;

public class Computer extends Player {

    public Computer(String playerName, IDeck deck) {
        super(playerName, deck);
    }
    
    @Override
    public void act() {
        // perfrom action each iteration
    }
    
    @Override
    public boolean isHuman() {
        return true;
    }
    
}
