package exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

import exercise.daytime.Daytime;
import exercise.daytime.Day;
import exercise.daytime.Night;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

// BEGIN

// END

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @Bean
    @Scope("prototype")
    public Daytime daytime() {
        var now = LocalDateTime.now();

        LocalDateTime startOfDay = now.toLocalDate().atTime(6, 0);
        LocalDateTime endOfDay = now.toLocalDate().atTime(18, 0);

        if (now.isAfter(startOfDay) && now.isBefore(endOfDay)) {
            return new Day();
        } else {
            return new Night();
        }
    }
    // END
}
