import { Injectable } from '@angular/core';
//import { Http2ServerRequest } from 'http2';
import {HttpClient} from "@angular/common/http";
import {Observable, observable} from "rxjs";
import { map, filter, catchError, mergeMap } from 'rxjs/operators';
import { LoginresponseModule } from '../login/loginresponse/loginresponse.module';

@Injectable({
  providedIn: 'root'
})

export class LoginServiceService {
  response:any;
  apiResponse:string;
 // public headers = new Headers({ 'Content-Type': 'application/text' });
  constructor(private http:HttpClient)
  { 
        
  }
  readonly APIUrl="http://localhost:8000/api";

   login(val:any):Observable<LoginresponseModule>
   {
     console.log(val);
    //this.response=this.http.post(this.APIUrl+'/login',val);
    //console.log(this.response);
  
       return this.http.post<LoginresponseModule>(this.APIUrl+'/login',val);
   }
   isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }
}
