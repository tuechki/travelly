package com.sofia.uni.fmi.travelly.service;

import com.sofia.uni.fmi.travelly.dto.ItemDto;
import com.sofia.uni.fmi.travelly.mapper.ItemMapper;
import com.sofia.uni.fmi.travelly.model.Item;
import com.sofia.uni.fmi.travelly.repository.ItemRepository;
import com.sofia.uni.fmi.travelly.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final TripRepository tripRepository;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper, TripRepository tripRepository) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.tripRepository = tripRepository;
    }

    public List<Item> getItemsByTripId(Long tripId) {
        return itemRepository.findAllByTrip(tripRepository.findById(tripId).get());
    }


    public Long addItem(ItemDto itemDto, Long tripId) {
        Item newItem = itemMapper.toEntity(itemDto);
        newItem.setId(tripId);
        Item savedItem = itemRepository.save(newItem);

        return savedItem.getId();
    }

    public void deleteAllItems(Long tripId) {
        itemRepository.deleteAllByTrip(tripRepository.findById(tripId).get());
    }

    public Item updateItem(Item item) {
        return itemRepository.save(item);
    }

    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
