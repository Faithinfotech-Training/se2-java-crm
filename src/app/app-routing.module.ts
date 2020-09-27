import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ResourceComponent } from './resource/resource.component';
import { ResourceEnquiryComponent } from './resource-enquiry/resource-enquiry.component'
import {CourseComponent } from './course/course.component'
import { CourseEnquiryComponent } from './course-enquiry/course-enquiry.component';
import { HomepageComponent } from './homepages/homepage/homepage.component';
import { AboutUsComponent } from './homepages/about-us/about-us.component';
import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './login/login.component';
import { ManagerComponent } from './manager/manager.component';
import { AuthGaurdService } from './services/auth-guard.service';

const routes: Routes = [
  {path:'admin/resource',component:ResourceComponent},
  {path:'admin/course',component:CourseComponent},
  {path:'resource',component:ResourceComponent},
  {path:'admin/course-enquiry', component: CourseEnquiryComponent},
  {path:'home',component:HomepageComponent},
  {path:'aboutus',component:AboutUsComponent},
  {path:'admin',component:AdminComponent,canActivate:[AuthGaurdService]},
  {path:'login',component:LoginComponent},
  {path:'manager', component:ManagerComponent,canActivate:[AuthGaurdService]},
  {path:'resource',component:ResourceComponent},
  {path:'enquiry/resource',component:ResourceEnquiryComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
