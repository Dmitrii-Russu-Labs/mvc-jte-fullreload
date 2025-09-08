@param com.example.mvc_jte_fullreload.item.entity.Item item

<h2>Подтвердите удаление</h2>

Удалить Задание - «${item.getId()}. ${item.getName()}»?

<hr>
<h2>Вернуться к заданию</h2>
<a href="/searchById?id=${item.getId()}">Вернуться к заданию</a>
<form action="/searchById" method="get" style="display:inline;">
    <input type="hidden" name="id" value="${item.getId()}" />
    <button type="submit">Вернуться к заданию</button>
</form>

<hr>
<h2>Удалить</h2>
<form action="/items/${item.getId()}/delete" method="post">
    <button type="submit">Удалить</button>
</form>
<hr>