package com.sofia.uni.fmi.travelly.mapper;

import com.sofia.uni.fmi.travelly.dto.ItemDto;
import com.sofia.uni.fmi.travelly.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    public ItemDto toDto(Item item) {
        return ItemDto.builder()
                .id(item.getId())
                .trip(item.getTrip())
                .name(item.getName())
                .description(item.getDescription())
                .amount(item.getAmount())
                .isPacked(item.isPacked())
                .build();
    }

    public Item toEntity(ItemDto itemDto) {
        return Item.builder()
                .id(itemDto.getId())
                .trip(itemDto.getTrip())
                .name(itemDto.getName())
                .description(itemDto.getDescription())
                .amount(itemDto.getAmount())
                .isPacked(itemDto.isPacked())
                .build();
    }
}
