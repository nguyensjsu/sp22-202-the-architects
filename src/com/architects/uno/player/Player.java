package com.architects.uno.player;

import com.architects.uno.IDeck;
import com.architects.uno.card.ICard;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public class Player extends Actor implements IPlayer {
    private static final int DECK_SIZE = 7;
    public static final int CARD_WIDTH = 50;
    public static final int CARD_HEIGHT = 72;
    public static final int CARD_GAP = 10;

    String playerName;
    List<ICard> cards;
    IPlayerStrategy strategy;

    public Player(String playerName, IPlayerRole role) {
        this.playerName = playerName;
        this.cards = new ArrayList<>();
        this.role = role;
        drawCard(deck, DECK_SIZE);
        renderCards();
    }

    @Override
    public void addCard(IDeck deck, int amount) {
        cards.add(deck.drawCard());
    }

    public List<ICard> getCards() {
        return cards;
    }
    
    @Override
    public void renderCards() {
        GreenfootImage image = new GreenfootImage(CARD_GAP * this.cards.size() + CARD_WIDTH, CARD_HEIGHT);
        int x = CARD_WIDTH / 2;
        for (Card card: this.cards) {
            if (GameScreen.showEnemyCards || isHuman()) {
                image.drawImage(card.getImage(), x, 0);
            } else {
                image.drawImage(new GreenfootImage("Deck.png"), x, 0);
            } 
            x += CARD_GAP;
        }
        setImage(image);
    }
    
    @Override
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public void act() {
        GameScreen game = (GameScreen) getWorld();

        cards = strategy.act(this, cards, game);
        renderCards();

        if (cards.size() == 0) {
            Text text = new Text(playerName + " Wins!", 60, Color.WHITE);
            game.addObject(text, game.getWidth() / 2, game.getHeight() / 2);
            Greenfoot.stop();
        }
    }
    
    @Override
    public boolean isHuman() {
        return strategy.isHuman();
    }
}
