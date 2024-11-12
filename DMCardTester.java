
/**
 * Tester for the DMCard class. Tests all required methods.
 * Based off of the tester in the Classes review project at the start of the semester
 * So we'll use a similar ordering, and again assume later tests require previous tests to work
 * 
 * @author Corey Jimenez <moontribedude@gmail.com>
 * @version 1.0
 */
public class DMCardTester {
    /*
        Tester Algorithm for DMCard Class
        - test toString()
        - test setName()
        - test setAliases()
        - test setCivilization()
            - valid data (data changes + return true)
            - invalid data (data doesn't change + return false)
        - test setCardType()
            - valid data (data changes + return true)
            - invalid data (data doesn't change + return false)
        - test setTextbox()
        - test setRarity()
            - valid data (data changes + return true)
            - invalid data (data defaults to -1 (NONE) + return false)
        - test setCost()
            - valid data (data changes + return true)
            - invalid data (data doesn't change + return false)
        - test setHasSheildTrigger()
        - test setAll()
            - valid data (data changes + return true)
            - invalid data (data doesn't change + return false)
        - test Default Constructor
        - test Full Constructor
            - valid data
            - invalid data (should show message)
        - test Copy Constructor
            - valid data
            - invalid data (should show message)
        - test getName()
        - test getAliases()
        - test getCivilization()
        - test getCardType()
        - test getTextbox()
        - test getRarity()
        - test getCost()
        - test getHasSheildTrigger()
        - test equals()
            - mismatching on all instance vars (returns false)
            - matching on all except for 1 instance var (returns false)
                - once for each instance var
            - matching on all instance vars (returns true)  
     */

    public static void main(String[] args) {
        testToString();
        testSetName();
        testSetCivilization();
        testSetAliases();
        testSetCardType();
        testSetTextbox();
        testSetRarirty();
        testSetCost();
        testSetHasSheildTrigger();
        testSetAll();
        // - test Default Constructor (implement default constructor,
        //		then see toString() test to see if it passes)
        testFullConstructor();
        testCopyConstructor();
        testGetName();
        testGetAliases();
        testGetCivilization();
        testGetCardType();
        testGetTextbox();
        testGetRarity();
        testGetCost();
        testGetHasSheildTrigger();
        testEquals();

    }



    
    public static void testToString() {
        DMCard test = new DMCard();
        System.out.println("\n==============================================");
        System.out.println("TESTING toString() METHOD:\n");

        System.out.println(
                "If no default constructor built, should get null for all string values, 0 for all ints, and false for all booleans.\n"
                        + "toString gives: \n"
                        + test.toString());
        
        System.out.println(
                "Otherwise, the above should show the default information for Belbetphlo, Wailing Shadow: A Darkness Creature with Slayer, Common, 3-cost, no sheild trigger.");
        System.out.println("If default constructor is implemented, aliases should be \"Belbetphlo, Wailing Shadow\" and \"Belbetphlo\" ");
        System.out.println(test.aliasesString());
    }

    public static void testSetName() {
        DMCard test = new DMCard();
        System.out.println("\n==============================================");
        System.out.println("TESTING setName() METHOD:\n");
        test.setName("Gattling Skyterror");
        System.out.println("Name should have changed to \"Gattling Skyterror\"");
        System.out.println(test);

    }
    
    public static void testSetCivilization() {
        DMCard test = new DMCard();
        boolean setterTest;
        System.out.println("\n==============================================");
        System.out.println("TESTING setCivilization() METHOD:\n");
        setterTest = test.setCivilization(DMCard.CIVILIZATION_FIRE);
        System.out.println("Should have changed civilization field to Fire, to now say \"A Fire ...\"");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest + "\n");

