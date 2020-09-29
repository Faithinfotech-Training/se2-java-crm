import { Component, OnInit, TemplateRef } from '@angular/core';
import { CourseService } from 'src/app/services/course.service';
import { Course } from 'src/app/models/course.model';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';  
import { Template } from '@angular/compiler/src/render3/r3_ast';
import { ToastrService } from 'ngx-toastr';
import { OrderModule, OrderPipe } from 'ngx-order-pipe'

@Component({
  selector: 'app-view-course',
  templateUrl: './view-course.component.html',
  styleUrls: ['./view-course.component.css']
})
export class ViewCourseComponent implements OnInit {

  modalRef: BsModalRef;  
  ModelTitle:string;
  ActivateViewCourse:boolean=false;
  SelectedCourse:Course;
  AddEditModelTitle:String;
  config:any;

  constructor(public courseService:CourseService,private modalService: BsModalService,private toastrService:ToastrService,
    private orderPipe:OrderPipe) { }

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

  openAddEditModel(template:TemplateRef<any>,course:Course){

    if(course===null){
      this.AddEditModelTitle="Insert a new Course";
    }else{
      this.AddEditModelTitle="Edit Course";
    }
    this.courseService.formData = Object.assign({},course);


    this.modalRef=this.modalService.show(
      template,
    );
  }

  setOrder(value: string) {
    if (this.courseService.order === value) {
      this.courseService.reverse = !this.courseService.reverse;
    }
    this.courseService.order = value;
  }

  pageChanged(event){
    this.config.currentPage = event;
  }

  deleteClick(course:Course){
    if(confirm("Are you sure you want to delete")){
      this.courseService.deleteCourse(course.courseId).subscribe(res=>{
          let responseObj:any=res;
          if(responseObj.status==500){
          
            this.toastrService.error('error','Error while Deleting');
          }
          else
          {  
              this.toastrService.success('Success','Course Deleted Successfully');
          } 

          this.GetCourseList();
      },      err=>{this.toastrService.info('Cannot Delete','This Resource Id is used in Resource Enquiry');
    });
      
    }}
  }





 

 

 
