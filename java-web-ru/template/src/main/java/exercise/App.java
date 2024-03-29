package exercise;

import io.javalin.Javalin;
import java.util.List;
import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import java.util.Collections;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            UsersPage usersPage = new UsersPage(USERS);
            ctx.render("users/index.jte", Collections.singletonMap("usersPage", usersPage));
        });

        app.get("/users/{id}", ctx -> {
            long userId = ctx.pathParamAsClass("id", Long.class).get();
            User user = USERS.stream()
                    .filter(u -> u.getId() == userId)
                    .findFirst()
                    .orElse(null);

            if (user != null) {
                UserPage userPage = new UserPage(user);
                ctx.render("users/show.jte", Collections.singletonMap("userPage", userPage));
            } else {
                throw new NotFoundResponse("User not found");
            }
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
