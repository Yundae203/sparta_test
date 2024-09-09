package com.spartatest.domain.item.entity;

import com.spartatest.domain.item.dto.ItemRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long id;

    private String username;

    private String title;

    private String content;

    private int price;

    private Item(Builder builder) {
        this.username = builder.username;
        this.title = builder.title;
        this.content = builder.content;
        this.price = builder.price;
    }

    // Builder [s]
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String username;
        private String title;
        private String content;
        private int price;

        public Builder username(String username) {
            this.username = username;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder content(String content) {
            this.content = content;
            return this;
        }
        public Builder price(int price) {
            validatePrice(price);
            this.price = price;
            return this;
        }
        public Item build() {
            return new Item(this);
        }
    }
    // Builder [e]

    // convenience [s]
    public void updateFromRequest(ItemRequest request) {
        if (isNotNull(request.username())) {
            username = request.username();
        }
        if (isNotNull(request.title())) {
            title = request.title();
        }
        if (isNotNull(request.content())) {
            content = request.content();
        }
        if (isNotNull(request.price())) {
            validatePrice(request.price());
            price = request.price();
        }
    }
    // convenience [e]

    // validate [s]
    private static boolean isNotNull(Object ogj) {
        return ogj != null;
    }

    private static void validatePrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must be a positive number");
        }
    }
    // validate [e]
}
