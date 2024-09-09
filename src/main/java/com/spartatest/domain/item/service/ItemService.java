package com.spartatest.domain.item.service;

import com.spartatest.domain.item.dto.ItemResNoContent;
import com.spartatest.domain.item.dto.ItemResponse;
import com.spartatest.domain.item.entity.Item;
import com.spartatest.domain.item.dto.ItemRequest;
import com.spartatest.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public ItemResponse save(ItemRequest dto) {
        Item item = itemRepository.save(dto.toDomain());
        return ItemResponse.fromItem(item);
    }

    public List<ItemResNoContent> findAll() {
        return itemRepository.findAll().stream().map(ItemResNoContent::fromItem).toList();
    }

    @Transactional
    public ItemResponse update(Long id, ItemRequest itemRequest) {
        Item item = findById(id);
        item.updateFromRequest(itemRequest);
        return ItemResponse.fromItem(item);
    }

    @Transactional
    public void delete(Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
        }
    }

    public Item findById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Can't find item with id " + id));
    }
}
