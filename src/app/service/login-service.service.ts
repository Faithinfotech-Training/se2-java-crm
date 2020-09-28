// Service class to use for login


import { Injectable } from '@angular/core';
//import { Http2ServerRequest } from 'http2';
import {HttpClient} from "@angular/common/http";
import {Observable, observable} from "rxjs";
import { map, filter, catchError, mergeMap } from 'rxjs/operators';
import { LoginresponseModule } from '../login/loginresponse/loginresponse.module';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class LoginServiceService {
  response:any;
  apiResponse:string;

  constructor(private http:HttpClient)
  { 
        
  }
 // readonly APIUrl="http://localhost:8000/api";

// Login method  to connect with the backend

   login(val:any):Observable<LoginresponseModule>
   {
     console.log(val);
   
       return this.http.post<LoginresponseModule>(environment.API_URL+'/login',val);
   }

   // checking if the user is logged in 

   isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }

}
