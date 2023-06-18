import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TripListComponent } from './trip-list/trip-list.component';
import { TripDetailsComponent } from './trip-details/trip-details.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { TripMapComponent } from './trip-map/trip-map.component';

@NgModule({
  declarations: [
    AppComponent,
    TripListComponent,
    TripDetailsComponent,
    UserDetailsComponent,
    TripMapComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
