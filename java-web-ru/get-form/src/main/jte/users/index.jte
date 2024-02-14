@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <form action="/users" method="get">
        <input type="search" name="term" value="${page.getTerm()}" />
        <input type="submit" value="Search" />
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