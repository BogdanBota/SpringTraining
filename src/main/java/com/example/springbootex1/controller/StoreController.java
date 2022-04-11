package com.example.springbootex1.controller;

import com.example.springbootex1.model.Store;
import com.example.springbootex1.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        path = "/store"
)
public class StoreController {

    StoreService storeService;

    @Autowired
    public StoreController(final StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/createStore")
    @Secured({"admin" , "manager"})
    public ResponseEntity<?> create(@RequestParam("store") Store store) {
        storeService.createStore(store);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/getStore")
    @Secured({"admin" , "manager"})
    public Store getStore(@RequestParam("storeId") int storeId) {
        return storeService.getStore(storeId);
    }

    @PutMapping("/updateName")
    @Secured({"admin" , "manager"})
    public ResponseEntity<?> updateName(@RequestParam("storeId") int storeId, @RequestParam("name")  String name) {
        storeService.updateName(storeId, name);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @DeleteMapping("/delete")
    @Secured({"admin" , "manager"})
    public ResponseEntity<?> delete(@RequestParam("storeId") int storeId) {
        storeService.delete(storeId);
        return ResponseEntity.ok(HttpStatus.OK);
    }




}
