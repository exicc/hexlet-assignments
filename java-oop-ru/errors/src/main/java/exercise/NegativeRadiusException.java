package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {

    public NegativeRadiusException() {
        super("Радиус круга не может быть отрицательным.");
    }
}
// END
