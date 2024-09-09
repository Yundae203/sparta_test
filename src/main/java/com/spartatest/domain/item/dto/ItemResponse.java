package com.spartatest.domain.item.dto;

import com.spartatest.domain.item.entity.Item;

public record ItemResponse(Long id, String username, String title, String content, int price) {

    public static ItemResponse fromItem(Item item) {
        return new ItemResponse(item.getId(), item.getUsername(), item.getTitle(), item.getContent(), item.getPrice());
    }
}
