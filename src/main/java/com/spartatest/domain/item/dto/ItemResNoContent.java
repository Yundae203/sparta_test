package com.spartatest.domain.item.dto;

import com.spartatest.domain.item.entity.Item;

public record ItemResNoContent(Long id, String username, String title, int price) {

    public static ItemResNoContent fromItem(Item item) {
        return new ItemResNoContent(item.getId(), item.getUsername(), item.getTitle(), item.getPrice());
    }
}
