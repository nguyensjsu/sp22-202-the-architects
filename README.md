# The Architects

## Team Members
1. Ashutosh Ojha
2. Devansh Modi
3. Hanyu Hu
4. Paramjot Singh
5. Waqas Kureshy

## Technologies
- Java
- Greenfoot

## Team Journals
1. [Ashutosh's Journal](/member-journals/journal_ashutosh.md)
2. [Devansh's Journal](/member-journals/journal_devansh.md)
3. [Hanyu's Journal](/member-journals/journal_hanyu.md)
4. [Paramjot's Journal](/member-journals/journal_paramjot.md)
5. [Waqas's Journal](/member-journals/journal_waqas.md)


# UNO
A two-player card game in which the objective is to be the first player to get rid of all the cards in their hand. 

Each player is dealt 7 cards and players take turn playing or drawing cards from the deck.

## About
- It's a User vs Computer game, where both players are dealt 7 cards initially. The remainder of the cards are placed as a deck by the side.
- The cards have a combination of two properties:
  - Color
  - Type
- A card will be any of the following four colors:
  - Red
  - Blue
  - Yellow
  - Green
- Along with color, a card can be either of the two types:
    - Number Card
    - Special Card
- The Number Cards are simple cards with a value from 0-9.
- The Special Cards are cards without a value, but each has a special action attached to it. There are 3 types of special cards:
  - Skip: When played, the next player's turn is skipped.
  - Reverse: When played, the direction of play is reversed.
  - Draw 2: When played, the next player must draw two cards and loses his/her turn to play.
- The first round starts with the Computer playing a card at random.
- For each successive turn, the player has to play a card which should atleast match either the number or the color or the special action.
- In a case where a player has no playable card, he/she is bound to draw a card from the deck.
- If the card drawn from deck is playable, the card is played or else is added to the player's cards.
- In case of a special card been played, the permissible action of the next player is determined by the type of the special card.
- The objective of the game is to be the first player to get rid of all the cards in one's hand.

## Steps to Launch
- Install [Greenfoot](https://www.greenfoot.org/download)
- Clone or download this repository
- Launch `project.greenfoot` inside src/com/architects/uno directory

## Screenshots

### Main Menu Screen aka Start Screen
<br>
<p align="center">
    <image src="images/main_menu_screen.png">
</p>
<br>

### Game Screen
<br>
<p align="center">
    <image src="images/game_screen.png">
</p>
<br>

### Game Over Screen
<br>
<p align="center">
    <image src="images/game_over_screen.png">
</p>
<br>

### Burndown Chart
### [![Burndown Chart](images/burndown_chart.png)](https://docs.google.com/spreadsheets/d/1Z5zIJknovuiLPphlMqS3jdI8GBqY_gp5KiWFqB5gwmQ/edit?usp=sharing)
  
## Key Design Features

1.  Factory Pattern
  
  
  The factory pattern is utilized in the course of the creation of Card objects, as it significantly simplifies the process of Card creation. The diagram is presented here.
  
As the diagram indicates, this Factory pattern follows the basic plan set out by the Gang of Four.
