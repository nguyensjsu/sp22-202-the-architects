# Class, Responsiblity, Collaborators

## Card
Reponsibilities: 
- Knows Color
- Knows Number
- Knows if Special Card, and if so, which type

Collaborators: 
- Deck

## Player
Reponsibilities: 
- Knows Score
- Knows which Deck it owns
- Knows if it is playing

Collaborators: 
- Deck
- Game Controller 

## Deck
Reponsibilities: 
- Knows which cards it owns
- Knows the order of the cards

Collaborators: 
- Card

## Game Controller
Reponsibilities: 
- Knows scores of both players
- Handles the transfer of cards from deck to deck
- Handles the switching of players on each turn

Collaborators: 
- Deck
- Player
