package exercise;




import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.io.IOException;

// BEGIN
public class App {
    public static void save(Path filePath, Car car) {
        try {
            String jsonRepresentation = car.serialize();
            Files.write(filePath
                    , jsonRepresentation.getBytes()
                    , StandardOpenOption.CREATE
                    , StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Error saving the object to file", e);
        }
    }

    public static Car extract(Path filePath) {
        try {
            String json = Files.readString(filePath);
            return Car.unserialize(json);
        } catch (IOException e) {
            throw new RuntimeException("Error extracting the object from file", e);
        }
    }
}
// END
