public class DMCreature extends DMCard{
    /***CONSTANTS***/
    //defaults to Belbetphlo
    public static final int DEFAULT_POWER = 1000;
    public static final String DEFAULT_RACE = "Ghost";
    public static final boolean DEFAULT_IS_EVOLUTION = false;

    //default races
    public static final String[] VALID_RACES =
            {"ghost","brain jacker","living dead","demon command","chimera","parasite worm","hedrian","dark lord",
            "armored dragon","human","dragonoid","rock beast","armored wyvern","machine eater","armorloid",
            "angel command","light bringer","guardian","starlight tree","initiate","berserker","mecha thunder",
            "beast folk","giant","giant insect","tree folk","horned beast",
            "liquid people","cyber virus","cyber lord","leviathan","gel fish","fish"};
    int power;
    String race;
    boolean isEvolution;

    /**** CONSTRUCTORS ****/

    /**
     * Default constructor for DMCard. Defaults to the information for Belbetphlo, Wailing Shadow; the first card in
     * the game's initial search ordering.
     */
    public DMCreature() {
        this(DEFAULT_NAME, DEFAULT_ALIASES, DEFAULT_CIVILIZATION, DEFAULT_CARD_TYPE, DEFAULT_TEXTBOX, DEFAULT_RARITY,
                DEFAULT_COST, DEFAULT_HAS_SHIELD_TRIGGER,DEFAULT_POWER,DEFAULT_RACE,DEFAULT_IS_EVOLUTION);
    }

