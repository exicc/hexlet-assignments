@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <form action="/users" method="get">
        <input type="search" name="term" value="${page.getTerm()}" />
        <input type="submit" value="Search" />
    </form>


    @if(!page.getUsers().isEmpty())
        <ul>
            <table class="table table-striped">
                @for(var user : page.getUsers())
                    <tr>
                        <td>
                            ${user.getId()}
                        </td>
                        <td>
                            ${user.getFirstName()} ${user.getLastName()}
                        </td>
                    </tr>
                @endfor
            </table>
        </ul>
    @endif
`
)