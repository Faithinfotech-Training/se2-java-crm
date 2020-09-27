import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ResourceComponent } from './resource/resource.component';
import {CourseComponent } from './course/course.component'
import { CourseEnquiryComponent } from './course-enquiry/course-enquiry.component';
import { HomepageComponent } from './homepages/homepage/homepage.component';
import { AboutUsComponent } from './homepages/about-us/about-us.component';
import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './login/login.component';
import { ManagerComponent } from './manager/manager.component';
import { AuthGaurdService } from './services/auth-guard.service';
import {  ResourceEnquirySummaryComponent } from "./manager/resource-enquiry-summary/resource-enquiry-summary.component";
const routes: Routes = [
  {path:'admin',component:AdminComponent,canActivate:[AuthGaurdService],
    children:[
      {path:'resource',component:ResourceComponent},
      {path:'course',component:CourseComponent},
      {path:'course-enquiry', component: CourseEnquiryComponent},
    ]
  },  
  {path:'home',component:HomepageComponent},
  {path:'aboutus',component:AboutUsComponent},
  {path:'',component:LoginComponent},
  {path:'resource-enquiry-summary',component:ResourceEnquirySummaryComponent},
  {path:'manager', component:ManagerComponent,canActivate:[AuthGaurdService]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
