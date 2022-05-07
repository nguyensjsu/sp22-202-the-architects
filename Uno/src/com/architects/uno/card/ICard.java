package com.architects.uno.card;

import com.architects.uno.SpecialAction;
import greenfoot.Color;

public interface ICard {
	public boolean isSpecial();
	public int getNumber();
	public Color getColor();
	public SpecialAction getAction();
}