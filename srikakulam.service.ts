import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Place {
  id: number;
  name: string;
  category: string;
  imageUrl: string; 
  description: string;
  address: string;
}

@Injectable({
  providedIn: 'root'
})
export class KothuruService {

  constructor(private hc: HttpClient) {}

  getPlaces(): Observable<Place[]> {
    return this.hc.get<Place[]>('http://localhost:8081/api/places');
  }
}
