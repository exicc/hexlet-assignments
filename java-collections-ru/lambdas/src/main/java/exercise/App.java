package exercise;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
class  App {
    public static String[] duplicateValues(String[] items) {

        return Arrays.stream(items)
                .flatMap(item -> Arrays.stream(new String[] {item, item}))
                .toArray(String[]::new);
    }

    public static String[][] enlargeArrayImage(String[][] image) {

        String[][] horizontallyStretched = Arrays.stream(image)
                .map(App::duplicateValues)
                .flatMap(item -> Stream.of(item, item))
                .toArray(String[][]::new);

        return Arrays.stream(horizontallyStretched)
                .toArray(String[][]::new);
    }
}
// END
