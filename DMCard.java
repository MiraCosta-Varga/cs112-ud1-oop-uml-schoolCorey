/**
 * Represents a card available in the video game version of Duel Masters. Should only be created/modified by CardLink and tester classes,
 * but can be accessed by other classes to read its data.  
 */
public class DMCard {
    /*CONSTANTS*/
    public static final int RARITY_NONE = -1;
    public static final int RARITY_COMMON = 0;
    public static final int RARITY_UNCOMMON = 1;
    public static final int RARITY_RARE = 2;
    public static final int RARITY_VERY_RARE = 3;
    public static final int RARITY_SUPER_RARE = 4;

    public static final String[] CIVILIZATIONS = { "Darkness", "Fire", "Light", "Nature", "Water" };

    // Default constats, defaults to the information for Belbetphlo, Wailing Shadow; the first card in the game's initial search ordering.
    public static final String DEFAULT_NAME = "Belbetphlo, Wailing Shadow";
    public static final String[] DEFAULT_ALIASES = { "Belpetphlo, Wailing Shadow", "Belbetphlo" };
    public static final String DEFAULT_CIVILIZATION = "Darkness";
    public static final String DEFAULT_CARD_TYPE = "creature";
    public static final String DEFAULT_TEXBOX = "Slayer";
    public static final int DEFAULT_RARITY = RARITY_COMMON;
    public static final int DEFAULT_COST = 3;
    public static final boolean DEFAULT_HAS_SHEILD_TRIGGER = false; 

    /*Instance Variables */

    private String name;
    private String[] aliases = new String[2]; //Array for all possible names to search by. Usually contatins the full name of the card
                                              // and a shortened version, such as the first word in the card or the name seen during gameplay.
    private String civilization;
    private String cardType;
    private String textbox;
    private int rarity;
    private int cost;
    private boolean hasSheildTrigger;

    /**** CONSTRUCTORS ****/

    /**
     * Default constructor for DMCard. Defaults to the information for Belbetphlo, Wailing Shadow; the first card in
     * the game's initial search ordering.
     */
    public DMCard() {
        this(DEFAULT_NAME, DEFAULT_ALIASES, DEFAULT_CIVILIZATION, DEFAULT_CARD_TYPE, DEFAULT_TEXBOX, DEFAULT_RARITY,
                DEFAULT_COST, DEFAULT_HAS_SHEILD_TRIGGER);
    }

    /**
     * Full Constructor for the DMCard class, representing a Duel Masters card from the PS2 video game.
     * @param name A String for the full name of the Duel Masters card in the card viewer, NOT the shortened version occasionally used in-game
     * @param aliases A String array containing names that the card is commonly referred as. Needs a length > 0.
     *      The first entry in the array should be the same as the card's Name value, but is not checked at this point.
     * @param civilization A string representing the Duel Masters civilization (color) of the card. Capitalization doesn't matter.
     *      Valid Strings are Fire, Red, Water, Blue, Nature, Green, Darkness, Black, Light, Yellow, and White.
     * @param cardType A string for the card type of the card. Valid values are "creature" and "spell".
     *      capitalization doesn't matter, and "monster" is a valid substitue for "creature".
     * @param textbox A String for the text of the ability for the card. Includes static ablilities such as Sheild Trigger/Power
     *      Attacker as well as one-shot ablilities that only happen when the card is played. Multiple abilities should be
     *      shown on multiple lines in the single textbox variable
     * @param rarity An int representing the rarity of the card. Valid values are Common(0), Uncommon(1), Rare(2), Very Rare (3),
     *      Super Rare (4), and NONE (-1).
     * @param cost An int representing the amount of mana required to play the card. Must be >= 0.
     * @param hasSheildTrigger a boolean which is true if the card has the "Sheild Trigger" ability and false if it does not.
     * @throws IllegalArgumentException if any argument was invalid as seen in the param sections, will throw this exception with a messeage
     *      that includes some of the more likely mistakes that have been made.
     */
    public DMCard(String name, String[] aliases, String civilization, String cardType, String textbox,
            int rarity, int cost, boolean hasSheildTrigger) throws IllegalArgumentException {
        if (!this.setAll(name, aliases, civilization, cardType, textbox, rarity, cost, hasSheildTrigger)) {
            String message = "One or more fields were invalid. Most likely, you had an invalid civilization.\n";
            message += "The valid civilizations are:\n";
            for (String civ : CIVILIZATIONS) {
                message += civ + ", ";
            }
            message = message.substring(0, message.length() - 2);
            message += "\nYour inputted civilization: " + civilization;
            message += "\nOr perhaps rarity was out of bounds. It only goes up to Super Rare (" + RARITY_SUPER_RARE
                    + ")";
            throw new IllegalArgumentException(message);
        }

        // May later implement a check here to see if the first entry in Aliases matches the instance variable for name.
    }

