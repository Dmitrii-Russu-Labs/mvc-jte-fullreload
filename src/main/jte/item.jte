@param String message
@param com.example.mvc_jte_fullreload.entity.Item item

<h2>Задача</h2>

@if (message != null) <p>${message}</p> @endif

<p>
    <strong>ID:</strong> ${item.getId()}
    <strong>Name:</strong> ${item.getName()}
</p>

<h2>Обновить</h2>
<hr>
<a href="/items/${item.getId()}/edit">Обновить</a>
<form action="/items/${item.getId()}/edit" method="get" style="display: inline;">
    <button type="submit">Обновить</button>
</form>
<hr>

<h2>Удалить!</h2>
<hr>
<a href="/items/${item.getId()}/delete">Удалить!</a>
<form action="/items/${item.getId()}/delete" method="get" style="display: inline;">
    <button type="submit">Удалить!</button>
</form>
<hr>

<h2>Вернуться на главную страницу</h2>
<hr>
<a href="/">Вернуться на главную страницу</a>
<form action="/" method="get" style="display: inline;">
    <button type="submit">Вернуться на главную страницу</button>
</form>
<hr>