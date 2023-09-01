package com.sofia.uni.fmi.travelly.mapper;

import com.sofia.uni.fmi.travelly.dto.ItemCreateDto;
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

    public ItemCreateDto toItemCreateDto(Item item) {
        return ItemCreateDto.builder()
                .id(item.getId())
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

    public Item toEntity(ItemCreateDto itemCreateDto) {
        return Item.builder()
                .id(itemCreateDto.getId())
                .name(itemCreateDto.getName())
                .description(itemCreateDto.getDescription())
                .amount(itemCreateDto.getAmount())
                .isPacked(itemCreateDto.isPacked())
                .build();
    }
}
