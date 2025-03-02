package com.srikakulam.service;

import com.srikakulam.model.Kothuru;
import com.srikakulam.repository.PlaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlaceServiceImpl implements PlaceService { // Implementing PlaceService

    @Autowired
    private PlaceRepository placeRepository;

    // Fetch all places
    @Override
    public List<Kothuru> getAllPlaces() {
        return placeRepository.findAll();
    }

    // Fetch places by category
    @Override
    public List<Kothuru> getPlacesByCategory(String category) {
        return placeRepository.findByCategory(category);
    }

    // Fetch place by ID
    @Override
    public Kothuru getPlaceById(Long id) {
        return placeRepository.findById(id).orElse(null);
    }

    // Save a new place
    @Override
    public Kothuru saveKothuru(Kothuru kothuru) {
        return placeRepository.save(kothuru);
    }

    // Update an existing place by ID
    @Override
    public Kothuru updateById(Long id, Kothuru updatedData) {
        Optional<Kothuru> existingPlaceOpt = placeRepository.findById(id);
        
        if (existingPlaceOpt.isPresent()) {
            Kothuru place = existingPlaceOpt.get(); 
            place.setName(updatedData.getName()); 
            place.setCategory(updatedData.getCategory());
            place.setDescription(updatedData.getDescription()); 
            place.setAddress(updatedData.getAddress());
            place.setImageUrl(updatedData.getImageUrl()); // Update images
            
            return placeRepository.save(place); 
        }
        return null;
    }

    // Delete a place by ID
    @Override
    public void deletePlaceById(Long id) {
        placeRepository.deleteById(id);
    }
}
