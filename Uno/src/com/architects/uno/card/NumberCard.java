package com.architects.uno.card;

import com.architects.uno.SpecialAction;
import greenfoot.Actor;
import greenfoot.Color;

import static com.architects.uno.SpecialAction.NULL_ACTION;

public class NumberCard extends Actor implements ICard
{
	private int value;
	private Color color;

	public NumberCard(int inputValue, String imageFilename, Color inputColor) 
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

	public Color getColor()
	{
		return color;
	}	

	public SpecialAction getAction()
	{
		return NULL_ACTION;
	}	
}