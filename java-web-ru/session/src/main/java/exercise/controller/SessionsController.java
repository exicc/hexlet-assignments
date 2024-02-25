package exercise.controller;

import java.util.Collections;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void index(Context ctx) {
        var page = new MainPage(ctx.sessionAttribute("currentUser"));
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }
    public static void build(Context ctx) {
        ctx.render("build.jte");
    }
    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = ctx.formParam("password");


        if (UsersRepository.existsByName(name)) {
            var user = UsersRepository.findByName(name);
            var userPassword = user.getPassword();
            if (encrypt(password).equals(userPassword)) {
                ctx.sessionAttribute("currentUser", name);
                ctx.redirect(NamedRoutes.rootPath());
            }
        } else {
            var page = new LoginPage(name, "Wrong username or password");
            ctx.render("build.jte", Collections.singletonMap("page", page));
            ctx.redirect(NamedRoutes.rootPath());
        }
    }
    public static void delete(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }

    // END
}
