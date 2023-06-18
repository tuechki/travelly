import {Component, AfterViewInit} from '@angular/core';
import * as L from 'leaflet';
@Component({
  selector: 'app-trip-map',
  templateUrl: './trip-map.component.html',
  styleUrls: ['./trip-map.component.css']
})
export class TripMapComponent implements AfterViewInit {
  private map: any;

  private initMap(): void {
    this.map = L.map('map', {
      center: [ 42.67446232748044, 23.33045300985507 ],
      zoom: 16
    });

    const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 18,
      minZoom: 3,
      attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    });

    tiles.addTo(this.map);
  }
  constructor() { }

  ngAfterViewInit(): void {
    this.initMap();
  }
}
