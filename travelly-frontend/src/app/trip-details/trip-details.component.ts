import { Component } from '@angular/core';

@Component({
  selector: 'app-trip-details',
  templateUrl: './trip-details.component.html',
  styleUrls: ['./trip-details.component.css']
})
export class TripDetailsComponent {
  constructor(
    public Name: String,
    public Destination: String,
    public StartDate: Date,
    public EndDAte: Date,
    public Budget: Number,
    public Interests: Set<String>,
    public Items: Array<any>,
    public Users: Set<any>
  )
  {}
}
