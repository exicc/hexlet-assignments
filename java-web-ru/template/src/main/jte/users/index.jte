@import exercise.dto.users.UsersPage
@param UsersPage usersPage



<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User List</title>
</head>
<body>
<h1>User List</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    @for(var userPage : usersPage.getUsers())
    <tr>
        <td>${userPage.getId()}</td>
        <td>${userPage.getFirstName()}</td>
        <td>${userPage.getLastName()}</td>
        <td>${userPage.getEmail()}</td>
        <td><a href="/users/@userPage.getUser().getId()">View</a></td>
    </tr>
    @endfor
    </tbody>
</table>
</body>
</html>
