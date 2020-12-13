package com.rs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.model.Store;
import com.rs.service.StoreInfoService;

@RestController
@RequestMapping("/restaurent")
public class StoreService {
    @Autowired
    private StoreInfoService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String saveStoreInfo(@RequestBody Store store) {
        return service.saveStore(store);
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,path = "/{store-name}")
    public Store getStoreInfo(@PathVariable("store-name") String storeName) {
        return service.getStore(storeName);
    }
}