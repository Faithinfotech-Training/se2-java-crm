import { Component, OnInit, TemplateRef } from '@angular/core';
import { CourseService } from 'src/app/services/course.service';
import { Course } from 'src/app/models/course.model';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';  
import { Template } from '@angular/compiler/src/render3/r3_ast';
import { ToastrService } from 'ngx-toastr';
import { OrderModule, OrderPipe } from 'ngx-order-pipe'
import { CourseEnquiry } from 'src/app/models/course-enquiry.model';
import {CourseEnquiryService} from 'src/app/services/course-enquiry.service'

@Component({
  selector: 'app-web-course',
  templateUrl: './web-course.component.html',
  styleUrls: ['./web-course.component.css']
})
export class WebCourseComponent implements OnInit {

  modalRef: BsModalRef;  
  ModelTitle:string;
  ActivateViewCourse:boolean=false;
  SelectedCourse:Course;
  AddEditModelTitle:String;
  config:any;
  enquiryStatus: any = {
    statusId:1,
    statusValue:"Received"
  };
  constructor(public courseService:CourseService,private modalService: BsModalService,private toastrService:ToastrService,
    private orderPipe:OrderPipe, public courseEnquiryService:CourseEnquiryService) { }

  ngOnInit(): void {
    this.GetCourseList();
    this.GetOrder();
    this.GetPagination();
  }
  
  GetPagination(){
    this.config = {
      itemsPerPage: 10,
      currentPage: 1,
     // totalItems: this.courseService.list.count
    };
  }

  GetOrder(){
    this.courseService.sortedlist = this.orderPipe.transform(this.courseService
      .list, 'info.name');
      console.log("Sorted List");
    //console.log(this.courseService.sortedlist);
  }
  
  
  GetCourseList(){
    console.log('Get courses list called');
    this.courseService.getCourse().subscribe(res=>{
      console.log('GetCourseList',res);
      this.courseService.list=res;
    });
  }

  viewCourseClick(){
    this.ModelTitle="View Course";
    this.ActivateViewCourse=true;

    console.log('viewCourse clicked!');
  }

  closeClick(){
    this.ActivateViewCourse=false;

  }


  openModelWithClass(template:TemplateRef<any>,course:Course){

    this.SelectedCourse=course;
    this.modalRef=this.modalService.show(
      template,
      
    );
  }

  // openAddEditModel(template:TemplateRef<any>,course:Course){

  //   if(course===null){
  //     this.AddEditModelTitle="Insert a new Course";
  //   }else{
  //     this.AddEditModelTitle="Edit Course";
  //   }
  //   this.courseService.formData = Object.assign({},course);


  //   this.modalRef=this.modalService.show(
  //     template,
  //   );
  // }

  setOrder(value: string) {
    if (this.courseService.order === value) {
      this.courseService.reverse = !this.courseService.reverse;
    }
    this.courseService.order = value;
  }

  pageChanged(event){
    this.config.currentPage = event;
  }

  // deleteClick(course:Course){
  //   if(confirm("Are you sure you want to delete")){
  //     this.courseService.deleteCourse(course.courseId).subscribe(res=>{
  //         let responseObj:any=res;
  //         if(responseObj.status==500){
          
  //           this.toastrService.error('error','Error while Deleting');
  //         }
  //         else
  //         {  
  //             this.toastrService.success('Success','Course Deleted Successfully');
  //         } 
  //     });
  //     this.GetCourseList();
  //   }
  // }

  //When Enquire Button is pressed. openEnquiry Modal is opened and displays the customer input form
  openEnquiryModal(template:TemplateRef<any>,course:Course){
    
    console.log(this.SelectedCourse);
    this.courseEnquiryService.form={
      registrationId:null,
      courseId: {
        courseId: this.SelectedCourse.courseId,
        courseName: this.SelectedCourse.courseName,
        description: this.SelectedCourse.description,
        fees: this.SelectedCourse.fees,
        scoreCriteria: this.SelectedCourse.scoreCriteria,
        ageCriteria: this.SelectedCourse.ageCriteria,
        duration: this.SelectedCourse.duration,
        domain: this.SelectedCourse.domain,
        access:this.SelectedCourse.access,
        status: this.SelectedCourse.status,
        qualifications:this.SelectedCourse.qualifications
    },
      customerId:{
        customerId:null,
        customerName:'',
        customerEmailId:'',
        customerPercentage:'',
        customerDOB:'',
        customerPhoneNumber:'',
        customerQualification:'',
        leadSource:''
      },
      enquiryDate: new Date().toISOString().slice(0, 10).replace('T', ' '),
      enquiryStatus:this.enquiryStatus
    };
    
    this.modalRef=this.modalService.show(
      template
      );
  }
}





 

 

 
