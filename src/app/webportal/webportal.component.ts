import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-webportal',
  templateUrl: './webportal.component.html',
  styleUrls: ['./webportal.component.css']
})
export class WebportalComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
    this.router.navigate(['webportal/home']);
  }

}
