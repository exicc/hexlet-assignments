package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {

    public static Map<String, Integer> getWordCount(String sentence) {

        String[] words = sentence.split("\\s+");
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            if (!word.isBlank()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        return wordCountMap;
    }

    public static String toString(Map<String, Integer> words) {

        var result = new StringBuilder();
        if (words.isEmpty()) {
            return "{}";
        }
        result.append("{\n");
        for (Map.Entry<String, Integer> word : words.entrySet()) {

            result.append("  ").append(word.getKey()).append(": ").append(word.getValue()).append("\n");
        }
        result.append("}");

        return result.toString();
    }
}
//END
