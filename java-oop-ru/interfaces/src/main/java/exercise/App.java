package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> list, int quantity) {

        return list.stream()
                .limit(quantity)
                .sorted(Comparator.comparingDouble(Home::getArea))
                .map(Object::toString)
                .toList();
    }
}
// END
