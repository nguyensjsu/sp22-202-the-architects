package com.architects.uno.card;

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