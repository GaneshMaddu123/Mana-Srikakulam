package com.srikakulam.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.srikakulam.model.Kothuru;
import com.srikakulam.service.PlaceService;

@RestController
@RequestMapping("/api/places")
@CrossOrigin(origins = "http://localhost:4200")
public class KothuruAPI {

    @Autowired
    private PlaceService placeService;

    // Get all places
    @GetMapping
    public ResponseEntity<List<Kothuru>> getAllPlaces() {
        List<Kothuru> places = placeService.getAllPlaces();
        return new ResponseEntity<>(places, HttpStatus.OK);
    }
    
    // Add a new place
    @PostMapping("/add")
    public ResponseEntity<Kothuru> saveKothuru(@RequestBody Kothuru kothuru) {
        Kothuru savedPlace = placeService.saveKothuru(kothuru);
        return new ResponseEntity<>(savedPlace, HttpStatus.CREATED);
    }

    // Get place by ID
    @GetMapping("/{id}")
    public ResponseEntity<Kothuru> getPlaceById(@PathVariable Long id) {
        Kothuru place = placeService.getPlaceById(id);
        return place != null ? new ResponseEntity<>(place, HttpStatus.OK)
                             : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Get places by category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Kothuru>> getPlacesByCategory(@PathVariable String category) {
        List<Kothuru> places = placeService.getPlacesByCategory(category);
        return new ResponseEntity<>(places, HttpStatus.OK);
    }
    
    // Update place by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Kothuru> updatePlaceById(@PathVariable Long id, @RequestBody Kothuru updatedData) {
        Kothuru updatedPlace = placeService.updateById(id, updatedData);
        return updatedPlace != null ? new ResponseEntity<>(updatedPlace, HttpStatus.OK)
                                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } 
    
    // Delete place by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id) {
        placeService.deletePlaceById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
