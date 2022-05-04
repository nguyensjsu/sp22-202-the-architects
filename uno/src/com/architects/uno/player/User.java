package com.architects.uno.player;

import com.architects.uno.IDeck;

public class User extends Player {

    public User(String playerName, IDeck deck) {
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
