import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ResourceComponent } from './resource/resource.component';
import { ViewResourcesComponent } from './resource/view-resources/view-resources.component';
import { HttpClientModule } from '@angular/common/http';
import { ModalModule } from 'ngx-bootstrap/modal';
import { AddEditResourceComponent } from './resource/add-edit-resource/add-edit-resource.component';
import { FormsModule } from '@angular/forms';
import {  ToastrModule } from "ngx-toastr";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CourseComponent } from './course/course.component';
import { AddEditCourseComponent } from './course/add-edit-course/add-edit-course.component';
import { ViewCourseComponent } from './course/view-course/view-course.component';
@NgModule({
  declarations: [
    AppComponent,
    ResourceComponent,
    ViewResourcesComponent,
    AddEditResourceComponent,
    CourseComponent,
    AddEditCourseComponent,
    ViewCourseComponent,
    
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    ModalModule.forRoot(),
    FormsModule,
    ToastrModule.forRoot(),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
