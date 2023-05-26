package com.sofia.uni.fmi.travelly.controller;

import com.sofia.uni.fmi.travelly.dto.ItemDto;
import com.sofia.uni.fmi.travelly.mapper.ItemMapper;
import com.sofia.uni.fmi.travelly.model.Item;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("items")
public class ItemController {
    private ItemService itemService;
    private ItemMapper itemMapper;

    public ItemController(ItemService itemService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

    @PutMapping("{itemId}")
    public Item updateItemById(@RequestParam Long itemId, @RequestBody ItemDto itemDto) {
        Item item = itemMapper.toEntity(itemDto);
        return itemService.updateItemById(itemId, item);
    }

    @DeleteMapping("{itemId}")
    public void deleteItemById(@RequestParam Long itemId) {
        itemService.deleteItemById(itemId);
    }
}
