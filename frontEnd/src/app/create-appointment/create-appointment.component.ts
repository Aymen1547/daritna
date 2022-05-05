import { Component, OnInit } from '@angular/core';
import { Appointment } from '../appointment';
import { AppointmentService } from '../appointment.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-appointment',
  templateUrl: './create-appointment.component.html',
  styleUrls: ['./create-appointment.component.css']
})
export class CreateAppointmentComponent implements OnInit {

  appointments: Appointment=new Appointment();
  constructor( private appointmentService: AppointmentService, private router: Router) { }

  ngOnInit(): void {
  }
  saveAppointment(){
    this.appointmentService.createAppointment(this.appointments).subscribe( data =>{
      console.log(data);
      this.goToAppointmentList();
    },
    error => console.log(error));
  }

  goToAppointmentList(){
    this.router.navigate(['/appointments']);
  }


  onSubmit(){
    console.log(this.appointments);
    this.saveAppointment();
    
  }

}
