import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators } from '@angular/forms';
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
  refreshCourseEnquiryStatusList(){
    this.service.getCourseEnquiryStatusList().subscribe(res=>{
      this.enquiryStatusList = res;
    });
  }
  getCourseList(){
    this.courseService.getCourse().subscribe(data=>{
      this.courseList = data;
    });
  }
  resetForm(form?:NgForm){
    if(form!=null)
    {
      console.log("Form reset");
      form.resetForm();
    }
  }
  log(txt:any)
  {
    console.log(txt);
  }
  onSubmit(form:NgForm){
    console.log(form.value);
    let formObject:any = form.value;
    console.log(formObject);
    form.value.registrationId = this.service.form.registrationId; 
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
