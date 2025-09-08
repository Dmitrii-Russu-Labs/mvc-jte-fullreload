package com.example.mvc_jte_fullreload.item.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
import com.example.mvc_jte_fullreload.item.entity.Item;
import com.example.mvc_jte_fullreload.item.repository.ItemRepository;

@Service
public class ItemService {

    private ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public Item findById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Item> findAll() {
        return repository.findAll();
    }

    public Item saveOrUpdate(Item item) {
        return repository.save(item);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    // Новый метод поиска по имени
    public List<Item> searchByName(String name) {
        return repository.findByNameStartingWithIgnoreCase(name);
    }

}
