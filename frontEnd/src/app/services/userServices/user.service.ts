import { HttpClient, HttpEvent, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/models/User';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private host = environment.apiUrl;

  constructor(private http: HttpClient) {}

  public getUsers() {
    return this.http.get<User[]>(`${this.host}/user/get`, {observe: 'response'});
  }

  public addUser(user:User): Observable<User> {
    return this.http.post<User>(`${this.host}/user/register`, user);
  }

  public updateUser(user: User): Observable<User> {
    return this.http.put<User>(`${this.host}/user/update`, user);
  }

  public changePassword(id:number,changepassword: String) {
    return this.http.post(`${this.host}/user/changepassword/${id}`, changepassword, {responseType: 'text'});
  }

  public deleteUser(user: number) {
    return this.http.delete<number>(`${this.host}/user/delete/${user}`);
  }
}
