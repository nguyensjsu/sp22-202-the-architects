package com.architects.uno.gameRules;

public interface IPlayerRules {
    void reverse();

    void skip();

    void draw(int num);

    boolean canPlayCard();
}
