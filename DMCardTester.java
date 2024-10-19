import java.text.NumberFormat.Style;

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
        setterTest = test.setCivilization("Fire");
        System.out.println("Should have changed civilization field to Fire, to now say \"A Fire ...\"");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest + "\n");

        setterTest = test.setCivilization("LiGHt"); // testing capitalization, should still be valid
        System.out.println("Should have civilization Civilization field to Light, to now say \"A Light ...\"");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest + "\n");

        setterTest = test.setCivilization("Red"); // testing color instead of civilization, should still be valid
        System.out.println("Should have changed civilization field to Fire, to now say \"A Fire ...\"");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest + "\n");

        setterTest = test.setCivilization("Earth"); // testing invalid
        System.out.println("Should not have changed civiliaztion, to still say \"A Fire ...\"");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest + "\n");

        setterTest = test.setCivilization("nature"); // testing color instead of civilization, should still be valid
        System.out.println("Should have changed civilization field to Fire, to now say \"A Nature ...\"");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest + "\n");

        setterTest = test.setCivilization("water"); // testing color instead of civilization, should still be valid
        System.out.println("Should have changed civilization field to Fire, to now say \"A Water ...\"");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest + "\n");

        setterTest = test.setCivilization("DARKNESS"); // testing color instead of civilization, should still be valid
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

        setterTest = test.setCardType("CreaTUre"); // testing Creature, capitalization
        System.out.println("Card type should have changed. Should output \"A ... creature");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest);

        setterTest = test.setCardType("spell"); // testing spell
        System.out.println("Card type should have changed. Should output \"A ... spell");
        System.out.println(test);
        System.out.println("Setter returned: " + setterTest);

        setterTest = test.setCardType("trap"); // testing spell
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
        test.setHasSheildTrigger(true);
        System.out.println("Should have changed to say it has sheild trigger.");
        System.out.println(test);
        test.setHasSheildTrigger(false);
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
        setterTest = test.setAll("Xeno Mantis", aliases, "green", "monster", "Double Breaker", DMCard.RARITY_NONE, 0,
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
        setterTest = test.setAll("Gattling Skyterror", aliases, "Fire", "creature", "Power Attacker +4000",
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
        setterTest = test.setAll("Solar Ray", aliases, "purple", "magic", "Tap All Creatures", -5, -10,
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
            test = new DMCard("Gattling Skyterror", aliases, "Fire", "creature", "Double Breaker\nPower Attacker +4000",
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
            test = new DMCard("Solar Ray", aliases, "yellow", "spell", "Tap all creatures", DMCard.RARITY_NONE, 1,
                    true);
            System.out.println(test);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            System.out.println("Test failed somewhere. Check code");
        }

        System.out.println("Trying to create a card of Purple Civilization");
        constructorFailTests("Solar Ray", aliases, "purple", "spell", "Untap all creatures", DMCard.RARITY_UNCOMMON, 4,
                true);
        System.out.println("Trying to create a card of Trap type");
        constructorFailTests("Solar Ray", aliases, "light", "trap", "Untap all creatures", DMCard.RARITY_UNCOMMON, 4,
                true);
        System.out.println("Trying to create a card of invalid rarity");
        constructorFailTests("Solar Ray", aliases, "light", "trap", "Untap all creatures", 99, 4, true);
        System.out.println("Trying to create a card of negative cost");
        constructorFailTests("Solar Ray", aliases, "light", "spell", "Untap all creatures", DMCard.RARITY_UNCOMMON, -4,
                true);
        aliases = new String[0];
        System.out.println("Trying to create a card with no aliases");
        constructorFailTests("Solar Ray", aliases, "light", "spell", "Untap all creatures", DMCard.RARITY_UNCOMMON, 4, true);


    }
    
    public static void constructorFailTests(String name, String[] aliases, String civilization, String cardType, String textbox,
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
        DMCard test = new DMCard("Gattling Skyterror", aliases, "Fire", "creature", "Double Breaker\nPower Attacker +4000",
                    DMCard.RARITY_VERY_RARE, 6, false);
        System.out.println("\n==============================================");
        System.out.println("TESTING copy constructor METHOD:\n");

        System.out.println("Trying to copy a Gattling Skyterror.");
        System.out.println(
                "Should print info for Gattling Skyterror, a fire creature with double breaker and Power Attacker +4000. Rarity should be very rare, cost 6, no sheild trigger");
        try{
            DMCard copy = new DMCard(test);
            System.out.println(copy);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            System.out.println("Test failed...");
        }
        System.out.println("Trying to copy a null DMCard");
        try{
            DMCard copy = new DMCard(null);
            System.out.println(copy);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            System.out.println("Successfully failed");
        }


    }
    
    
    

    
}
