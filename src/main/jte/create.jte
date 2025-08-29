@param String error
@param com.example.mvc_jte_fullreload.entity.Item item

<h2>Создать новую задачу</h2>
<form action="/items" method="post">
    <label for="name">Содержание:</label>
    <input id="name" type="text" name="name"/>
    <button type="submit">Создать</button>
</form>

@if (error != null) <p>${error}</p> @endif

<a href="/items">Вернуться на главную страницу</a>