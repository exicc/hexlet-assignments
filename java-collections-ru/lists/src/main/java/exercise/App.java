package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String symbols, String word) {

        List<String> wordList = new ArrayList<>(Arrays.asList(word.toLowerCase().split("")));

        List<String> symbolsList = new ArrayList<>(Arrays.asList(symbols.toLowerCase().split("")));

        boolean result = true;
        for (String item: wordList) {

            if (symbolsList.contains(item)) {
                symbolsList.remove(item);
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}
//END
