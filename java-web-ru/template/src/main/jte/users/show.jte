@import exercise.dto.users.UserPage
@param UserPage userPage

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Details</title>
</head>
    <body>
        <h1>User Details</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <td>${userPage.getUser().getId()}</td>
            </tr>
            <tr>
                <th>First Name</th>
                <td>${userPage.getUser().getFirstName()}</td>
            </tr>
            <tr>
                <th>Last Name</th>
                <td>${userPage.getUser().getLastName()}</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${userPage.getUser().getEmail()}</td>
            </tr>
        </table>
        <br>
        <a href="/users">Back to User List</a>
    </body>
</html>
