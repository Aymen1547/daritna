import { Component } from '@angular/core';
import { AuthenticationService } from './services/userServices/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontEnd';
constructor(private authService:AuthenticationService){}

  public isAuth(){

    return this.authService.isUserLoggedIn();
  }
}
