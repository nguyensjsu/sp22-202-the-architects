package com.architects.uno.card;

import com.architects.uno.SpecialAction;
import greenfoot.Actor;
import greenfoot.Color;

public class Card extends Actor implements ICard
{

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public int getNumber() {
        return 0;
    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public SpecialAction getAction() {
        return null;
    }
}