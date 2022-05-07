import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { routes } from './Routing';
import { LocationDashboardComponent } from './components/locationsManagement/location-dashboard/location-dashboard.component';
import { ReclamationDashboardComponent } from './components/reclamationsManagement/reclamation-dashboard/reclamation-dashboard.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    LocationDashboardComponent,
    ReclamationDashboardComponent,
    
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
