package com.example.mvc_jte_fullreload.controller.command;

import org.springframework.stereotype.Controller;
import com.example.mvc_jte_fullreload.service.ItemService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/items")
class ItemDeleteController {

    private ItemService service;

    public ItemDeleteController(ItemService service) {
        this.service = service;
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        service.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Задание удалено!");
        return "redirect:/items"; // возврат на главную
    }
}
