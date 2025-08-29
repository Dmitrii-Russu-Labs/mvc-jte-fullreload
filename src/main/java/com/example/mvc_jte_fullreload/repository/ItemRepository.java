package com.example.mvc_jte_fullreload.repository;

import com.example.mvc_jte_fullreload.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByNameStartingWithIgnoreCase(String name);
}
