import { HttpClient, HttpEvent, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { abonnement } from 'src/app/models/Abonnement';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class abonnementService {
  private host = environment.apiUrl;

  constructor(private http: HttpClient) {}

  public retrieveAll(): Observable<any> {
    return this.http.get<abonnement[]>(`http://localhost:8089/daritn/abonnement/retrieveAll`);
  }

  public add(Abonnement:abonnement): Observable<abonnement> {
    return this.http.post<abonnement>(`http://localhost:8089/daritn/abonnement/add`, Abonnement);
  }

  public update(Abonnement:abonnement ): Observable<abonnement> {
    return this.http.put<abonnement>(`http://localhost:8089/daritn/abonnement/update`, Abonnement);
  }

  public delete(abonnement: number) {
    return this.http.put<abonnement>(`http://localhost:8089/daritn/abonnement/delete`, abonnement);
  }
}