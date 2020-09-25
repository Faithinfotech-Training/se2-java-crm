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
  logOut() {
    this.toastrService.success('Success','Logged out successfully');
    console.log("Check");
    sessionStorage.removeItem('username');
    
    setTimeout(() => 
{
    this.router.navigate(['login']);
},
6000);
   // this.router.navigate(['login']);
   
  }

}
