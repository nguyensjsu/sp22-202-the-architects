package com.architects.uno.card;

import com.architects.uno.SpecialAction;
import greenfoot.Color;

import static com.architects.uno.SpecialAction.NULL_ACTION;

public class CardFactory {

	public CardFactory()
	{}

	public ICard createCard(String cardType, String imageFile, Color color, int value)
	{
		return this.createCard(cardType, imageFile, color, value, NULL_ACTION);
	}	

	public ICard createCard(String cardType, String imageFile, Color color, SpecialAction specialAction)
	{
		return this.createCard(cardType, imageFile, color, -1, specialAction);
	}		

	public ICard createCard(String cardType, String imageFile, Color color, int value, SpecialAction specialAction)
	{
		if (cardType == "NUMBER")
		{
			return new NumberCard(value, imageFile, color);
		}
		else if (cardType == "SPECIAL")
		{
			return new SpecialCard(specialAction, imageFile, color);
		}
		return null;
	}		
}