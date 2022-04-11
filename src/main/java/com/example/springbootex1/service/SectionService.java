package com.example.springbootex1.service;

import com.example.springbootex1.model.Section;
import com.example.springbootex1.model.Store;
import com.example.springbootex1.repository.ProductRepository;
import com.example.springbootex1.repository.SectionRepository;
import com.example.springbootex1.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionService {

    SectionRepository sectionRepository;
    StoreRepository storeRepository;

    @Autowired
    public SectionService(final SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public void create(final Section section) {
        sectionRepository.save(section);
    }

    public void createSection( final Section section) {


        sectionRepository.save(section);
    }

    public Section get(int id) {
        return sectionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Section with id: " + id +" Not found"));
    }

    public Section getSection( final int id) {
        return sectionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Section with id: " + id +" Not found"));
    }

    public void delete(final int id) {
        sectionRepository.deleteById(id);
    }

    public void updateName(final int id,final String name) {

        final Section existingSection = get(id);
        existingSection.setName(name);
        sectionRepository.save(existingSection);
    }

    public void addSectionToStore( final  int id,final int storeId) {

        Store store = storeRepository.findById(storeId).orElseThrow(() -> new IllegalArgumentException(" "));
        Section section = sectionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(" "));
        section.setStore(store);
        sectionRepository.save(section);
    }


}