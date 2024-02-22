package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import java.util.Collections;
import exercise.repository.UserRepository;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void register(Context ctx) {
        var firstName = ctx.formParam("firstName");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");
        String token = Security.generateToken();

        var newUser = new User(firstName, lastName, email, password, token);
        UserRepository.save(newUser);

        ctx.cookie("userToken", token);
        var id = newUser.getId();

        ctx.redirect(NamedRoutes.userPath(id));
    }
    public static void showUser(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var userToken = ctx.cookie("userToken");

        var userOptional = UserRepository.find(id);

        if (userOptional.isPresent() && userOptional.get().getToken().equals(userToken)) {
            ctx.render("users/show.jte", Collections.singletonMap("user", userOptional.get()));
        } else {
            ctx.redirect(NamedRoutes.buildUserPath());
        }
    }
    // END
}
