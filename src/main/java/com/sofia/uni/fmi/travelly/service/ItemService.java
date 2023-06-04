package com.sofia.uni.fmi.travelly.service;

import com.sofia.uni.fmi.travelly.dto.ItemDto;
import com.sofia.uni.fmi.travelly.model.Item;
import com.sofia.uni.fmi.travelly.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item updateItem(Item item) {
        Item savedItem = itemRepository.save(item);
        return savedItem;
    }

    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
