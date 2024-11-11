/**
 * Utility Belt class holds helper methods for various other classes to use
 */
public class UtilityBelt {

    /**
     * Iterates over and array to see if it contains a specified value. Ignores capitalization.
     * Must fully match a string in the array (partial match returns false)
     * @param validStringsArray The array to search for the value
     * @param value the string to search for in the array.
     * @return true if an element of the array exactly matches the value, ignoring case. False if there are no matches in the array.
     */
    public static boolean arrayContains(String[] validStringsArray, String value) {
        if (value == null || validStringsArray == null) {
            return false;
        }

        int location = 0;
        boolean isPresent = false;

        while (!isPresent && (location < validStringsArray.length)) { // while not found and haven't gone through full array
            isPresent = validStringsArray[location].equalsIgnoreCase(value);
            location++;
        }

        return isPresent;
    }
}
