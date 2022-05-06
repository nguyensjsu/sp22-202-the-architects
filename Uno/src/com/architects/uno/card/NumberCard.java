package com.architects.uno.card;

public class NumberCard extends Card
{
	private int value;
	private Color color;

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