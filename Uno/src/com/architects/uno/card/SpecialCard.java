package com.architects.uno.card;

public class SpecialCard extends Card
{
	private SpecialAction action;
	private Color color;

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