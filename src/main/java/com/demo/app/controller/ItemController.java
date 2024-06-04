package com.demo.app.controller;

import com.demo.app.dto.ItemDTO;
import com.demo.app.model.Item;
import com.demo.app.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{itemId}")
    public Item getItemById(@PathVariable int itemId) {
        return itemService.getItemById(itemId);
    }

    @PostMapping
    public void addItem(@RequestBody ItemDTO itemDTO) {
        itemService.addItem(itemDTO);
    }
}