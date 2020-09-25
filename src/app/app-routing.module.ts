import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ResourceComponent } from './resource/resource.component';
import {CourseComponent } from './course/course.component'
import { CourseEnquiryComponent } from './course-enquiry/course-enquiry.component';

const routes: Routes = [
  {path:'resource',component:ResourceComponent},
  {path:'course',component:CourseComponent},
  {path:'course-enquiry', component: CourseEnquiryComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
