@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
    <form action="/users" method="get">
        <label for="filter">Filter by Name:</label>
        <input type="text" name="term" value="${page.getTerm()}">
        <button type="submit">Filter</button>
    </form>


    @if(page.getUsers().isEmpty())
        <p>Пользователи не найдены.</p>
    @else
        <ul>
        @for(var user : page.getUsers())
            <li>${user.getFirstName()}</li>
        @endfor
        </ul>
    @endif
    `
)