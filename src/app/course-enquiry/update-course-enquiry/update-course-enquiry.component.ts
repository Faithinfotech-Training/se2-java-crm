import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CourseEnquiryService } from 'src/app/services/course-enquiry.service';

@Component({
  selector: 'app-update-course-enquiry',
  templateUrl: './update-course-enquiry.component.html',
  styleUrls: ['./update-course-enquiry.component.css']
})
export class UpdateCourseEnquiryComponent implements OnInit {

  constructor(public service:CourseEnquiryService) { }

  ngOnInit(): void {
  }

  onSubmit(form:NgForm){
    console.log(form.value);
  }
  
  


}
