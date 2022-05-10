import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Appointment } from '../models/appointment';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {
  private baseURL = "http://localhost:8080/api/v1/appointment";

  constructor(private httpClient: HttpClient) { }
  getAppointmentsList():Observable<Appointment[]>{
    return this.httpClient.get<Appointment[]>(`${this.baseURL}`);
  }

  createAppointment(appointments: Appointment): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, appointments);
  }


  deleteAppointment(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
