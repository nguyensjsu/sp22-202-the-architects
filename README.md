# The Architects

### Team Members
- Paramjot Singh
- Ashutosh Ojha
- Waqas Kureshy
- Devansh Modi
- Hanyu Hu

### Technologies
- Abstract Window Toolkit
- Java Swing
- Greenfoot
- Sl4j

## Team Journal

[Burndown Chart/Sheet](https://docs.google.com/spreadsheets/d/1Z5zIJknovuiLPphlMqS3jdI8GBqY_gp5KiWFqB5gwmQ/edit?usp=sharing)

### Week 1

- Ashutosh Ojha
   - What I did: 
      - Setup dev environment: install Greenfoot.
      - Get familiar with Greenfoot APIs.
   - What I plan to do next: 
      - Get aqcuainted with the objective task: Build UNO game
      - Identify the objects and various interactions required
      - Design UML class diagrams.
   - Blockers: 
      - N/A
   - XP Value:
      - Simplicity 
         - Facilitated the team to begin on a simple note and not get lost in the intricacies of the project. 
         - There was significant confusion in the team in regards to how should one approach the task. Dealt with the confusion by suggesting team to start small. 
         - Instead of diving deep into project designing, suggested to focus on getting familiar with Greenfoot first by building small starter projects.

- Devansh Modi
   - What I did: Setup local environment for Greenfoot, Swing, and game creation. Wrote boilerplate code.
   - What I plan to do next: Plan for design patterns needed for the UNO game.
   - Blockers: N/A

- Hanyu Hu
   - What I did: 
     - Setup environment for Greenfoot.
     - Getting familiar with Greenfoor development, and try out with some minor projects.
     - Checked the tutorial videos.
   - What I plan to do next: 
     - Brainstorm with for the design patter that could best apply to UNO game
     - Team meeting to finalize the UNO develop circle
     - Start working on the structure of the game.
   - Blockers: N/A

- Paramjot Singh
   - What I did: Broke down Uno into objects
   - What I plan to do today: Setup Greenfoot, Plan Design Patterns
   - Blockers: N/A
   - XP Value: Communication. We did struggle with communication earlier in the week, but by using Google Meetings and scheduling meetings in advance we were able to get more responsible with communication. 
    
- Waqas Kureshy
   - What I did: Explored Game development with Greenfoot
   - What I plan to do today: Work on Game Interface, Figure out Design Patterns applicable to the game.
   - Blockers: N/A
      
### Week 2

- Ashutosh Ojha
   - What I did: 
      - Gained a high level understanding of the task: Build UNO game.
      - Identified the objects and the relationships.
      - Designed the class diagram of Card component of the game.
      - Laid down the base interfaces, constants and enums for the Card component.
   - What I plan to do next: 
      - Design UML class diagrams.
      - Map State pattern with the game controller logic.
   - Blockers: 
      - N/A
   - XP Value:
      - Simplicity 
         - After getting familiar with the dev environment and tools, focused on decoding the high-level structure of the project. 
         - Key objective was to brainstorm and come up with individual classes and their relationships. 
         - A couple developers would be working on designing UML class diagrams, while others would be designing images to be used for UI, starting with the various types of cards.

- Devansh Modi
   - What I did: 
      - Worked on initial tests for App Controller and Cards classes.
      - Worked on design pattern for Deck object.
   - What I plan to do next: 
      - Write more unit tests to help in development.
      - Apply identified design patterns.
   - Blockers: 
      - N/A
   - XP Value: Feedback - testing and acceptance.

- Hanyu HU
   - What I did: 
      - Get familiar with UNO rules and practice with team
      - BrainStorm the design patterns gonna apply with teams (State Machine Pattern / Observer patter)
   - What I plan to do next: 
      - After the CRC cards are created, start coding the initial code an fram works
   - Blockers: 
      - N/A
   - XP Value:
      - Communication, weekly scrum meeting help me to communicate with team regards to the Design or blokers
      - Feedback, given feedback for the current state we are, and for the design pattern that planning to use

- Paramjot Singh
   - What I did: Setup Greenfoot, Plan Design Patterns
   - What I plan to do today: Write code for the Number Cards and larger Card interfaces
   - Blockers: N/A
   - XP Value: Communication. A combination of IRL meeting and scheduled meetings on Google Meetings ensured we performed well in this value.

- Waqas Kureshy
   - What I did: 
      - Setup my Greenfoot environment.
      - Get familiar with Greenfoot APIs.
      - Practiced on a couple of games implemented on Greenfoot.
      - Worked on UI elements of the game.
   - What I plan to do next: 
      - Finish up remaining UI wireframes.
      - Start on building the Gaming application on Greenfoot. 
      - Aid in Designing UML class diagrams.
   - Blockers: 
      - N/A
   - XP Value:
      - Simplicity 
         - Contributed in team meetings to help decide the initial model of the gaming application.
         - Worked up on simplifying the design implementation of the game with the team members.
      - Feedback
         - Recieved critical feedback from team to rework the visual elements of the gaming application.

### Week 3

- Ashutosh Ojha
   - What I did: 
      - Designed the class diagram of the Player component of the game.
      - Laid down the base interfaces, constants and enums for the Player component.
      - Updated class structure of players to implement a base class for implementing the common features of both types of players.
      - Updated the class diagram of players to include the new base Player class in the astah file.
   - What I plan to do next: 
      - Work on the concrete implementation for Human player and a Computer player.
      - Define the common and varying behaviors of both types of players.
      - Define the logic of Computer player.
   - Blockers: 
      - Dependency on CardDeck class for Player interface.
      - CardDeck is to be created by a fellow developer and hasn't been implemented yet.
      - Handled it by defining a skeleton interface for CardDeck.
   - XP Value:
      - Simplicity 
         - Focused on keeping the interface definitions for Player components as simple as possible.
         - Discussed, explored the designs & definitions of team members' components to ensure they are simple and in accordance with SOLID design principles.

- Devansh Modi
   - What I did: 
      - Worked on classes and design for Player Rules.
   - What I plan to do next: 
      - Complete the implementation for Player rules
      - Add unit tests
   - Blockers: 
      - N/A
   - XP Value:
      - Feedback: Testing code is first class citizen

- Hanyu Hu
   - What I did: 
      - Class design for game rules
      - Made the initial code for game rules
      - Chose Singleton design pattern for game rules
   - What I plan to do next: 
      - Implement the details for the game rules
      - Corporate the current gamerules class with game screen
   - Blockers: 
      - Waiting on Card class to get completed to wrap up UnoScreen. 
      - Waiting on the Player class and bring it into the scoop.
   - XP Value:
      - Simplicity 
      - Communication
      - Provide feedbacks

- Paramjot Singh
   - What I did: 
      - Class design for Cards
      - Made the initial code for Card Factory Pattern
   - What I plan to do next: 
      - Implement the Card Factory Pattern fully
      - Implement the Card class fully
      - Sync with game screens
   - Blockers: 
      - N/A
   - XP Value:
      - Communication: We struggled with finding times to meet which worked for all members, and our online communication needed improvement.

- Waqas Kureshy
   - What I did: 
      - Made Cards for the Game
      - Made Button class for navigation on screens
      - Made Main menu screen for the game.
      - Made UnoScreen (Main Game Screen ) by implementing the Singelton pattern.
   - What I plan to do next: 
      - Work on UnoScreen with static elements to finish the design.
      - Work on Direction functionality using state pattern.
   - Blockers: 
      - Waiting on Card class to get completed to wrap up UnoScreen. 
   - XP Value:
      - Simplicity 
         - Contributed in team meetings to help define and dive deeper into the project.
         - Worked up on simplifying the design implementation of the game and identifying key goals with the team members.

### Week 4

- Ashutosh Ojha
  - What I did:
    - Apply design pattern thinking in the current Players implementation.
    - Identify the scope of strategy pattern in Players implementation.
    - Update the class diagram of Players to implement Strategy pattern.
    - Implement strategy pattern in the Players implementation.
    - Collaborated with the team to integrate all the individual components.
  - What I plan to do next:
    - Create a Constants class to include all the constant values used.
    - Refactor the codebase to use the constants defined in the Constants class.
  - Blockers:
    - Waiting on minor bugfixes before starting the refactoring
  - XP Value:
    - Simplicity
      - Focused on improving and further simplifying the implementation of the Players implementation.
      - Collaborate with the team on integrating all the individual components of the game with a focus on minimizing the scope of modifications done as needed.
      - Aided the team members in the class design for their respective components.
  
- Devansh Modi
   - What I did: 
      - N/A
   - What I plan to do next: 
      - N/A
   - Blockers: 
      - N/A
   - XP Value:
      - N/A

- Hanyu Hu
   - What I did: 
      - Implemented the Game Screen and Game Rules classes
      - Debugging the whole structure with outher classes
      - Debugging the design pattern issue for the Game Screen and Game Rules
      - Refactor the Game Rule class
      - Collaborate with the team to make the whole thing work
   - What I plan to do next: 
      - Debugging the code
   - Blockers: 
      - The current structure has a lot bugs, happends in most units
   - XP Value:
      - Communication: Team collaborative was good, everyone is very supportive and hard working
      - Simplicity: The brainstorm ideas need way much than we can do, we are just simplify the requirements and implement

- Paramjot Singh
   - What I did: 
      - Implemented Card Object
      - Implemented SpecialCard, NumberCard
      - Implemented Card Factory Pattern
      - Implemented Deck object
   - What I plan to do next: 
      - N/A
   - Blockers: 
      - N/A
   - XP Value:
      - Communication: We were able to effectively communicate via online and text messaging, but struggled with arranging in-person meetings, and online meeting times.

- Waqas Kureshy
   - What I did: 
      - Implemented the State Design Pattern for direction.
      - Implemented ComputerTurn state
      - Implemented PlayersTurn State
      - Implemented State Interface
      - Implemented TurnState machine
      - Added the Turn UI element
   - What I plan to do next: 
      - Merge Main code with personal code and reduce conflicts.
   - Blockers: 
      - N/A
   - XP Value:
      - Communication: Effectively communicated with team members to mitigate errros, clear misunderstandings.
      - Simplicity: Aided in simpligying the overall structure of the game.
