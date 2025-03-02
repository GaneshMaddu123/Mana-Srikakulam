package com.srikakulam.service;

import java.util.List;

import com.srikakulam.model.Kothuru;

public interface PlaceService {
    List<Kothuru> getAllPlaces();
    List<Kothuru> getPlacesByCategory(String category);
    Kothuru getPlaceById(Long id);
    Kothuru saveKothuru(Kothuru kothuru);
    Kothuru updateById(Long id, Kothuru updatedData);
    void deletePlaceById(Long id);
}
