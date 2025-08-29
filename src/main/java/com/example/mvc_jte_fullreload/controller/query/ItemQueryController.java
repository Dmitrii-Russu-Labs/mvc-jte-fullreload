package com.example.mvc_jte_fullreload.controller.query;

import java.util.List;
import org.springframework.ui.Model;
import com.example.mvc_jte_fullreload.entity.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.mvc_jte_fullreload.service.ItemService;

@Controller
@RequestMapping({"", "/", "/items"})
public class ItemQueryController {

    private ItemService service;

    public ItemQueryController(ItemService service) {
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
        return "search"; // стартовая страница
    }

	/*@GetMapping("/search")
	public String processSearchAll(
			@RequestParam("name") String name,
			Model model
	) {
		Item item = service.findById(id);
		model.addAttribute("item", item);
		return "item";
	}*/

    @GetMapping("/search")
    public String processSearch(
            @RequestParam("id") Long id,
            Model model
    ) {
        Item item = service.findById(id);
        model.addAttribute("item", item);
        return "item";
    }

    @GetMapping("/all")
    public String showAllItems(Model model) {
        List<Item> items = service.findAll();
        model.addAttribute("items", items);
        return "items";
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
        return "delete"; // JTE-шаблон подтверждения
    }

    @GetMapping("/searchByName")
    public String processSearchByName(
            @RequestParam("name") String name,
            Model model
    ) {
        List<Item> items;
        if (name == null || name.trim().isEmpty()) {
            items = service.findAll();
            model.addAttribute("searchTerm", "(все)");
        } else {
            items = service.searchByName(name);
            model.addAttribute("searchTerm", name);
        }
        model.addAttribute("items", items);
        return "items2"; // jte-шаблон, который выводит список
    }

}
