package com.spartatest.domain.item.dto;

import com.spartatest.domain.item.entity.Item;

public record ItemRequest(String username, String title, String content, Integer price) {

    public Item toDomain() {
        return Item.builder()
                .username(username)
                .title(title)
                .content(content)
                .price(price)
                .build();
    }
}
