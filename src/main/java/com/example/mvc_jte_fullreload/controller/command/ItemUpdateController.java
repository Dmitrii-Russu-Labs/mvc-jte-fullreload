package com.example.mvc_jte_fullreload.controller.command;

import com.example.mvc_jte_fullreload.entity.Item;
import com.example.mvc_jte_fullreload.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/items")
class ItemUpdateController {

    private ItemService service;
    public ItemUpdateController(ItemService service) {
        this.service = service;
    }

    @PostMapping("/{id}")
    public String update(
            @PathVariable Long id,
            @ModelAttribute Item item,           // подхватит поля id и name
            RedirectAttributes redirectAttributes
    ) {
        item.setId(id);                        // на всякий случай
        service.saveOrUpdate(item);                    // или service.update(item)
        redirectAttributes.addFlashAttribute(
                "message", "Задача #" + id + " успешно обновлена"
        );
        // перенаправляем на страницу просмотра
        return "redirect:/items/search?id=" + id;
    }

}