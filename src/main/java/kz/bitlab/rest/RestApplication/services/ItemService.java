package kz.bitlab.rest.RestApplication.services;

import kz.bitlab.rest.RestApplication.dto.ItemDto;
import kz.bitlab.rest.RestApplication.entities.Item;

import java.util.List;

public interface ItemService {
    ItemDto addItem(ItemDto itemDto);
    List<ItemDto> getAllItems();
    ItemDto updateItem(ItemDto updItemDto);
    void deleteItem(Long id);
}
