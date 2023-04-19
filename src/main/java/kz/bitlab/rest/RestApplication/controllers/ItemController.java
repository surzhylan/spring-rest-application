package kz.bitlab.rest.RestApplication.controllers;

import kz.bitlab.rest.RestApplication.dto.ItemDto;
import kz.bitlab.rest.RestApplication.entities.Item;
import kz.bitlab.rest.RestApplication.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/item")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @GetMapping
    public List<ItemDto> getAllItems(){
        return itemService.getAllItems();
    }
    @PostMapping
    public ItemDto addItem(@RequestBody ItemDto itemDto){
        return itemService.addItem(itemDto);
    }
    @PutMapping
    public ItemDto updateItem(@RequestBody ItemDto itemDto){
        return itemService.updateItem(itemDto);
    }
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable(name = "id") Long id){
        itemService.deleteItem(id);
    }
}
