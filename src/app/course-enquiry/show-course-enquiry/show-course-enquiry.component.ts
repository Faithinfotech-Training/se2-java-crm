import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CourseEnquiry } from 'src/app/course-enquiry.model';
import { ResourceEnquiryServiceService } from 'src/app/resource-enquiry-service.service';

@Component({
  selector: 'app-show-course-enquiry',
  templateUrl: './show-course-enquiry.component.html',
  styleUrls: ['./show-course-enquiry.component.css']
})
export class ShowCourseEnquiryComponent implements OnInit {

  CourseEnquiryList:any;
  CourseEnquiryStatusList:any;
  CourseEnquiry:CourseEnquiry;
  CourseEnquiryStatus:any;
  constructor(public service:ResourceEnquiryServiceService) { }

  ngOnInit(): void {
      this.refreshCourseEnquiryList()
      this.refreshCourseEnquiryStatusList()
    }

  refreshCourseEnquiryStatusList(){
    this.service.getCourseEnquiryStatusList().subscribe(
      data=>{
        this.CourseEnquiryStatusList=data;
        console.log(data);
        
      }
    );
  }  
  refreshCourseEnquiryList(){
    this.service.getCourseEnquiryList().subscribe(data=> 
      {
        this.CourseEnquiryList=data;
        console.log(data);
      });
  }

  resetForm(form?:NgForm){
    if(form!=null)
    {
      form.resetForm();
    }
  }

  onSubmit(form:NgForm){
    this.updateCourseEnquiry(form);
  }

  updateCourseEnquiry(form:NgForm){
    console.log(form.value);
    this.service.updateCourseEnquiry(form.value).subscribe(res=>{
      alert(res.toString());
      this.resetForm(form);
      this.refreshCourseEnquiryList();
    });
  }
  onClickUpdate(dataItem:any){
    console.log(this.CourseEnquiryStatus);
    dataItem.enquiryStatus = this.CourseEnquiryStatus;
    this.service.updateCourseEnquiry(dataItem).subscribe( res=>{
      console.log(res);
      alert(res);   
    });
    this.refreshCourseEnquiryList();
  }

  ChangeOption(enquiryStatus:any){
    console.log(enquiryStatus);
    this.CourseEnquiryStatusList.forEach(element => {
      if(element.statusValue == enquiryStatus)
      {
        this.CourseEnquiryStatus = element;
      }  
    });
    console.log(this.CourseEnquiryStatus);
  }

  onClickDelete(dataItem:any){
    if(confirm("Are you sure?"))
    {
      console.log(dataItem.registrationId);
      this.service.deleteCourseEnquiry(dataItem.registrationId).subscribe( res=>{
         console.log(res);
         alert(res.toString());   
       });
       this.refreshCourseEnquiryList();
    }
   }

}
