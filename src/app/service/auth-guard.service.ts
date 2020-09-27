import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { LoginServiceService } from './login-service.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGaurdService implements CanActivate {

  constructor(private router: Router,
    private authService: LoginServiceService) { }

// This method checks if the link can be activated based on the status of the user if he is logged in or not.

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    console.log("Request is getting processed in authservice")
    if (this.authService.isUserLoggedIn())
    {
     
      return true;
    }

    this.router.navigate(['login']);
    return false;

  }


}