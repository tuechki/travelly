package com.sofia.uni.fmi.travelly.mapper;

import com.sofia.uni.fmi.travelly.dto.ItemDto;
import com.sofia.uni.fmi.travelly.model.Item;

public class ItemMapper {
    public ItemDto toDto(Item item) {
        return ItemDto.builder()
                .id(item.getId())
                .trip(item.getTrip())
                .name(item.getName())
                .desc(item.getDesc())
                .amount(item.getAmount())
                .isPacked(item.getIsPacked())
                .build();
    }

    public Item toEntity(ItemDto itemDto) {
        return Item.builder()
                .id(itemDto.getId())
                .trip(itemDto.getTrip())
                .name(itemDto.getName())
                .desc(itemDto.getDesc())
                .amount(itemDto.getAmount())
                .isPacked(itemDto.getIsPacked())
                .build();
    }
}
