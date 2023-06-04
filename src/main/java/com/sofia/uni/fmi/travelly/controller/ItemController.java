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
    public ItemDto updateItem(@RequestParam Long itemId, @RequestBody ItemDto itemDto) {
        Item item = itemMapper.toEntity(itemDto);
        item.setId(itemId);
        Item updatedItem = itemService.updateItemById(itemId, item);
        ItemDto updatedItemDto = itemMapper.toDto(updatedItem);

        return updatedItemDto;
    }

    @DeleteMapping("{itemId}")
    public void deleteItem(@RequestParam Long itemId) {
        itemService.deleteItemById(itemId);
    }
}
