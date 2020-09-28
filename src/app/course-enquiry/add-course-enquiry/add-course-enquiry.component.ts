import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { NgForm } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { CourseEnquiry } from 'src/app/models/course-enquiry.model';
import { CourseEnquiryService } from 'src/app/services/course-enquiry.service';
import { CourseService } from 'src/app/services/course.service';

@Component({
  selector: 'app-add-course-enquiry',
  templateUrl: './add-course-enquiry.component.html',
  styleUrls: ['./add-course-enquiry.component.css']
})
export class AddCourseEnquiryComponent implements OnInit {
  //email validation regex
  emailPattern:any = '([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+'; 
  courseEnquiry:CourseEnquiry;
  courseList:any;
  enquiryStatus:any;
  enquiryStatusList:any;
  course:any;
  constructor(public service:CourseEnquiryService,
              private toastrService:ToastrService,
              private courseService:CourseService) { }

  ngOnInit(): void {
    this.enquiryStatus = {
         statusId:1,
         statusValue:'Received'
      };  
    this.refreshCourseEnquiryStatusList();  
    this.getCourseList();

}
  // refresh the course enquiry status list
  refreshCourseEnquiryStatusList(){
    this.service.getCourseEnquiryStatusList().subscribe(res=>{
      this.enquiryStatusList = res;
    });
  }
  // update the courses list for addition drop down
  getCourseList(){
    this.courseService.getCourse().subscribe(data=>{
      this.courseList = data;
    });
  }

  //reset Form when added or updated.
  resetForm(form?:NgForm){
    if(form!=null)
    {
      console.log("Form reset");
      form.resetForm();
    }
  }
  // log function for debugging purposes
  log(txt:any)
  {
    console.log(txt);
  }
  // onsubmit check the options and add or update
  onSubmit(form:NgForm){

    //update the registration Id
    form.value.registrationId = this.service.form.registrationId; 
   // If not null update the course enquiry else add
    if(this.service.form.registrationId!=null) 
    {
      form.value.enquiryStatus = this.service.form.enquiryStatus;
      form.value.customerId.customerId = this.service.form.customerId.customerId;
      this.updateCourseEnquiry(form);
    }
    else{
      form.value.enquiryStatus = this.enquiryStatus;
      this.insertCourseEnquiry(form);
    }
  }
  
  // Update the course enquiry using service
  updateCourseEnquiry(form:NgForm){
    console.log("UpdateCourseEnquiry", form.value);
    this.service.updateCourseEnquiry(form.value).subscribe(res=>{
      let ResponceObj:any = res;
      console.log(ResponceObj);
      this.toastrService.success('Success','Course Enquiry Updated Successfully');
      this.resetForm(form);
      this.service.getCourseEnquiryList().subscribe(res=>{
        this.service.CourseEnquiryList = res;
      });
    });
  }
  // Add course enquiry using post using service
  insertCourseEnquiry(form:NgForm){
    console.log(form.value);
    this.service.addCourseEnquiry(form.value).subscribe(res=>{
      let ResponceObj:any = res;
      console.log(ResponceObj);
      this.toastrService.success('Success','Course Enquiry Inserted Successfully');
      this.resetForm(form);
      this.service.getCourseEnquiryList().subscribe(res=>{
        this.service.CourseEnquiryList = res;
      });
    });
  }
}
