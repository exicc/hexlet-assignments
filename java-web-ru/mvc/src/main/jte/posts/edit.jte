@import exercise.dto.posts.EditPostPage
@import exercise.util.NamedRoutes

@param EditPostPage page

@template.layout.page(
content = @`
    <main>
        <div class="mx-auto p-4 py-md-5">
            <h1>Редактирование поста</h1>
        </div>

        <div class="mx-auto p-4 py-md-5">
            @if(page.getErrors() != null)
                <ul class="text-danger">
                    @for(var validator : page.getErrors().values())
                        @for(var error : validator)
                            <li>${error.getMessage()}</li>
                        @endfor
                    @endfor
                </ul>
            @endif

            <form action="${NamedRoutes.updatePostPath(page.getId())}" method="post">
                <div class="mb-3">
                    <label for="name" class="form-label">Название</label>
                    <input type="text" class="form-control" id="name" name="name" value="${page.getName()}">
                    @if(page.getErrors().get("name") != null)
                        <div class="text-danger">${page.getErrors().get("name").getFirst().getMessage()}</div>
                    @endif
                </div>

                <div class="mb-3">
                    <label for="body" class="form-label">Текст поста</label>
                    <textarea class="form-control" id="body" name="body">${page.getBody()}</textarea>
                    @if(page.getErrors().get("body") != null)
                        <div class="text-danger">${page.getErrors().get("body").getFirst().getMessage()}</div>
                    @endif
                </div>

                <button type="submit" class="btn btn-primary">Сохранить</button>
            </form>
        </div>
    </main>
`
)