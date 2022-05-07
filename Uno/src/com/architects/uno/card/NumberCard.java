package com.architects.uno.card;

import com.architects.uno.SpecialAction;
import greenfoot.Actor;
import greenfoot.Color;

import static com.architects.uno.SpecialAction.NULL_ACTION;

public class NumberCard extends Actor implements ICard
{
	private int value;
	private CardColor color;

	public NumberCard(int inputValue, String imageFilename, CardColor inputColor) 
	{
		value = inputValue;
		color = inputColor;
		setImage(imageFilename);
	}

	public boolean isSpecial()
	{
		return false;
	}

	public int getNumber() 
	{
		return value;
	}

	public CardColor getColor() 
	{
		return color;
	}	

	public SpecialAction getAction()
	{
		return NULL_ACTION;
	}	
}