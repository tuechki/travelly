package com.sofia.uni.fmi.travelly.mapper;

import com.sofia.uni.fmi.travelly.dto.ItemCreateUpdateDto;
import com.sofia.uni.fmi.travelly.dto.ItemDto;
import com.sofia.uni.fmi.travelly.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    public ItemDto toDto(Item item) {
        return ItemDto.builder()
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
                .name(itemDto.getName())
                .description(itemDto.getDescription())
                .amount(itemDto.getAmount())
                .isPacked(itemDto.isPacked())
                .build();
    }

    public ItemCreateUpdateDto toItemCreateDto(Item item) {
        return ItemCreateUpdateDto.builder()
                .name(item.getName())
                .description(item.getDescription())
                .amount(item.getAmount())
                .isPacked(item.isPacked())
                .build();
    }

    public Item toEntity(ItemCreateUpdateDto itemCreateUpdateDto) {
        return Item.builder()
                .name(itemCreateUpdateDto.getName())
                .description(itemCreateUpdateDto.getDescription())
                .amount(itemCreateUpdateDto.getAmount())
                .isPacked(itemCreateUpdateDto.isPacked())
                .build();
    }
}
