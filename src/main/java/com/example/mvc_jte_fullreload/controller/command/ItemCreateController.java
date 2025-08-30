package com.example.mvc_jte_fullreload.controller.command;

import jakarta.validation.Valid;
import com.example.mvc_jte_fullreload.entity.Item;
import org.springframework.stereotype.Controller;
import com.example.mvc_jte_fullreload.service.ItemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/items")
public class ItemCreateController {

    private ItemService service;

    public ItemCreateController(ItemService service) {
        this.service = service;
    }

    @PostMapping
    public String create(
            @Valid Item item,
            RedirectAttributes redirectAttributes
    ) {
        Item saved = service.saveOrUpdate(item);
        redirectAttributes.addFlashAttribute("message", "User information saved successfully!");
        return "redirect:/items/searchById?id=" + saved.getId();
    }
}
