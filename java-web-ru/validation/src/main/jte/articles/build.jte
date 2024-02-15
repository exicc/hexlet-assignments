@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page


@template.layout.page(
content = @`
    <style>
        .custom-form {
            max-width: 400px;
            margin: 0 auto;
        }

        .custom-form .mb-3 {
            margin-bottom: 10px;
        }
    </style>
    @if(page.getErrors() != null)
        <div class="alert alert-danger">
            <ul>
                @for(var validator : page.getErrors().values())
                    @for(var error : validator)
                        <li>${error.getMessage()}</li>
                    @endfor
                @endfor
            </ul>
        </div>
    @endif

    <form action="/articles" method="post" class="custom-form mt-4">
        <div class="mb-3">
            <label for="title" class="form-label">Название</label>
            <input type="text" name="title" class="form-control" id="title" value="${page.getTitle()}" />
        </div>
        <div class="mb-3">
            <label for="content" class="form-label">Содержимое</label>
            <textarea name="content" class="form-control" id="content">${page.getContent()}</textarea>
        </div>

        <button type="submit" class="btn btn-primary">Добавить</button>
    </form>
`
)