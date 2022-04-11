package com.example.springbootex1.controller;

import com.example.springbootex1.model.Section;
import com.example.springbootex1.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        path = "/section"
)
public class SectionController {


    SectionService sectionService;

    @Autowired
    public SectionController(final SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @PostMapping("/createSection")
    @Secured({"admin" , "manager"})
    public ResponseEntity<?> create(@RequestParam("section") Section section) {
        sectionService.createSection(section);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/getSection")
    @Secured({"admin" , "manager"})
    public Section getSection(@RequestParam("sectionId") int sectionId) {
        return sectionService.getSection(sectionId);
    }

    @PutMapping("/updateName")
    @Secured({"admin" , "manager"})
    public ResponseEntity<?> updateName(@RequestParam("sectionId") int sectionId, @RequestParam("name")  String name) {
        sectionService.updateName(sectionId, name);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @Secured({"admin" , "manager"})
    public ResponseEntity<?> delete(@RequestParam("sectionId") int id) {
        sectionService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}