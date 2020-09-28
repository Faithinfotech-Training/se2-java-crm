import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ResourceComponent } from './resource/resource.component';
import { ViewResourcesComponent } from './resource/view-resources/view-resources.component';
import { ModalModule } from 'ngx-bootstrap/modal';
import { AddEditResourceComponent } from './resource/add-edit-resource/add-edit-resource.component';
import {  ToastrModule } from "ngx-toastr";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ResourceEnquiryComponent } from './resource-enquiry/resource-enquiry.component';
import { AddEditResourceEnquiryComponent } from './resource-enquiry/add-edit-resource-enquiry/add-edit-resource-enquiry.component';
import { ViewResourceEnquiryComponent } from './resource-enquiry/view-resource-enquiry/view-resource-enquiry.component';
import { CourseComponent } from './course/course.component';
import { AddEditCourseComponent } from './course/add-edit-course/add-edit-course.component';
import { ViewCourseComponent } from './course/view-course/view-course.component';
import { CourseEnquiryComponent } from './course-enquiry/course-enquiry.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UpdateCourseEnquiryComponent } from './course-enquiry/update-course-enquiry/update-course-enquiry.component';
import { ShowCourseEnquiryComponent } from './course-enquiry/show-course-enquiry/show-course-enquiry.component';
import { AddCourseEnquiryComponent } from './course-enquiry/add-course-enquiry/add-course-enquiry.component'
import { HomePageNavComponent } from './navbar/home-page-nav/home-page-nav.component';
import { HomepageComponent } from './homepages/homepage/homepage.component';
import { AboutUsComponent } from './homepages/about-us/about-us.component';
import { LoginComponent } from './login/login.component';
import { LoginServiceService } from './services/login-service.service';
import { AdminComponent } from './admin/admin.component';
import { ManagerComponent } from './manager/manager.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { SearchFilterResourceEnquiryPipe } from './search-filter-resource-enquiry.pipe';
import { UpdateResourceEnquiryComponent } from './resource-enquiry/update-resource-enquiry/update-resource-enquiry.component';
@NgModule({
  declarations: [
    AppComponent,
    ResourceComponent,
    ViewResourcesComponent,
    AddEditResourceComponent,
    ResourceEnquiryComponent,
    AddEditResourceEnquiryComponent,
    ViewResourceEnquiryComponent,
    CourseComponent,
    AddEditCourseComponent,
    ViewCourseComponent,
    CourseEnquiryComponent,
    UpdateCourseEnquiryComponent,
    ShowCourseEnquiryComponent,
    AddCourseEnquiryComponent,
    HomePageNavComponent,
    HomepageComponent,
    AboutUsComponent,
    LoginComponent,
    AdminComponent,
    ManagerComponent,
    SearchFilterResourceEnquiryPipe,
    
    UpdateResourceEnquiryComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ModalModule.forRoot(),
    FormsModule,
    ReactiveFormsModule,
    ToastrModule.forRoot(),
    NgxPaginationModule,
    BrowserAnimationsModule
  ],
  providers: [LoginServiceService],
  bootstrap: [AppComponent],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class AppModule { }
