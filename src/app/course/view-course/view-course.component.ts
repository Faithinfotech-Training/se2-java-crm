import { Component, OnInit, TemplateRef } from '@angular/core';
import { CourseService } from 'src/app/services/course.service';
import { Course } from 'src/app/models/course.model';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';  
import { Template } from '@angular/compiler/src/render3/r3_ast';
import { ToastrService } from 'ngx-toastr';

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

  constructor(public courseService:CourseService,private modalService: BsModalService,private toastrService:ToastrService) { }

  ngOnInit(): void {
    this.GetCourseList();
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

  deleteClick(course:Course){
    if(confirm("Are you sure you want to delete")){
      this.courseService.deleteCourse(course.courseId).subscribe(res=>{
          let responseObj:any=res;
          console.log(res);
          
          if(responseObj.status==500){
          
            this.toastrService.error('error','Error while Deleting');
          }
          else
          {
             
              this.toastrService.success('Success','Course Deleted Successfully');
          }


          this.GetCourseList();
      });
      
  
      
    }
  }
}





 

 

 