    /**
     * Copy Constructor for DMCard class
     * @param original The original DMCard to be copied. Cannot be null.
     * @throws IllegalArgumentException If the original DMCard was null, throws this excpetion with an error message.
     */
    public DMCard(DMCard original) throws IllegalArgumentException {
        if (original == null) {
            throw new IllegalArgumentException("ERROR: Null arugment passed to DMCard copy constructor");
        }
        this.setAll(original.name, original.aliases, original.civilization, original.cardType, original.textbox,
                original.rarity, original.cost, original.hasSheildTrigger);
    }

    
    

    /*** MUTATORS ***/

    /**
     * Setter for name instance variable. Represents the full name of the Duel Masters card.
     * @param name A String for the full name of the Duel Masters card in the card viewer, NOT the shortened version occasionally used in-game
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for the aliases instance variable, which is an array of Strings for possible names of the card.
     * Includes the full name, any shortened versions used in-game, and any commonly-used shorthand names for the card.
     * @param aliases A String array containing names that the card is commonly referred as. Needs a length > 0.
     *      The first entry in the array should be the same as the card's Name value, but is not checked at this point.
     * @return true if the parameter is valid and the variable was properly set, false otherwise.
     */
    public boolean setAliases(String[] aliases) {
        boolean valid = true;
        if (aliases.length <= 0) {
            valid = false;
        } else {
            String[] newAliases = new String[aliases.length];
            for (int i = 0; i < aliases.length; i++) {
                newAliases[i] = aliases[i];
            }
            this.aliases = newAliases;
        }

        return valid;
    }

    
    /**
     * Setter for the civilization instance variable. Sets the card to be one of the five Duel Masters civilizations:
     * Fire, Water, Nature, Darkness, or Light.
     * @param civilization A string representing the Duel Masters civilization (color) of the card. Capitalization doesn't matter.
     *      Valid Strings are Fire, Red, Water, Blue, Nature, Green, Darkness, Black, Light, Yellow, and White.
     * @return true if civilization param was a valid value and the string was set, False if it was not valid and thus not set.
     */
    public boolean setCivilization(String civilization) {
        String civ = civilization.toLowerCase();
        boolean validColor = true;

        if (civ.equals("fire") || civ.equals("red")) {
            this.civilization = "Fire";
        } else if (civ.equals("light") || civ.equals("yellow") || civ.equals("white")) {
            this.civilization = "Light";
        } else if (civ.equals("water") || civ.equals("blue")) {
            this.civilization = "Water";
        } else if (civ.equals("nature") || civ.equals("green")) {
            this.civilization = "Nature";
        } else if (civ.equals("darkness") || civ.equals("black")) {
            this.civilization = "Darkness";
        } else {
            validColor = false;
        }

        return validColor;
    }


    /**
     * Setter for CardType instance variable. This is simply a String, NOT the child class card type
     * @param cardType A string for the card type of the card. Valid values are "creature" and "spell".
     *      capitalization doesn't matter, and "monster" is a valid substitue for "creature".
     * @return true if the parameter was valid and thus the cardType was set, false otherwise.
     */
    public boolean setCardType(String cardType) {
        boolean valid = true;
        String type = cardType.toLowerCase();
        if (type.equals("monster") || type.equals("creature")) {
            this.cardType = "creature";
        } else if (type.equals("spell")) {
            this.cardType = "spell";
        } else {
            valid = false;
        }

        return valid;
    }
    
    /**
     * Setter for textbox variable. Represents the ablilites the card has in-game. As a String;
     * NOT Ability objects, etc.
     * @param textbox A String for the text of the ability for the card. Includes static ablilities such as Sheild Trigger/Power
     *      Attacker as well as one-shot ablilities that only happen when the card is played. Multiple abilities should be
     *      shown on multiple lines in the single textbox variable
     */
    public void setTextbox(String textbox) {
        this.textbox = textbox;
    }

    /**
     * Setter for the rarity instance var, representing the card's rarity. In-Game values are Common(0),
     * Uncommon(1), rare(2), very rare(3), and super rare(4). I've also included a "none"(-1) rarity for cards that
     * can't be obtained through normal means should they be found, and as a default for an invalid rarity.
     * RARITY_... constants are used to help using the correct integers.
     * @param rarity An int representing the rarity of the card. Valid values are Common(0), Uncommon(1), Rare(2), Very Rare (3),
     *      Super Rare (4), and NONE (-1).
     * @return true if the parameter was one of the 6 available values and the var was set to match; false i
     *      the parameter was not a vailid value and the var was set to the default RARITY_NONE value.
     */
    public boolean setRarity(int rarity) {
        boolean valid = false;
        if (rarity == RARITY_COMMON || rarity == RARITY_UNCOMMON || rarity == RARITY_RARE ||
                rarity == RARITY_VERY_RARE || rarity == RARITY_SUPER_RARE) {
            this.rarity = rarity;
            valid = true;
        } else {
            if (rarity == RARITY_NONE) {
                valid = true;
            }
            this.rarity = RARITY_NONE;
        }

        return valid;
    }
    
