package com.architects.uno;

public interface ICard {
	public boolean isSpecial();
	public int getNumber();
	public Color getColor();
	public SAction getAction();
}