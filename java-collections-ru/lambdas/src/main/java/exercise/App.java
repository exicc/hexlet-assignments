package exercise;

import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class  App {
    public static String[][] enlargeArrayImage(String[][] image) {

        return Arrays.stream(image)
                .flatMap(row -> Stream.of(row)
                        .map(str -> str.split(""))
                        .flatMap(Arrays::stream)
                        .flatMap(ch -> Stream.of(ch, ch))
                )
                .toArray(String[][]::new);
    }
}
// END
