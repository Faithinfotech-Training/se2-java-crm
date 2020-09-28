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
import { UpdateCourseEnquiryComponent } from './course-enquiry/update-course-enquiry/update-course-enquiry.component';


const routes: Routes = [
  {path:'resource',component:ResourceComponent},
  {path:'course',component:CourseComponent},
  {path:'course-enquiry', component: CourseEnquiryComponent},
  {path:'update-course-enquiry', component: UpdateCourseEnquiryComponent},
  {path:'home',component:HomepageComponent},
  {path:'aboutus',component:AboutUsComponent},
  {path:'admin',component:AdminComponent,canActivate:[AuthGaurdService]},
  {path:'login',component:LoginComponent},
  {path:'manager', component:ManagerComponent,canActivate:[AuthGaurdService]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
