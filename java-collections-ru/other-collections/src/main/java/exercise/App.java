package exercise;

import java.util.*;

// BEGIN
class App {
    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> result = new LinkedHashMap<>();

        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(data1.keySet());
        allKeys.addAll(data2.keySet());

        for (String key : allKeys) {
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);

            if (value1 == null && value2 != null) {
                result.put(key, "added");
            } else if (value1 != null && value2 == null) {
                result.put(key, "deleted");
            } else if (value1 != null && !value1.equals(value2)) {
                result.put(key, "changed");
            } else {
                result.put(key, "unchanged");
            }
        }

        return sortMapByKey(result);
    }

    private static Map<String, String> sortMapByKey(Map<String, String> map) {
        List<Map.Entry<String, String>> entries = new LinkedList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByKey());

        Map<String, String> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
//END
