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

  constructor( public service:LoginServiceService,private router:Router,private toastrService:ToastrService) { }
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
 
// This method will check the username and password


 checkLogin()
  {
    this.showErrorMessage=false;
     // this.router.navigate(['admin'])
    console.log(this.username+this.password);
    this.val={
      username:this.username,
      password:this.password
    }

    // Getting the data from spring REST API

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

    // Checking if manager or admin
       else 
       {
           if(this.role=="manager")
           {
             console.log("Manager");

             //Updating the session value
        sessionStorage.setItem('username',this.username)
        

         // Toast message for successful log in
    this.toastrService.success('Success','Logged in successfully as '+this.username);

    // Navigate to the manager dashboard page
    setTimeout(() => 
    {
        this.router.navigate(['manager']);
    },
    800);

        this.invalidLogin = false
  
           }

           else if(this.role=="admin")
           {
            console.log("Admin");

           // Updating the session value
            sessionStorage.setItem('username',this.username)


         // Toast message for successful log in
         this.toastrService.success('Success','Logged in successfully as '+this.username);

            // Navigate to the admin dashboard page
         
            setTimeout(() => 
            {
                this.router.navigate(['admin']);
            },
            800);

            this.invalidLogin = false
   
         
           }
       }
    })
  
  }
  }
  