    /**
     * Setter for cost instance var. Represents the amount of mana required to play the card.
     * @param cost An int representing the amount of mana required to play the card. Must be >= 0.
     * @return True if the paramater was non-negative and the value was set; false if the param was invalid and the value not set.
     */
    public boolean setCost(int cost) {
        boolean valid = false;
        if (cost >= 0) {
            this.cost = cost;
            valid = true;
        }
        return valid;
    }

    /**
     * Setter for hasSheildTrigger instance var. hasSheildTrigger becomes true if the card has the
     * "Sheild Trigger" ability, false if it does not have it.
     * @param hasSheildTrigger a boolean which is true if the card has the "Sheild Trigger" ability and false if it does not.
     */
    public void setHasSheildTrigger(boolean hasSheildTrigger) {
        this.hasSheildTrigger = hasSheildTrigger;
    }
    
    /**
     * Sets all instance varialbes for the Duel Masters card: name, aliases, civilization, cardType, textbox, rarity, cost,
     * and hasSheildTrigger.
     * @param name A String for the full name of the Duel Masters card in the card viewer, NOT the shortened version occasionally used in-game
     * @param aliases A String array containing names that the card is commonly referred as. Needs a length > 0.
     *      The first entry in the array should be the same as the card's Name value, but is not checked at this point.
     * @param civilization A string representing the Duel Masters civilization (color) of the card. Capitalization doesn't matter.
     *      Valid Strings are Fire, Red, Water, Blue, Nature, Green, Darkness, Black, Light, Yellow, and White.
     * @param cardType A string for the card type of the card. Valid values are "creature" and "spell".
     *      capitalization doesn't matter, and "monster" is a valid substitue for "creature".
     * @param textbox A String for the text of the ability for the card. Includes static ablilities such as Sheild Trigger/Power
     *      Attacker as well as one-shot ablilities that only happen when the card is played. Multiple abilities should be
     *      shown on multiple lines in the single textbox variable
     * @param rarity An int representing the rarity of the card. Valid values are Common(0), Uncommon(1), Rare(2), Very Rare (3),
     *      Super Rare (4), and NONE (-1).
     * @param cost An int representing the amount of mana required to play the card. Must be >= 0.
     * @param hasSheildTrigger a boolean which is true if the card has the "Sheild Trigger" ability and false if it does not.
     * @return True if all parameters were valid and have been set properly, false if one or more parameters were not set properly.
     */
    public boolean setAll(String name, String[] aliases, String civilization, String cardType, String textbox,
            int rarity, int cost, boolean hasSheildTrigger) {
        this.setName(name);
        this.setTextbox(textbox);
        this.setHasSheildTrigger(hasSheildTrigger);
        return this.setAliases(aliases) && this.setCivilization(civilization) && this.setCardType(cardType) && this.setRarity(rarity)
                && this.setCost(cost);
    }




    /***** OTHER REQUIRED METHODS *****/

    @Override
    public String toString() {
        String printString = String.format("%s%nA %s %s.%nCost: %d%nAbility: %s%nRarity: ", name, civilization, cardType,
                cost,
                textbox);
        String rarityString;
        switch (rarity) {
            case RARITY_NONE:
                rarityString = "NONE";
                break;
            case RARITY_COMMON:
                rarityString = "Common";
                break;
            case RARITY_UNCOMMON:
                rarityString = "Uncommon";
                break;
            case RARITY_RARE:
                rarityString = "Rare";
                break;
            case RARITY_VERY_RARE:
                rarityString = "Very Rare";
                break;
            case RARITY_SUPER_RARE:
                rarityString = "Super Rare";
                break;

            default:
                rarityString = "NONE";
                break;
        }
        printString += rarityString + "\n";
        if (hasSheildTrigger) {
            printString += "Has ";
        } else {
            printString += "Doesn't have ";
        }
        printString += "sheild trigger.";

        return printString;
    }
    
    /**
     * Only used for testing. Prints all aliases of the card in a human-readable format.
     * @return A String of all commonly-used name for the card, in a human-readable format
     */
    public String aliasesString() {
        String allAliases = "";
        for (String alias : aliases) {
            allAliases += alias + ", \n";
        }
        if (allAliases.length() > 0) {
            allAliases = allAliases.substring(0, allAliases.length() - 3);
        }
        allAliases = "Known as: \n" + allAliases;
        return allAliases;
    }

}
