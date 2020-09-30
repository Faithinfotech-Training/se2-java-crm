import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { CourseEnquiry } from 'src/app/models/course-enquiry.model';
import { CourseEnquiryService } from 'src/app/services/course-enquiry.service';
import { CourseService } from 'src/app/services/course.service';
import {WebCourseComponent} from 'src/app/webportal/web-course/web-course.component'
@Component({
  selector: 'app-web-course-enquiry-form',
  templateUrl: './web-course-enquiry-form.component.html',
  styleUrls: ['./web-course-enquiry-form.component.css']
})
export class WebCourseEnquiryFormComponent implements OnInit {
 //email validation regex
 emailPattern:any = '([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+'; 
 courseEnquiry:CourseEnquiry;
 courseList:any;
 enquiryStatus:any;
 enquiryStatusList:any;
 course:any;
 leadSourceList = ['Website','Newspaper','Social Media'];
 
  constructor(public service:CourseEnquiryService,
    private toastrService:ToastrService,
    private courseService:CourseService, public closeView:WebCourseComponent) { }

  ngOnInit(): void {
    this.enquiryStatus = {
      statusId:1,
      statusValue:'Received'
   }; 
  
  }

  

//reset Form when added or updated.
resetForm(form?:NgForm){
  if(form!=null)
  {
    console.log("Form reset");
    form.resetForm();
  }
}

// onsubmit check the options and add or update
onSubmit(form:NgForm){
  form.value.enquiryStatus = this.enquiryStatus;
    console.log(form.value);
    this.insertCourseEnquiry(form);
  
} 
  // Update the course enquiry using service
  insertCourseEnquiry(form:NgForm){
    console.log(this.service.form);
    this.service.addCourseEnquiry(this.service.form).subscribe(res=>{
      let ResponceObj:any = res;
      console.log(ResponceObj);
      this.toastrService.success('Success','Course Enquiry Inserted Successfully');
      this.resetForm(form);
      this.service.getCourseEnquiryList().subscribe(res=>{
        this.service.CourseEnquiryList = res;
        window.location.reload();
        this.closeView.closeClick();
      });
    });
  }

 

}
