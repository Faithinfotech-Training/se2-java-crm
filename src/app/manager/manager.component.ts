import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {

  constructor(private router:Router,private toastrService:ToastrService) { }

  ngOnInit(): void {
  }
   
   logOut() {

    //Toast message for successful log out
   
    console.log("Check");
    sessionStorage.removeItem('username');
    this.toastrService.success('Success','Logged out successfully');
    
    //Adding delay
    setTimeout(() => 
{
    this.router.navigate(['login']);
},
800);
   
  }
}
