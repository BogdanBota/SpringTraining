package com.example.springbootex1.repository;

import com.example.springbootex1.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository  extends JpaRepository<Section, Integer> {
}