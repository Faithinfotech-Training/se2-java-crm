import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ResourceComponent } from './resource/resource.component';
import { ViewResourcesComponent } from './resource/view-resources/view-resources.component';
import { ModalModule } from 'ngx-bootstrap/modal';
import { AddEditResourceComponent } from './resource/add-edit-resource/add-edit-resource.component';
import {  ToastrModule } from "ngx-toastr";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CourseComponent } from './course/course.component';
import { AddEditCourseComponent } from './course/add-edit-course/add-edit-course.component';
import { ViewCourseComponent } from './course/view-course/view-course.component';
import { CourseEnquiryComponent } from './course-enquiry/course-enquiry.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UpdateCourseEnquiryComponent } from './course-enquiry/update-course-enquiry/update-course-enquiry.component';
import { ShowCourseEnquiryComponent } from './course-enquiry/show-course-enquiry/show-course-enquiry.component';
import { AddCourseEnquiryComponent } from './course-enquiry/add-course-enquiry/add-course-enquiry.component'

@NgModule({
  declarations: [
    AppComponent,
    ResourceComponent,
    ViewResourcesComponent,
    AddEditResourceComponent,
    CourseComponent,
    AddEditCourseComponent,
    ViewCourseComponent,
    CourseEnquiryComponent,
    UpdateCourseEnquiryComponent,
    ShowCourseEnquiryComponent,
    AddCourseEnquiryComponent
    
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    ModalModule.forRoot(),
    FormsModule,
    ToastrModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
