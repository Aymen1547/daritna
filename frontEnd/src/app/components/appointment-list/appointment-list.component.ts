import { Component, OnInit } from '@angular/core';
import { Appointment } from '../../models/appointment';
import { Router } from '@angular/router';
import { AppointmentService } from '../../services/appointment.service';

@Component({
  selector: 'app-appointment-list',
  templateUrl: './appointment-list.component.html',
  styleUrls: ['./appointment-list.component.css']
})
export class AppointmentListComponent implements OnInit {


  appointments!: Appointment[];
  constructor( private appointmentService: AppointmentService, private router: Router ) { }

  ngOnInit(): void {
    this.getAppointments();
  }
  getAppointments() {
    this.appointmentService.getAppointmentsList().subscribe(data => {
      this.appointments = data;
    });
  }

  deleteAppointment(id_rdv: number){
    this.appointmentService.deleteAppointment(id_rdv).subscribe( data => {
      console.log(data);
      this.getAppointments();
    })
  }

}
