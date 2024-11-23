# UD1 - OOP + UML - Card Drop Tracking

For this project, I will be making a program to track card drops in the PlayStation 2 video game version of the card game Duel Masters.
For UD1, I have created a UML for the back-end data, the DMCard class, and a tester for that class.

## Basic Overview of classes

Classes include a Database that holds an array of RewardEvents and that can provide information based on the relationship of the array's contents,

a RewardEvent to keep the Reputation Points reward (currency), card rewards (itemDrops), variables that might contribute to the quality of rewards(rewardMods), and opponent (origin) of a single duel grouped together,

a DMBattleStats class which includes all the information shown to the player after a duel, which may affect drop rates,

a DMOppponent class to keep track of which opponents are linked to each event, and help see if certain opponents are more likely to drop certain cards,

and a DMCard class, which includes all of the information of a specific Duel Masters card, which is dropped as a reward.

    A DMCreature class will extend the DMCard class, to include information that only exist on creature cards, such as the creature's power and race


There are only a limited number of cards and opponents in the game, so instead of using a full constructor to create a new one whenever a card is dropped, etc., I've decided to create classes which hold all of the versions of DMCard and DMOpponent that actaully exist in-game. 
These classes will both extend a ValidLink abstract class. ValidLink has two abstract methods: createValidArray() should create an array of objects which represents ones which exist in-game, and save the array to an instance variable. linkObject() should call a method which takes input of relevant parameters, and seach the array to find an object which matches the parameter. It then either returns the matching object, or throws an exception if there is no match.
CardLink is the ValidLink class which creates and handles linking vaild cards, and OpponentLink creates and handles valid opponents.

DMCard and DMOpponent are not inner classes of CardLink and OpponentLink because I want other classes, such as Database, to still be able to easily access their information.

## Eventual Upgrades

Of course, for the UD1 version of the project, there is only one concrete class created so far, and I would like to finish up the rest of them. We will also be implementing the GUI as we learn it; I'm particularly interested in something that makes CardLink's linkCards function user-friendly.

I would like to be able to save Database information between sessions, as it will take a LOT of input before we can start drawing conclusions, and that's not feasible over the course of a single run of the program.

If I get the time, it would be cool to add a deckbuilder for the user. Then they could specify what cards they're missing, and if we can find any trends in the database, such as a certain opponent being more likely to drop one of the cards that they're missing, the program could convey that information to the user. This is a lower priority for now, but the deckbuilder idea could build naturally from the ways we might have CardLink search for a specific card.