package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String availableChars, String word) {

        availableChars = availableChars.toLowerCase();
        word = word.toLowerCase();

        List<Character> charsList = new ArrayList<>();
        for (int i = 0; i < availableChars.length(); i++) {
            charsList.add(availableChars.charAt(i));
        }

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (charsList.contains(ch)) {
                charsList.remove(Character.valueOf(ch));
            } else {
                return false;
            }
        }

        return true;
    }
}
//END
