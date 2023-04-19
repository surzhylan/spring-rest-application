package kz.bitlab.rest.RestApplication.services.impl;

import kz.bitlab.rest.RestApplication.dto.ItemDto;
import kz.bitlab.rest.RestApplication.entities.Item;
import kz.bitlab.rest.RestApplication.repositories.ItemRepository;
import kz.bitlab.rest.RestApplication.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public ItemDto addItem(ItemDto itemDto) {
        return mapToDto(itemRepository.save(mapToEntity(itemDto)));
    }

    @Override
    public List<ItemDto> getAllItems() {
        List<Item> items = itemRepository.findAll();
        List<ItemDto> itemsDto = new ArrayList<>();
        for(Item i : items){
            itemsDto.add(mapToDto(i));
        }
        return itemsDto;
    }

    @Override
    public ItemDto updateItem(ItemDto updItemDto) {
        ItemDto itemDto = mapToDto(itemRepository.findAllById(mapToEntity(updItemDto).getId()));
        itemDto.setName(updItemDto.getName());
        itemDto.setPrice(updItemDto.getPrice());
        itemDto.setAmount(updItemDto.getAmount());
        return mapToDto(itemRepository.save(mapToEntity(itemDto)));
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public ItemDto mapToDto(Item item){
        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setName(item.getName());
        itemDto.setPrice(item.getPrice());
        itemDto.setAmount(item.getAmount());
        return itemDto;
    }

    public Item mapToEntity(ItemDto itemDto){
        Item item = new Item();
        item.setId(itemDto.getId());
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        item.setAmount(itemDto.getAmount());
        item.setPromocode(UUID.randomUUID().toString());
        return item;
    }
}
