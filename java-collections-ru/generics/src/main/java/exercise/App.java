package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
class App {

    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> searchParams) {

        List<Map<String, String>> matchingBooks = new ArrayList<>();
        for (Map<String, String> book : books) {
            boolean found = true;
            for (Map.Entry<String, String> entry : searchParams.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                if (!book.containsKey(key) || !book.get(key).equals(value)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                matchingBooks.add(book);
            }
        }

        return matchingBooks;
    }
}
//END
