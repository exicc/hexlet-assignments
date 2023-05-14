package exercise;


import java.util.Arrays;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static String getForwardedVariables(String content) {
        String prefix = "X_FORWARDED_";
        return Arrays.stream(content.split("\n"))
                .filter(line -> line.contains("environment="))
                .map(line -> line.substring(line.indexOf("=") + 1).replaceAll("\"", ""))
                .flatMap(vars -> Arrays.stream(vars.split(",")))
                .map(String::trim)
                .filter(var -> var.startsWith(prefix))
                .map(var -> var.substring(prefix.length()))
                .map(var -> {
                    String[] keyValue = var.split("=");
                    return keyValue[0] + "=" + keyValue[1];
                })
                .collect(Collectors.joining(","));
    }
}
//END
