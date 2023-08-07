package exercise;

import java.lang.reflect.Field;
import java.util.*;

// BEGIN
class Validator {
    public static List<String> validate(Address address) {

        List<String> result = new LinkedList<>();
        String value;
        for (Field field : address.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    field.setAccessible(true);
                    value = (String) field.get(address);
                    if (value == null) {
                        result.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
// END
