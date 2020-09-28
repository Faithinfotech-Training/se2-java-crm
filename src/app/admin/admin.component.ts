import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private router:Router,private toastrService:ToastrService) { }
 
 
  ngOnInit(): void {
    
  }

  // Logout of admin

  logOut() {

    console.log("Check");

    //Remove the user from session 
    sessionStorage.removeItem('username');

// Toast message for successful log out
this.toastrService.success('Success','Logged out successfully');

    //Adding delay of 500ms
    setTimeout(() => 
{
    this.router.navigate(['']);
},
800);
   
  }

}
