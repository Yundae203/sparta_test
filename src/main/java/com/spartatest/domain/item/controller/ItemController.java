package com.spartatest.domain.item.controller;

import com.spartatest.domain.item.dto.ItemRequest;
import com.spartatest.domain.item.dto.ItemResNoContent;
import com.spartatest.domain.item.dto.ItemResponse;
import com.spartatest.common.dto.MessageResponse;
import com.spartatest.domain.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public List<ItemResNoContent> findAll() {
        return itemService.findAll();
    }

    @PostMapping
    public ItemResponse create(@RequestBody ItemRequest itemRequest) {
        return itemService.save(itemRequest);
    }

    @PutMapping("/{id}")
    public ItemResponse update(@PathVariable Long id, @RequestBody ItemRequest itemRequest) {
        return itemService.update(id, itemRequest);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        itemService.delete(id);
        return MessageResponse.deleteSuccess();
    }
}
