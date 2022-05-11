import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../models/User';
import { AuthenticationService } from '../services/userServices/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthorizationGuard implements CanActivate {
  user: User;
  constructor(private router: Router,private authService: AuthenticationService) {
    this.user = this.authService.getUserFromLocalCache();
  }
  canActivate(

    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      const hasAuthority = this.user?.role.includes("USER_ADMIN");
      if (!hasAuthority) {
        this.router.navigateByUrl('/home');
        window.alert("You are not allowed to be here!!");
      }
      return hasAuthority;
    }
  }
  
