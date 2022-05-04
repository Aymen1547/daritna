import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from './services/userServices/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontEnd';
  public term : string
  public isTokenThere : boolean
constructor(private router: Router, private authService:AuthenticationService){

  console.log("Token:  " + localStorage.getItem('token'));
  this.isTokenThere = localStorage.getItem('token') != null
}



  public isAdmin(){
    if (!this.authService.isUserLoggedIn()) {
      return false
    } else {
      return this.authService.isAdmin;
    }
    
  }
  public search() {
    this.router.navigate(["/shop", this.term]).then(() => window.location.reload())
}
}