    /**
     * Full Constructor for the DMCreature class, representing a creature-type Duel Masters card from the PS2 video game.
     * @param name A String for the full name of the Duel Masters card in the card viewer, NOT the shortened version occasionally used in-game
     * @param aliases A String array containing names that the card is commonly referred as. Needs a length > 0.
     *      The first entry in the array should be the same as the card's Name value, but is not checked at this point.
     * @param civilization An int representing the Duel Masters civilization (color) of the card. Use CIVILIZATION_... constants
     * @param cardType an int using the CARDTYPE_... constants for Creature or Spell
     * @param textbox A String for the text of the ability for the card. Includes static ablilities such as Sheild Trigger/Power
     *      Attacker as well as one-shot ablilities that only happen when the card is played. Multiple abilities should be
     *      shown on multiple lines in the single textbox variable
     * @param rarity An int representing the rarity of the card. Valid values are Common(0), Uncommon(1), Rare(2), Very Rare (3),
     *      Super Rare (4), and NONE (-1).
     * @param cost An int representing the amount of mana required to play the card. Must be >= 0.
     * @param hasSheildTrigger a boolean which is true if the card has the "Sheild Trigger" ability and false if it does not.
     * @param power An int for the base power of the creature card. Must be >=0; doesn't count in-game modifiers
     * @param race A string for the race of the card. Valid values are found in the VALID_RACES array,
     * and some shorthands are accepted. Capitalization doesn't matter.
     * @param isEvolution True if the creature is an evolution creature; false if it is not.
     * @throws IllegalArgumentException if any argument was invalid as seen in the param sections, will throw this exception with a messeage
     *      that includes some of the more likely mistakes that have been made.
     */
    public DMCreature(String name, String[] aliases, int civilization, int cardType, String textbox,
                  int rarity, int cost, boolean hasSheildTrigger, int power, String race, boolean isEvolution) throws IllegalArgumentException {
        if (!this.setAll(name, aliases, civilization, cardType, textbox, rarity, cost, hasSheildTrigger, power,race,isEvolution)) {
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

    /*** MUTATORS ***/

    /**
     * Setter for power instance variable. Represents the power value of the duel monsters creature, whic is used to determine
     * combat against creatures and other effects in the Duel Masters video game
     * @param power An int for the base power of the creature card. Must be >=0; doesn't count in-game modifiers
     * @return true if the param was valid and power has been sucessfully set; false otherwise.
     */
    public boolean setPower(int power) {
        if(power>=0){
            this.power = power;
            return true;
        }else{
            return false;
        }
    }

    /**
     * Setter for setRace instance variable. This is simply a String.
     * @param cardRace A string for the race of the card. Valid values are found in the VALID_RACES array,
     * and some shorthands are accepted. Capitalization doesn't matter.
     * @return true if the parameter was valid and thus the cardRace was set, false otherwise.
     */
    public boolean setRace(String cardRace) {
        boolean valid = true;
        if(cardRace==null){
            return false;
        }
        String race = cardRace.toLowerCase();
        //Check if the param is exactly a valid race
        if(UtilityBelt.arrayContains(VALID_RACES,race)){
            this.race = race;
        // Now go on to check for shorthand equivalents
        } else if (race.equals("jack")) {
            this.race = "brain jacker";
        } else if (race.equals("zombie")) {
            this.race = "living dead";
        }else if (race.equals("demon")) {
            this.race = "demon command";
        }else if (race.equals("worm")) {
            this.race = "parasite worm";
        }else if (race.equals("vamp")) {
            this.race = "dark lord";
        }else if (race.equals("armd")) {
            this.race = "armored dragon";
        }else if (race.equals("armw")) {
            this.race = "armored wyvern";
        }else if (race.equals("noid")) {
            this.race = "dragonoid";
        }else if (race.equals("rock")) {
            this.race = "rock beast";
        }else if (race.equals("eater")) {
            this.race = "machine eater";
        }else if (race.equals("angel")) {
            this.race = "angel command";
        }else if (race.equals("bringer")) {
            this.race = "light bringer";
        }else if (race.equals("star tree")) {
            this.race = "starlight tree";
        }else if (race.equals("thunder")) {
            this.race = "mecha thunder";
        }else if (race.equals("insect")) {
            this.race = "giant insect";
        }else if (race.equals("horn")) {
            this.race = "horned beast";
        }else if (race.equals("tree")) {
            this.race = "tree folk";
        }else if (race.equals("people")) {
            this.race = "liquid people";
        }else if (race.equals("virus")) {
            this.race = "cyber virus";
        }else if (race.equals("gel")) {
            this.race = "gel fish";
        }else{
            //Doesn't match exact or any shorthands, so invalid
            valid = false;
        }
        return valid;
    }

    /**
     * Setter for isEvolution instance variable. If true, in notes the creature as an
     * Evolution creature. If false, it is a regular creature without the Evolution restrictions.
     * @param isEvolution True if the creature is an evolution creature; false if it is not.
     */
    public void setIsEvolution(boolean isEvolution){
        this.isEvolution = isEvolution;
    }

    /**
     * Sets all instance varialbes for the Duel Masters creature card: name, aliases, civilization, cardType, textbox, rarity, cost,
     * hasSheildTrigger, power, race, and isEvolution.
     * @param name A String for the full name of the Duel Masters card in the card viewer, NOT the shortened version occasionally used in-game
     * @param aliases A String array containing names that the card is commonly referred as. Needs a length > 0.
     *      The first entry in the array should be the same as the card's Name value, but is not checked at this point.
     * @param civilization A string representing the Duel Masters civilization (color) of the card. Capitalization doesn't matter.
     *      Valid Strings are Fire, Red, Water, Blue, Nature, Green, Darkness, Black, Light, Yellow, and White.
     * @param cardType an int using the CARDTYPE_... constants for Creature or Spell
     * @param textbox A String for the text of the ability for the card. Includes static ablilities such as Sheild Trigger/Power
     *      Attacker as well as one-shot ablilities that only happen when the card is played. Multiple abilities should be
     *      shown on multiple lines in the single textbox variable
     * @param rarity An int representing the rarity of the card. Valid values are Common(0), Uncommon(1), Rare(2), Very Rare (3),
     *      Super Rare (4), and NONE (-1).
     * @param cost An int representing the amount of mana required to play the card. Must be >= 0.
     * @param hasSheildTrigger a boolean which is true if the card has the "Sheild Trigger" ability and false if it does not.
     * @param power An int for the base power of the creature card. Must be >=0; doesn't count in-game modifiers
     * @param race A string for the race of the card. Valid values are found in the VALID_RACES array,
     * and some shorthands are accepted. Capitalization doesn't matter.
     * @param isEvolution True if the creature is an evolution creature; false if it is not.
     * @return True if all parameters were valid and have been set properly, false if one or more parameters were not set properly.
     * @throws IllegalArgumentException if the race argument was invalid, will throw this exception with a message
     * that includes some of the more likely mistakes that have been made.
     */
    public boolean setAll(String name, String[] aliases, int civilization, int cardType, String textbox,
                          int rarity, int cost, boolean hasSheildTrigger,int power, String race, boolean isEvolution) throws IllegalArgumentException{
        this.setIsEvolution(isEvolution);
        boolean raceValid = this.setRace(race);
        if(!raceValid){
            String message = "Race string invalid.\n";
            message += "The valid races are:\n";
            for (String cardRace : VALID_RACES) {
                message += cardRace + ", ";
            }
            message = message.substring(0, message.length() - 2);
            message += "\nYour inputted race: " + civilization;
            throw new IllegalArgumentException(message);
        }
        boolean cardSuccess = super.setAll(name,aliases,civilization,cardType,textbox,rarity,cost,hasSheildTrigger);
        return cardSuccess && this.setPower(power); //&& raceValid, but that will always be true at this point
    }


}
