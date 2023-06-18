import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-trip-list',
  templateUrl: './trip-list.component.html',
  styleUrls: ['./trip-list.component.css']
})
export class TripListComponent {
  trips: any[] = [];

  constructor(private http: HttpClient) {
    this.getTrips();
  }

  getTrips(): void {
    this.http
      .get<any>("someurl")
      .subscribe((response: any) => {
        this.trips = response.Search;
        console.log(this.trips);
      })
  }
}
