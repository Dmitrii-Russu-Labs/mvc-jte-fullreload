@import java.util.List
@import com.example.mvc_jte_fullreload.entity.Item

@param List<Item> items
@param String searchTerm

<h2>Результаты поиска по имени: "${searchTerm}"</h2>

@if (items.isEmpty()) <h2>Ничего не найдено.</h2>@endif
@for (Item i : items)
    <li>
        ID: ${i.getId()} — ${i.getName()}
        <a href="/items/search?id=${i.getId()}">Выбрать</a>&nbsp;
        <a href="/items/${i.getId()}/edit">Редактировать</a>&nbsp;
        <a href="/items/${i.getId()}/delete">Удалить</a>
    </li>
@endfor

