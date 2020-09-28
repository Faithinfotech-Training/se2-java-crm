import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
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
import { HomePageNavComponent } from './navbar/home-page-nav/home-page-nav.component';
import { HomepageComponent } from './homepages/homepage/homepage.component';
import { AboutUsComponent } from './homepages/about-us/about-us.component';
import { LoginComponent } from './login/login.component';
import { LoginServiceService } from './services/login-service.service';
import { AdminComponent } from './admin/admin.component';
import { ManagerComponent } from './manager/manager.component';
import { ManagerSalespipelineComponent } from './manager-salespipeline/manager-salespipeline.component';
import { ResourseSalesComponent } from './manager-salespipeline/resourse-sales/resourse-sales.component';
import { CourseSalesComponent } from './manager-salespipeline/course-sales/course-sales.component';
import { ChartsModule } from 'ng2-charts';
import { SidebarComponent } from './admin/sidebar/sidebar.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import {NgxPaginationModule} from 'ngx-pagination'; // <-- import the module
import { OrderModule } from 'ngx-order-pipe';
import { ResourceEnquirySummaryComponent } from './manager/resource-enquiry-summary/resource-enquiry-summary.component';
import { CourseEnquirySummaryComponent } from './manager/course-enquiry-summary/course-enquiry-summary.component';
import { WebportalComponent } from './webportal/webportal.component';
// import { CourseLeadComponent } from './manager-salespipeline/course-lead/course-lead.component';
//import { ResourceLeadComponent } from './manager-salespipeline/resource-lead/resource-lead.component';
import { LeadSalespipelineComponent } from './manager/lead-salespipeline/lead-salespipeline.component';
import { CourseleadComponent } from './manager/lead-salespipeline/courselead/courselead.component';
import { ResourceleadComponent } from './manager/lead-salespipeline/resourcelead/resourcelead.component';
import { WebCourseComponent } from './webportal/web-course/web-course.component';
import { WebResourceComponent } from './webportal/web-resource/web-resource.component';


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
    AddCourseEnquiryComponent,
    HomePageNavComponent,
    HomepageComponent,
    AboutUsComponent,
    LoginComponent,
    AdminComponent,
    ManagerComponent,
    ManagerSalespipelineComponent,
    ResourseSalesComponent,
    CourseSalesComponent,
    SidebarComponent,
    ResourceEnquirySummaryComponent,
    CourseEnquirySummaryComponent,
    ResourceEnquirySummaryComponent,
    LeadSalespipelineComponent,
    CourseleadComponent,
    ResourceleadComponent,
    WebportalComponent,
    WebCourseComponent,
    WebResourceComponent,
   
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    ChartsModule,
    ModalModule.forRoot(),
    FormsModule,
    ToastrModule.forRoot(),
    Ng2SearchPipeModule,
    FormsModule,
    OrderModule,
    NgxPaginationModule,
    Ng2SearchPipeModule,
    NgxPaginationModule,
    OrderModule,
    BrowserAnimationsModule
  ],
  providers: [LoginServiceService],
  bootstrap: [AppComponent],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class AppModule { }
