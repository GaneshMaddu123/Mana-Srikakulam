package com.srikakulam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srikakulam.model.Kothuru;

public interface PlaceRepository extends JpaRepository<Kothuru,Long> {
	List<Kothuru> findByCategory(String category);
}
