import { Component, OnInit } from '@angular/core';
import { LoginServiceService} from 'src/app/service/login-service.service';
import { LoginresponseModule } from './loginresponse/loginresponse.module';
import {Router} from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor( public service:LoginServiceService,private router:Router) { }
  username:string;
  password:string;
  invalidLogin = false
 usernameCheck:string;
 role:string;
success:boolean;
showErrorMessage:boolean;
  ngOnInit(): void {
   
  }
  
  apiResponse:LoginresponseModule;
  val:any;
 

 checkLogin()
  {
    this.showErrorMessage=false;
     // this.router.navigate(['admin'])
    console.log(this.username+this.password);
    this.val={
      username:this.username,
      password:this.password
    }
    this.service.login(this.val).subscribe((res:LoginresponseModule)=>
    {
      console.log("check")
      this.apiResponse=res;
    this.role= res.role
    this.success=res.success

       if(this.success==false)
       {
           console.log("Not successful");
          // return true;
          this.invalidLogin = true
       
          this.showErrorMessage=true;
          this.router.navigate(['login'])
       }
       else 
       {
           if(this.role=="manager")
           {
             console.log("Manager");
        sessionStorage.setItem('username',this.username)
        this.router.navigate(['manager'])
        this.invalidLogin = false
    //    return true;
           }
           else if(this.role=="admin")
           {
            console.log("Admin");
            sessionStorage.setItem('username',this.username)
            this.router.navigate(['admin'])
            this.invalidLogin = false
     //  return true;
          //  this.router.navigate(['localhost:4200/admin']);
           }
       }
    })
  
  }
  }
  

