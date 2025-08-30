@import com.example.mvc_jte_fullreload.entity.Item
@import java.util.List
@param List<Item> items

<h2>Все задачи</h2>

<ul>
    @for(Item i : items)
        <li>
            ${i.getId()} — ${i.getName()}
        </li>
    @endfor
</ul>

<hr>
<a href="/">ToMainPage</a>
<form action="/" method="get" style="display: inline;">
    <button type="submit">ToMainPage</button>
</form>
<hr>