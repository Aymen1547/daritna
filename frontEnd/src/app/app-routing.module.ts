import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppointmentListComponent } from './appointment-list/appointment-list.component';
import { CreateAppointmentComponent } from './create-appointment/create-appointment.component';

const routes: Routes = [
    {path: 'appointments', component: AppointmentListComponent},
    {path: 'create-appointment', component: CreateAppointmentComponent},
    {path: '', redirectTo: 'appointments', pathMatch: 'full'},
];


@NgModule({
    imports: [RouterModule.forRoot(routes)],                                                                                                                                                                                                                                                                                                          
    exports: [RouterModule]
  })
  export class AppRoutingModule { }