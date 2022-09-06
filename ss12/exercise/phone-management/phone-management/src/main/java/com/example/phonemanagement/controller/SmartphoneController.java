package com.example.phonemanagement.controller;

import com.example.phonemanagement.model.Smartphone;
import com.example.phonemanagement.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @GetMapping("/list")
    public ResponseEntity<Page<Smartphone>> getAllSmartphonePage(@PageableDefault Pageable pageable) {
        Page<Smartphone> smartphonePage = this.smartphoneService.findAll(pageable);
        if (!smartphonePage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartphonePage, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Void> createNew(@RequestBody Smartphone smartphone){
        this.smartphoneService.save(smartphone);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/updateForm/{id}")
    public ResponseEntity<Smartphone> updateForm(@PathVariable Long id){
        return new ResponseEntity<>(this.smartphoneService.findById(id), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Smartphone smartphone = smartphoneService.findById(id);
        if (smartphone == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphone, HttpStatus.NO_CONTENT);
    }
}
