import { HttpClient, HttpEvent, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reclamation } from 'src/app/models/Reclamation';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ReclamationService {
  private host = environment.apiUrl;

  constructor(private http: HttpClient) {}

  public getReclamations() {
    return this.http.get<Reclamation[]>(`${this.host}/all`, {observe: 'response'});
  }

  public addReclamation(reclamation:Reclamation): Observable<Reclamation> {
    return this.http.post<Reclamation>(`${this.host}/add`, reclamation);
  }

  public updateReclamation(reclamation:Reclamation): Observable<Reclamation> {
    return this.http.put<Reclamation>(`${this.host}/update`, reclamation);
  }

  public deleteReclamation(reclamation: number) {
    return this.http.delete<number>(`${this.host}/delete/${reclamation}`);
  }
}