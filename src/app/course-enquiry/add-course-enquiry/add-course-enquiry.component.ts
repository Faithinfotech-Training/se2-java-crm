import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CourseEnquiry } from 'src/app/course-enquiry.model';
import { ResourceEnquiryServiceService } from 'src/app/resource-enquiry-service.service';

@Component({
  selector: 'app-add-course-enquiry',
  templateUrl: './add-course-enquiry.component.html',
  styleUrls: ['./add-course-enquiry.component.css']
})
export class AddCourseEnquiryComponent implements OnInit {

  courseEnquiry:CourseEnquiry;
  course:any;
  constructor(public service:ResourceEnquiryServiceService) { }

  ngOnInit(): void {
    this.resetForm();
    this.course = {
      courseId: 1,
      courseName: "Java masterclass",
      description: "DETIALS",
      fees: 1000,
      scoreCriteria: 70,
      ageCriteria: 20,
      duration: "20",
      domain: {
          domainId: 1,
          domainName: "Java"
      }
  }
}
  resetForm(form?:NgForm){
    if(form!=null)
    {
      form.resetForm();
    }
    this.service.form={
      courseId: {
        courseId: 1,
        courseName: "Java masterclass",
        description: "DETIALS",
        fees: 1000,
        scoreCriteria: 70,
        ageCriteria: 20,
        duration: "20",
        domain: {
            domainId: 1,
            domainName: "Java"
        },
        access: {
            accessId: 1,
            accessType: "Public"
        },
        status: {
            statusId: 1,
            statusType: "Active"
        },
        qualifications: []
    },
      customerId:{
        customerName:'',
        customerEmailId:'',
        customerPercentage:'',
        customerDOB:'',
        customerPhoneNumber:'',
        customerQualification:'',
        leadSource:''
      },
      enquiryDate:'',
      enquiryStatus:'',

    };
  }
  onSubmit(form:NgForm){
   this.insertCourseEnquiry(form);
  }

  insertCourseEnquiry(form:NgForm){
    console.log(form.value);
    console.log(form.value["customerId.customerName"]);
    this.courseEnquiry = {
        courseId: this.course,
        customerId:{
          customerName:form.value["customerId.customerName"],
          customerEmailId:form.value["customerId.customerEmailId"],
          customerPhoneNumber:form.value["customerId.customerPhoneNumber"],
          customerPercentage:form.value["customerId.customerPercentage"],
          customerDOB:form.value["customerId.customerDOB"],
          customerQualification:form.value["customerId.customerQualification"],
          leadSource:form.value["customerId.leadSource"]
        },
        enquiryStatus:{
          statusId:1,
          statusValue:'Received'
        },
        enquiryDate: new Date().toISOString().slice(0, 10).replace('T', ' ')
    };
    console.log(this.courseEnquiry);
    this.service.addCourseEnquiry(this.courseEnquiry).subscribe(res=>{
      alert('Insertion Successful');
      this.resetForm(form);
    });
  }

}