        setterTest = test.setCivilization(DMCard.CIVILIZATION_LIGHT);
        System.out.println("Should have civilization Civilization field to Light, to now say \"A Light ...\"");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest + "\n");

        setterTest = test.setCivilization(DMCard.CIVILIZATION_FIRE); // testing color instead of civilization, should still be valid
        System.out.println("Should have changed civilization field to Fire, to now say \"A Fire ...\"");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest + "\n");

        setterTest = test.setCivilization(5); // testing invalid
        System.out.println("Should not have changed civiliaztion, to still say \"A Fire ...\"");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest + "\n");

        setterTest = test.setCivilization(DMCard.CIVILIZATION_NATURE); // testing color instead of civilization, should still be valid
        System.out.println("Should have changed civilization field to Fire, to now say \"A Nature ...\"");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest + "\n");

        setterTest = test.setCivilization(DMCard.CIVILIZATION_WATER); // testing color instead of civilization, should still be valid
        System.out.println("Should have changed civilization field to Fire, to now say \"A Water ...\"");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest + "\n");

        setterTest = test.setCivilization(DMCard.CIVILIZATION_DARKNESS); // testing color instead of civilization, should still be valid
        System.out.println("Should have changed civilization field to Fire, to now say \"A Darkness ...\"");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest + "\n");

    }
    
    public static void testSetAliases() {
        DMCard test = new DMCard();
        boolean setterTest;
        String[] aliases = new String[2];
        System.out.println("\n==============================================");
        System.out.println("TESTING setAliases() METHOD:\n");
        aliases[0] = "Gattling Skyterror";
        aliases[1] = "Skyterror";

        setterTest = test.setAliases(aliases); //
        System.out.println("Aliases should have changed. Should output \"Gattling Skyterror\" and \"Skyterror\"");
        System.out.println(test.aliasesString());
        System.out.println("Setter returned: " + setterTest);
        aliases[0] = "Xeno Mantis";
        aliases[1] = "X Mantis"; // deep copy test
        System.out.println(
                "Deep copy test.\nAliases should not have changed. Should output \"Gattling Skyterror\" and \"Skyterror\"");
        System.out.println(test.aliasesString());

        setterTest = test.setAliases(aliases);
        System.out.println("Aliases should have changed. Should output \"Xeno Mantis\" and \"X Mantis\"");
        System.out.println(test.aliasesString());
        System.out.println("Setter returned: " + setterTest);

        aliases = new String[0];
        setterTest = test.setAliases(aliases); // invalid empty array test
        System.out.println("Aliases should not have changed. Should still output \"Xeno Mantis\" and \"X Mantis\"");
        System.out.println(test.aliasesString());
        System.out.println("Setter returned: " + setterTest);

    }

    public static void testSetCardType() {
        DMCard test = new DMCard();
        boolean setterTest;
        System.out.println("\n==============================================");
        System.out.println("TESTING setCardType() METHOD:\n");

        setterTest = test.setCardType(DMCard.CARDTYPE_CREATURE); // testing Creature, capitalization
        System.out.println("Card type should have changed. Should output \"A ... creature");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest);

        setterTest = test.setCardType(DMCard.CARDTYPE_SPELL); // testing spell
        System.out.println("Card type should have changed. Should output \"A ... spell");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest);

        setterTest = test.setCardType(3); // testing spell
        System.out.println("Card type should not have changed. Should still output \"A ... spell");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest);

    }
    
    public static void testSetTextbox() {
        DMCard test = new DMCard();
        System.out.println("\n==============================================");
        System.out.println("TESTING setTextbox() METHOD:\n");
        test.setTextbox("Power Attacker +4000");
        System.out.println("Ability should have changed to \"Power Attacker +4000\"");
        System.out.println(test);
    }
    
    public static void testSetRarirty() {
        DMCard test = new DMCard();
        boolean setterTest;
        System.out.println("\n==============================================");
        System.out.println("TESTING setRarity() METHOD:\n");

        setterTest = test.setRarity(DMCard.RARITY_SUPER_RARE); // testing Creature, capitalization
        System.out.println("Rarity should have changed. Should output \"Super Rare\"");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest);

        setterTest = test.setRarity(DMCard.RARITY_NONE); // testing Creature, capitalization
        System.out.println("Rarity should have changed. Should output \"NONE\" and return true");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest);

        setterTest = test.setRarity(DMCard.RARITY_VERY_RARE); // testing Creature, capitalization
        System.out.println("Rarity should have changed. Should output \"Very Rare\"");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest);

        setterTest = test.setRarity(DMCard.RARITY_RARE); // testing Creature, capitalization
        System.out.println("Rarity should have changed. Should output \"Rare\"");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest);

        setterTest = test.setRarity(DMCard.RARITY_UNCOMMON); // testing Creature, capitalization
        System.out.println("Rarity should have changed. Should output \"Uncommmon\"");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest);

        setterTest = test.setRarity(DMCard.RARITY_COMMON); // testing Creature, capitalization
        System.out.println("Rarity should have changed. Should output \"Common\"");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest);

        setterTest = test.setRarity(999); // testing Creature, capitalization
        System.out.println("Rarity should have changed. Should output \"NONE\" and return false");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest);

    }
    
    public static void testSetCost() {
        DMCard test = new DMCard();
        boolean setterTest;
        System.out.println("\n==============================================");
        System.out.println("TESTING setCost() METHOD:\n");

        setterTest = test.setCost(4);
        System.out.println("Cost should have changed. Should output \"4\"");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest);

        setterTest = test.setCost(-5); //invalid test
        System.out.println();
        System.out.println("Cost should not have changed. Should still output \"4\"");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest);

        setterTest = test.setCost(0); //Doesn't exist in game, but might in a future version, so we want it to work
        System.out.println();
        System.out.println("Cost should have changed. Should output \"0\"");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest);

    }
    
    public static void testSetHasSheildTrigger() {
        DMCard test = new DMCard();
        System.out.println("\n==============================================");
        System.out.println("TESTING setHasSheildTrigger() METHOD:\n");
        test.setHasShieldTrigger(true);
        System.out.println("Should have changed to say it has sheild trigger.");
        System.out.println(test);
        test.setHasShieldTrigger(false);
        System.out.println();
        System.out.println("Should have changed to say it doesn't have sheild trigger.");
        System.out.println(test);
    }

    public static void testSetAll() {
        DMCard test = new DMCard();
        boolean setterTest;
        String[] aliases = new String[2];
        System.out.println("\n==============================================");
        System.out.println("TESTING setAll() METHOD:\n");

        aliases[0] = "Xeno Mantis";
        aliases[1] = "X Mantis";
        setterTest = test.setAll("Xeno Mantis", aliases, DMCard.CIVILIZATION_NATURE, DMCard.CARDTYPE_CREATURE, "Double Breaker", DMCard.RARITY_NONE, 0,
                false);
        System.out.println(
                "setAll should have changed Name to Xeno Mantis, civ to Nature, card type to creature, ability to Double Breaker, rarity to NONE, cost to 0, and it should not have sheild trigger");
        System.out.println(test);

        System.out.println("Aliases should be \"Xeno Mantis\" and \"X Mantis\"");
        System.out.println(test.aliasesString());
        System.out.println("And setter should have returned true.");
        System.out.println("Setter returned: " + setterTest);
        System.out.println();

        aliases[0] = "Gattling Skyterror";
        aliases[1] = "Skyterror";
        setterTest = test.setAll("Gattling Skyterror", aliases, DMCard.CIVILIZATION_FIRE, DMCard.CARDTYPE_CREATURE, "Power Attacker +4000",
                DMCard.RARITY_SUPER_RARE, 6,
                true);
        System.out.println(
                "setAll should have changed Name to Gattling Skyterrer, civ to Fire, card type to creature, ability to Power Attacker +4000, rarity to Super Rare, cost to 6, and it should have sheild trigger");
        System.out.println(test);
        System.out.println("Aliases should be \"Gattling Skyterror\" and \"Skyterror\"");
        System.out.println(test.aliasesString());
        System.out.println("And setter should have returned true.");
        System.out.println("Setter returned: " + setterTest);
        System.out.println();

        aliases = new String[0];
        setterTest = test.setAll("Solar Ray", aliases, 90, DMCard.CARDTYPE_SPELL, "Tap All Creatures", -5, -10,
                false);
        System.out.println(
                "Should only have changed Name, Ability, and sheild trigger.");
        System.out.println(test);

        System.out.println("Aliases should still be \"Gattling Skyterror\" and \"Skyterror\"");
        System.out.println(test.aliasesString());
        System.out.println("And setter should have returned false.");
        System.out.println("Setter returned: " + setterTest);
        System.out.println();

    }

    public static void testFullConstructor() {
        DMCard test = new DMCard();
        System.out.println("\n==============================================");
        System.out.println("TESTING full constructor METHOD:\n");

        // valid data
        System.out.println(
                "Creating Gattling Skyterror. Should print info for Gattling Skyterror, a fire creature with double breaker and Power Attacker +4000. Rarity should be very rare, cost 6, no sheild trigger");
        String[] aliases = { "Gattling Skyterror", "Skyterror" };
        try {
            test = new DMCard("Gattling Skyterror", aliases, DMCard.CIVILIZATION_FIRE, DMCard.CARDTYPE_CREATURE, "Double Breaker\nPower Attacker +4000",
                    DMCard.RARITY_VERY_RARE, 6, false);
            System.out.println(test);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            System.out.println("Test failed somewhere. Check code");
        }

        aliases = new String[1];
        aliases[0] = "Solar Ray";
        System.out.println();
        System.out.println(
                "Creating Solar Ray. Should print info for Solar Ray, a yellow spell that taps all creatures. Rarity should be NONE, cost 1, has sheild trigger.");
        try {
            test = new DMCard("Solar Ray", aliases, DMCard.CIVILIZATION_LIGHT, DMCard.CARDTYPE_SPELL, "Tap all creatures", DMCard.RARITY_NONE, 1,
                    true);
            System.out.println(test);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            System.out.println("Test failed somewhere. Check code");
        }

        System.out.println("Trying to create a card of Purple Civilization");
        constructorFailTests("Solar Ray", aliases, -1, DMCard.CARDTYPE_SPELL, "Untap all creatures", DMCard.RARITY_UNCOMMON, 4,
                true);
        System.out.println("Trying to create a card of out of bounds card type");
        constructorFailTests("Solar Ray", aliases, DMCard.CIVILIZATION_LIGHT, 3, "Untap all creatures", DMCard.RARITY_UNCOMMON, 4,
                true);
        System.out.println("Trying to create a card of invalid rarity");
        constructorFailTests("Solar Ray", aliases, DMCard.CIVILIZATION_LIGHT, DMCard.CARDTYPE_SPELL, "Untap all creatures", 99, 4, true);
        System.out.println("Trying to create a card of negative cost");
        constructorFailTests("Solar Ray", aliases, DMCard.CIVILIZATION_LIGHT, DMCard.CARDTYPE_SPELL, "Untap all creatures", DMCard.RARITY_UNCOMMON, -4,
                true);
        aliases = new String[0];
        System.out.println("Trying to create a card with no aliases");
        constructorFailTests("Solar Ray", aliases, DMCard.CIVILIZATION_LIGHT, DMCard.CARDTYPE_SPELL, "Untap all creatures", DMCard.RARITY_UNCOMMON, 4, true);


    }
    
    public static void constructorFailTests(String name, String[] aliases, int civilization, int cardType, String textbox,
            int rarity, int cost, boolean hasSheildTrigger) {
        DMCard test;
        try {
            test = new DMCard(name, aliases, civilization, cardType, textbox, rarity, cost, hasSheildTrigger);
            System.out.println("The card was created? That shouldn't happen");
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            System.out.println("Successfully failed.");
        }
    }

    public static void testCopyConstructor() {
        String[] aliases = { "Gattling Skyterror", "Skyterror" };
        DMCard test = new DMCard("Gattling Skyterror", aliases, DMCard.CIVILIZATION_FIRE, DMCard.CARDTYPE_CREATURE, "Double Breaker\nPower Attacker +4000",
                DMCard.RARITY_VERY_RARE, 6, false);
        System.out.println("\n==============================================");
        System.out.println("TESTING copy constructor METHOD:\n");

        System.out.println("Trying to copy a Gattling Skyterror.");
        System.out.println(
                "Should print info for Gattling Skyterror, a fire creature with double breaker and Power Attacker +4000. Rarity should be very rare, cost 6, no sheild trigger");
        try{
            DMCard copy = new DMCard(test);
            System.out.println(copy);
            String[] shallow = {"Solary Ray", "Ray"};
            test.setAll("Solar Ray", shallow, DMCard.CIVILIZATION_LIGHT, DMCard.CARDTYPE_SPELL, "Tap All creatures", DMCard.RARITY_UNCOMMON, 1, true);
            System.out.println("Changed the original. Did the copy change?");
            System.out.println(copy);

        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            System.out.println("Test failed...");
        }
        

        System.out.println();
        System.out.println("Trying to copy a null DMCard");
        try{
            DMCard copy = new DMCard(null);
            System.out.println(copy);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            System.out.println("Successfully failed");
        }


    }

    public static void testGetName() {
        DMCard test = new DMCard();
        System.out.println("\n==============================================");
        System.out.println("TESTING getName() METHOD:\n");

        System.out.println("getName should be deafult name " + DMCard.DEFAULT_NAME + " : " + test.getName());
        test.setName("Gattling Skyterror");
        System.out.println("Changed name, should now be Gattling Skyterror: " + test.getName());
    }

    public static void testGetAliases() {
        DMCard test = new DMCard();
        System.out.println("\n==============================================");
        System.out.println("TESTING getAliases() METHOD:\n");

        System.out.println("Should have the default aliases of Belbetphlo, Wailing Shadow; Belbetphlo:");
        System.out.println(aliasesString(test.getAliases()));
        String[] aliases = { "Solar Ray", "Sol" };
        test.setAliases(aliases);
        System.out.println("Should change to Solar Ray; Sol:");
        System.out.println(aliasesString(test.getAliases()));
    }

    public static String aliasesString(String[] aliases) {
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

    public static void testGetCivilization() {
        DMCard test = new DMCard();
        System.out.println("\n==============================================");
        System.out.println("TESTING getCivilization() METHOD:\n");

        System.out.println("Should have the default civilization of " + DMCard.DEFAULT_CIVILIZATION + " : "
                + test.getCivilization());
        test.setCivilization(DMCard.CIVILIZATION_LIGHT);
        System.out.println("Changed name, should now be Light: " + test.getCivilization());

    }

    public static void testGetCardType() {
        DMCard test = new DMCard();
        System.out.println("\n==============================================");
        System.out.println("TESTING getCardType() METHOD:\n");

        System.out.println(
                "Should have the default card type of " + DMCard.DEFAULT_CARD_TYPE + " : " + test.getCardType());
        test.setCardType(DMCard.CARDTYPE_SPELL);
        System.out.println("Changed type, should now be Spell: " + test.getCardType());
    }
    
    public static void testGetTextbox(){
        DMCard test = new DMCard();
        System.out.println("\n==============================================");
        System.out.println("TESTING getTextbox() METHOD:\n");

        System.out.println("Should have the default textbox of " + DMCard.DEFAULT_TEXTBOX + " : "
                + test.getTextbox());
        test.setTextbox("Blocker");
        System.out.println("Changed textbox, should now be Blocker: " + test.getTextbox());
    }

    public static void testGetRarity() {
        DMCard test = new DMCard();
        System.out.println("\n==============================================");
        System.out.println("TESTING getRarity() METHOD:\n");

        System.out.println("Should have the default rarity of " + DMCard.DEFAULT_RARITY + " : "
                + test.getRarity());
        test.setRarity(DMCard.RARITY_RARE);
        System.out.println("Changed rarity, should now be " + DMCard.RARITY_RARE + ": " + test.getRarity());
    }

    public static void testGetCost() {
        DMCard test = new DMCard();
        System.out.println("\n==============================================");
        System.out.println("TESTING getCost() METHOD:\n");

        System.out.println("Should have the default cost of " + DMCard.DEFAULT_COST + " : "
                + test.getCost());
        test.setCost(7);
        System.out.println("Changed cost, should now be 7: " + test.getCost());
    }

    public static void testGetHasSheildTrigger() {
        DMCard test = new DMCard();
        System.out.println("\n==============================================");
        System.out.println("TESTING getHasSheildTrigger() METHOD:\n");

        System.out.println("Should have the default hasSheildTrigger of " + DMCard.DEFAULT_HAS_SHIELD_TRIGGER + " : "
                + test.getHasShieldTrigger());
        test.setHasShieldTrigger(true);
        System.out.println("Changed sheild trigger, should now be true : " + test.getHasShieldTrigger());
    }

    public static void testEquals() {
        String[] aliases = { "Gattling Skyterror", "Skyterror" };
        DMCard test1 = new DMCard("Gattling Skyterror", aliases, DMCard.CIVILIZATION_FIRE, DMCard.CARDTYPE_CREATURE, "Double Breaker\nPower Attacker +4000",
                    DMCard.RARITY_VERY_RARE, 6, false);
        System.out.println("\n==============================================");
        System.out.println("TESTING equals() METHOD:\n");
        DMCard test2 = new DMCard(test1);

        System.out.println("Testing equals on two equal objects. Should be true: " + test1.equals(test2));
        test2.setName("Solar Ray");
        System.out.println("Testing equals on two objects with different names. Should be false: " + test1.equals(test2));
        test2 = new DMCard(test1);
        String[] changedAlias = {"Gattling Skyterror"};
        test2.setAliases(changedAlias);
        System.out.println("Testing equals on two objects with different numbers of aliases. Should be false: "
                + test1.equals(test2));
        test2 = new DMCard(test1);
        test2.setCivilization(DMCard.CIVILIZATION_NATURE);
        System.out.println(
                "Testing equals on two objects with different civilizations. Should be false: " + test1.equals(test2));
        test2 = new DMCard(test1);
        test2.setCardType(DMCard.CARDTYPE_SPELL);
        System.out.println(
                "Testing equals on two objects with different card types. Should be false: " + test1.equals(test2));
        test2 = new DMCard(test1);
        test2.setTextbox("Add 1 card to your sheilds");
        System.out.println(
                "Testing equals on two objects with different texboxes. Should be false: " + test1.equals(test2));
        test2 = new DMCard(test1);
        test2.setRarity(DMCard.RARITY_COMMON);
        System.out.println(
                "Testing equals on two objects with different rarities. Should be false: " + test1.equals(test2));
        test2 = new DMCard(test1);
        test2.setCost(0);
        System.out.println("Testing equals on two objects with different costs. Should be false: " + test1.equals(test2));
        test2 = new DMCard(test1);
        test2.setHasShieldTrigger(true);
        System.out.println(
                "Testing equals on two objects with different civilizations. Should be false: " + test1.equals(test2));
        test2 = new DMCard("Solar Ray", changedAlias, DMCard.CIVILIZATION_NATURE, DMCard.CARDTYPE_CREATURE, "Add 1 card to your sheilds", DMCard.RARITY_COMMON, 0, true);
        System.out.println("Testing equals on two objects with all fields different. Should be false: " + test1.equals(test2));

    }
    
    
    

    
}
