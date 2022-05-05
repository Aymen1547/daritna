import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { routes } from './Routing';
import { AppointmentListComponent } from './appointment-list/appointment-list.component';
import { AppRoutingModule } from './app-routing.module';
import { CreateAppointmentComponent } from './create-appointment/create-appointment.component';
//import { AppointmentComponent } from './appointment/appointment.component';

@NgModule({
  declarations: [
    AppComponent,
    AppointmentListComponent,
    CreateAppointmentComponent,
   // AppointmentComponent,
    
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
