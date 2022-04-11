package com.example.springbootex1.service;

import com.example.springbootex1.model.Store;
import com.example.springbootex1.repository.ProductRepository;
import com.example.springbootex1.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    StoreRepository storeRepository;

    @Autowired
    public StoreService(final StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public void create(final Store store) {
        storeRepository.save(store);
    }

    public void createStore(final Store store) {
        storeRepository.save(store);
    }

    public Store get(int id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Store with id: " + id +" Not found"));
    }

    public Store getStore(final int id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Store with id: " + id +" Not found"));
    }

    public void delete(final int id) {
        storeRepository.deleteById(id);
    }

    public void updateName(final int id,final String name) {
        final Store existingStore = get(id);
        existingStore.setName(name);
        storeRepository.save(existingStore);
    }
}