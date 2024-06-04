package com.demo.app.service;

import com.demo.app.dto.ItemDTO;
import com.demo.app.mapper.ItemMapper;
import com.demo.app.model.Category;
import com.demo.app.model.Item;
import com.demo.app.repository.CategoryRepository;
import com.demo.app.repository.ItemRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, CategoryRepository categoryRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
        this.itemMapper = itemMapper;
    }

    @Cacheable("items")
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(int itemId) {
        return itemRepository.findById(itemId);
    }

    public void addItem(ItemDTO itemDTO) {
        Category category = categoryRepository.findByName(itemDTO.categoryName());
        if (category == null) {
            throw new IllegalArgumentException("Category name does not exist.");
        }
        Item item = itemMapper.toItem(itemDTO);
        item.setCategoryId(category.getCategoryId());
        itemRepository.save(item);
    }
}