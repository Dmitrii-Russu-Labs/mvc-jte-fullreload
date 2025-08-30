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

    @GetMapping("/all")
    public String showAllItems(Model model) {
        List<Item> items = service.findAll();
        model.addAttribute("items", items);
        return "item/list";
    }

    @GetMapping("/searchById")
    public String processSearchById(
            @RequestParam("id") Long id,
            Model model
    ) {
        Item item = service.findById(id);
        model.addAttribute("item", item);
        return "item/item-details";
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
        return "item/item-search-results";
    }

}
