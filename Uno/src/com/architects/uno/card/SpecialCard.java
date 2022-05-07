package com.architects.uno.card;

import com.architects.uno.SpecialAction;
import greenfoot.Color;

public class SpecialCard extends Card
{
	private SpecialAction action;
	private Color color;

	public SpecialCard(SpecialAction inputAction, String imageFilename, Color inputColor) 
	{
		action = inputAction;
		color = inputColor;
		//setImage(imageFilename); TODO: implement this method
	}

	public boolean isSpecial()
	{
		return true;
	}

	public int getNumber() 
	{
		// Returns invalid number 
		return -1;
	}

	public Color getColor()
	{
		return color;
	}

	public SpecialAction getAction()
	{
		return action;
	}
}