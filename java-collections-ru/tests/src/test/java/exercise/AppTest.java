package exercise;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> elements1 = new ArrayList<>();
        elements1.add(1);
        elements1.add(2);
        elements1.add(3);
        elements1.add(4);
        int elementsCount1 = 3;

        int length1 = elements1.size();
        if (elementsCount1 > length1) {
            elementsCount1 = length1;
        }
        List<Integer> result1 = new ArrayList<>();
        for (int i = 0; i < elementsCount1; i++) {
            result1.add(elements1.get(i));
        }

        assertThat(App.take(elements1, elementsCount1)).isEqualTo(result1);

        List<Integer> elements2 = new ArrayList<>();
        elements2.add(1);
        elements2.add(2);
        elements2.add(3);
        elements2.add(4);
        elements2.add(3);
        elements2.add(2);
        elements2.add(1);
        elements2.add(0);
        int elementsCount2 = 3;

        int length2 = elements2.size();
        if (elementsCount2 > length2) {
            elementsCount2 = length2;
        }
        List<Integer> result2 = new ArrayList<>();
        for (int i = 0; i < elementsCount2; i++) {
            result2.add(elements2.get(i));
        }

        assertThat(App.take(elements2, elementsCount2)).isEqualTo(result2);
        // END
    }
}
