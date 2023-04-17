package exercise;

import java.util.List;

// BEGIN
class App {
    public static int getCountOfFreeEmails(List<String> emailsList) {

        return (int) emailsList.stream()
                .filter(string -> string.contains("@gmail.com")
                        || string.contains("@yandex.ru")
                        || string.contains("@hotmail.com"))
                .count();
    }
}
// END
