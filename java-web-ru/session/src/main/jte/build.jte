@import exercise.util.NamedRoutes

<form action="${NamedRoutes.loginPath()}" method="post">
    <input type="text" placeholder="Nickname" name="name" />
    <input type="password" placeholder="Password" name="password" />
    <input type="submit" />
</form>
