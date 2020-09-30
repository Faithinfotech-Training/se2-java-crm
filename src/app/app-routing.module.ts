import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ResourceComponent } from './resource/resource.component';
import { ResourceEnquiryComponent } from './resource-enquiry/resource-enquiry.component'
import{UpdateResourceEnquiryComponent} from './resource-enquiry/update-resource-enquiry/update-resource-enquiry.component'
import {CourseComponent } from './course/course.component'
import { CourseEnquiryComponent } from './course-enquiry/course-enquiry.component';
import { HomepageComponent } from './homepages/homepage/homepage.component';
import { AboutUsComponent } from './homepages/about-us/about-us.component';
import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './login/login.component';
import { ManagerComponent } from './manager/manager.component';
import { AuthGaurdService } from './services/auth-guard.service';
import { UpdateCourseEnquiryComponent } from './course-enquiry/update-course-enquiry/update-course-enquiry.component';
import { ManagerSalespipelineComponent } from './manager-salespipeline/manager-salespipeline.component';

import { CourseEnquirySummaryComponent } from "./manager/course-enquiry-summary/course-enquiry-summary.component"
import {  ResourceEnquirySummaryComponent } from "./manager/resource-enquiry-summary/resource-enquiry-summary.component";
import { LeadSalespipelineComponent } from './manager/lead-salespipeline/lead-salespipeline.component';
import { WebportalComponent } from './webportal/webportal.component';
import { WebCourseComponent } from './webportal/web-course/web-course.component';
import { WebResourceComponent } from './webportal/web-resource/web-resource.component';
import { ViewTableComponent } from './manager/view-table/view-table.component';
const routes: Routes = [
  {path:'resource',component:ResourceComponent},
  {path:'course',component:CourseComponent},
  {path:'course-enquiry', component: CourseEnquiryComponent},
  {path:'update-course-enquiry', component: UpdateCourseEnquiryComponent},
  {path:'admin',component:AdminComponent,canActivate:[AuthGaurdService],
    children:[
      {path:'resource',component:ResourceComponent},
      {path:'course',component:CourseComponent},
      {path:'course-enquiry', component: CourseEnquiryComponent},
      {path:'update-course-enquiry', component:UpdateCourseEnquiryComponent},
      {path:'resource-enquiry',component:ResourceEnquiryComponent},
      {path:'update-resource-enquiry',component:UpdateResourceEnquiryComponent},
    ]
  },  
  {path:'admin',component:AdminComponent,canActivate:[AuthGaurdService]},
  {path:'login',component:LoginComponent},
  {path:'manager', component:ManagerComponent,canActivate:[AuthGaurdService]},
  {path:'resource',component:ResourceComponent},
 // {path:'managersalespipeline',component:ManagerSalespipelineComponent},

  {path:'',component:LoginComponent},
  {path:'webportal',component:WebportalComponent,
    children:[
      {path:'web-course',component:WebCourseComponent},
      {path:'web-resource',component:WebResourceComponent},
      {path:'home',component:HomepageComponent},
      {path:'aboutus',component:AboutUsComponent},
    ]},
  {path:'manager', component:ManagerComponent,canActivate:[AuthGaurdService],
    children:[
      {path:'resource-enquiry-summary',component:ResourceEnquirySummaryComponent},
      {path:'course-enquiry-summary',component:CourseEnquirySummaryComponent},
     { path:'managersalespipeline',component:ManagerSalespipelineComponent},
     {path:'leadsalespipeline',component:LeadSalespipelineComponent},
     {path:'viewtable',component:ViewTableComponent}
    ]
  },
  {path:'resources',component:ResourceComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
