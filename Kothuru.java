package com.srikakulam.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Kothuru {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull(message="name should not be empty")
    @NotEmpty(message="name should not be empty")
    @Column
    private String name;
    
    @NotNull(message="category should not be empty")
    @NotEmpty(message="category should not be empty")
    @Column
    private String category;
    
    @Lob
    @Column(columnDefinition = "CLOB")
    private String imageUrl; 
    
    @Lob
    @Column(columnDefinition = "CLOB")
    private String description;

    @Column
    private String address;

    public Kothuru(
        @NotNull(message = "name should not be empty") @NotEmpty(message = "name should not be empty") String name,
        @NotNull(message = "category should not be empty") @NotEmpty(message = "category should not be empty") String category,
        String imageUrl, String description, String address) {
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.description = description;
        this.address = address;
    }

    public Kothuru() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Kothuru [id=" + id + ", name=" + name + ", category=" + category + 
               ", imageUrl=" + imageUrl + ", description=" + description + ", address=" + address + "]";
    }
}
