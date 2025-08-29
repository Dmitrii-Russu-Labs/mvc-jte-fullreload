@param String error
@param String message
@param com.example.mvc_jte_fullreload.entity.Item item

<h2>Main page</h2>

<h2>Поиск задачи по имени</h2>
<form action="/searchByName" method="get">
    <label for="name">Name:</label>
    <input id="name" type="text" name="name"/>
    <button type="submit">Найти</button>
</form>

<h2>Поиск задачи по ID</h2>
<form action="/search" method="get">
    <label for="id">ID:</label>
    <input id="id" type="number" name="id"/>
    <button type="submit">Найти</button>
</form>

@if (error != null) <p style="color: red;">${error}</p> @endif
@if (message != null)<p style="color: green;">${message}</p>@endif

<h2>Посмотреть все задачи</h2>

<hr>
<a href="/all">Посмотреть все задачи</a>
<form action="/all" method="get" style="display: inline;">
    <button type="submit">Посмотреть все задачи</button>
</form>
<hr>

<h2>Создать новую задачу</h2>

<hr>
<a href="/new">Создать новую задачу!</a>
<form action="/new" method="get" style="display: inline;">
    <button type="submit">Создать новую задачу</button>
</form>
<hr>