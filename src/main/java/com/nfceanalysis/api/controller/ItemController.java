package com.nfceanalysis.api.controller;

import com.nfceanalysis.api.model.Item;
import com.nfceanalysis.api.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemsById(@PathVariable String id){
        return ResponseEntity.ok(itemService.getItemById(id));
    }

    @GetMapping("nfce/{nfceId}")
    public ResponseEntity<List<Item>> getItemsByNfceId(@PathVariable String nfceId){
        return ResponseEntity.ok(itemService.getItemByNfce(nfceId));
    }

    @PatchMapping
    public ResponseEntity<Item> patchItem(@RequestBody Item item){
        return ResponseEntity.ok(itemService.updateCategory(item));
    }

    @PatchMapping("/byitemcode")
    public ResponseEntity<Item> patchByItemCode(@RequestBody Item item){
        return ResponseEntity.ok(itemService.updateByItemCode(item));
    }



}
