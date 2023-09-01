package com.sofia.uni.fmi.travelly.service;

import com.sofia.uni.fmi.travelly.dto.ItemCreateDto;
import com.sofia.uni.fmi.travelly.mapper.ItemMapper;
import com.sofia.uni.fmi.travelly.model.Item;
import com.sofia.uni.fmi.travelly.model.Trip;
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


    public Long addItem(ItemCreateDto itemCreateDto, Long tripId) {
        Item newItem = itemMapper.toEntity(itemCreateDto);
        Trip trip = tripRepository.findById(tripId).get();
        newItem.setTrip(trip);
        Item savedItem = itemRepository.save(newItem);

        return savedItem.getId();
    }

    public void deleteAllItems(Long tripId) {
        Trip trip = tripRepository.findById(tripId).get();
        itemRepository.deleteAllByTrip(trip);
    }

    public Item updateItem(Item item) {
        return itemRepository.save(item);
    }

    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
