import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private router:Router) { }
 
 
  ngOnInit(): void {
  }
  logOut() {
    console.log("Check");
    sessionStorage.removeItem('username')
    this.router.navigate(['login']);
  }
}
