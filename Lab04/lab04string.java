/** Class lab04string
 *
 * @author Mikolaj Marchewa
 */

public class lab04string {
    /**
     * Returns length of given string
     * @param s [String] - string which length is being calculated
     * @return [int] - length of given string s
     */
    public static int dlugosc(String s) {
        return s.length();
    }


    /**
     * Returns number of occurrences given char in given string
     * @param s [String] - string to be checked if contains given char
     * @param containsThisChar [char] - char to be counted in given string s
     * @return [int] - number of occurrences given char containsThisChar in given string s
     */
    public static int ile_razy_literka_wystepuje(String s, char containsThisChar) {
        int number = 0;
        for (char c : s.toCharArray()){
            if(c == containsThisChar)
                number += 1;
        }
        return number;
    }


    /**
     * Returns boolean if given strings s1 and s2 are equal
     * @param s1 [String] - first string to compare
     * @param s2 [String] - second string to compare
     * @return [boolean] - boolean if given strings s1 and s2 are equal
     */
    public static boolean czy_takie_same(String s1, String s2) {
        return s1.equals(s2);
    }


    /**
     * Returns reversed string
     * @param toReverse [String] - string to reverse
     * @return [String] - reversed string
     */
    public static String wspak(String toReverse) {
        char[] arr = toReverse.toCharArray();
        StringBuilder reversed = new StringBuilder();
        for(int i = toReverse.length() - 1; i>=0; i--)
            reversed.append(arr[i]);
        return reversed.toString();
    }


    /**
     * Returns boolean if given string is a palindrome
     * @param stringToCheck [String] - string to be checked if palindrome
     * @return [boolean] - boolean if given string is a palindrome
     */
    public static boolean czy_plaindrom(String stringToCheck) {
        String reversedString = wspak(stringToCheck);
        return stringToCheck.equals(reversedString);
    }


    /**
     * Returns boolean if chars in string are in alphabetical order
     * @param s [String] - string to be checked
     * @return [boolean] - boolean if chars in string are in alphabetical order
     */
    public static boolean czy_abecadlowe(String s) {
        if (s.length() == 1)
            return true;

        for(int i = 1; i < s.length(); i++){
            char prevChar = s.charAt(i-1);
            char nextChar = s.charAt(i);
            if(prevChar > nextChar)
                return false;
        }
        return true;
    }


    /**
     * Returns rotated string by 13 chars
     * @param s - string to be rotated
     * @return [String] - rotated string by 13 chars
     */
    public static String rot13(String s) {
        char currentChar;

        StringBuilder rotatedText = new StringBuilder();
        for(int i = 0; i<s.length(); i++) {
            currentChar = s.charAt(i);

            if(currentChar <= 'z' && currentChar >= 'a'){
                char movedChar = (char)(currentChar + 13);
                int diff = ((int)('z') - (int)(movedChar));
                if(diff < 0)
                    rotatedText.append((char)('a'- (diff+1)));
                else
                    rotatedText.append(movedChar);
            }else if(currentChar <= 'Z' && currentChar >= 'A'){
                char movedChar = (char)(currentChar + 13);
                int diff = ((int)('Z') - (int)(movedChar));
                if(diff < 0)
                    rotatedText.append((char)('A'- (diff+1)));
                else
                    rotatedText.append(movedChar);
            }else{
                rotatedText.append(currentChar);
            }
        }
        return rotatedText.toString();
    }
}
