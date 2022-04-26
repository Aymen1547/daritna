import { HttpClient, HttpEvent, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Location } from 'src/app/models/Location';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LocationService {
  private host = environment.apiUrl;

  constructor(private http: HttpClient) {}

  public getLocations() {
    return this.http.get<Location[]>(`${this.host}/Locations`, {observe: 'response'});
  }

  public addLocation(location:Location): Observable<Location> {
    return this.http.post<Location>(`${this.host}/addLocation`, location);
  }

  public updateLocation(location: Location): Observable<Location> {
    return this.http.put<Location>(`${this.host}/updateLocation`, location);
  }

  public deleteLocation(location: number) {
    return this.http.delete<number>(`${this.host}/deleteLocation/${location}`);
  }
}