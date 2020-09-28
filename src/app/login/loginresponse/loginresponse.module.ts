import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})

// This is the class to take JSON response  from backend API
export class LoginresponseModule {
 
  // If the login is successful or not
     success:any;
     //What is the role
     role:string;

 }

 