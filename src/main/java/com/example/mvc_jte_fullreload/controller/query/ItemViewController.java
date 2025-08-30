package com.example.mvc_jte_fullreload.controller.query;

import com.example.mvc_jte_fullreload.entity.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.mvc_jte_fullreload.service.ItemService;

@Controller
@RequestMapping({"", "/", "/items"})
public class ItemViewController {

    private final ItemService service;

    public ItemViewController(ItemService service) {
        this.service = service;
    }

    @GetMapping
    public String showSearchForm(
            @ModelAttribute("error") String error,
            @ModelAttribute("message") String message,
            Model model
    ) {
        model.addAttribute("error", error);
        model.addAttribute("message", message);
        return "search"; // Main page
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("item", new Item());
        return "create";
    }

    @GetMapping("/{id}/edit")
    public String showUpdateForm(
            Model model, @PathVariable( value = "id") long id
    ) {
        Item item = service.findById(id);
        model.addAttribute("item", item);
        return "update";
    }

    @GetMapping("/{id}/delete")
    public String showDeleteConfirmationForm(@PathVariable Long id, Model model) {
        Item item = service.findById(id);
        model.addAttribute("item", item);
        return "delete";
    }

}
