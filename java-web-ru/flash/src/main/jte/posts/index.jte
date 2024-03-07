@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(

page = page,
content = @`
    <div class="container mt-5">
        <h1>Все посты</h1>
        <div class="mb-3">
            <a class="btn btn-primary" href="${NamedRoutes.buildPostPath()}">Создать новый пост</a>
        </div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Название</th>
                <th>Текст</th>
            </tr>
            </thead>
            <tbody>
            @for(var post : page.getPosts())
                <tr>
                    <td>${post.getId()}</td>
                    <td>
                        <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
                    </td>
                    <td>${post.getBody()}</td>
                </tr>
            @endfor
            </tbody>
        </table>
    </div>
`,
)