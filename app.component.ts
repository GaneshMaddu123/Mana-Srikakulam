import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common'; 
import { NgIf, NgFor } from '@angular/common';

interface Place {
  name: string;
  category: string;
  imageUrl: string;
  description: string;
  address: string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  standalone: true,
  
  imports: [CommonModule, NgIf, NgFor],
})
export class AppComponent implements OnInit {
  menuActive = false;
  selectedCategory: string | null = null;
  categories: string[] = ["Beaches", "Parks", "Temples"];
  places: Place[] = [];
  filteredPlaces: Place[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.loadPlaces();
  }

  loadPlaces() {
    this.http.get<Place[]>('http://localhost:8081/api/places').subscribe(
      (data) => {
        this.places = data;
        console.log("Fetched places:", this.places); 
      },
      (error) => {
        console.error('Error fetching places:', error);
      }
    );
  }
  

  toggleMenu() {
    this.menuActive = !this.menuActive;
  }

  showPlaces(category: string) {
    console.log("Selected category:", category); 
  
    const categoryMapping: { [key: string]: string } = {
      "Beaches": "Beach",
      "Parks": "Park",
      "Temples": "Temple"
    };
  
    const mappedCategory = categoryMapping[category] || category;
  
    this.selectedCategory = category;
    this.filteredPlaces = this.places.filter(place => {
      console.log(`Checking place: ${place.name}, category: ${place.category}`); 
      return place.category.trim().toLowerCase() === mappedCategory.trim().toLowerCase();
    });
  
    console.log("Filtered places:", this.filteredPlaces); 
  }
  
  
}
