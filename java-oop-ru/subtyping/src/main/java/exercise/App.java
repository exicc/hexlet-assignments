package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage database) {
        Map<String, String> originalMap = database.toMap();
        Map<String, String> swappedMap = new HashMap<>();
        for (Entry<String, String> entry : originalMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!swappedMap.containsKey(value)) {
                swappedMap.put(value, key);
                database.unset(key);
            }
        }

        for (Entry<String, String> entry : swappedMap.entrySet()) {
            database.set(entry.getKey(), entry.getValue());
        }
    }
}
// END
