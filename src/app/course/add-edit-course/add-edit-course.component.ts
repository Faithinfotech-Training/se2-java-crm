import { Component, OnInit } from '@angular/core';
import { NgForm,FormControl,Validators } from '@angular/forms';
import { CourseService } from "src/app/services/course.service";
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-add-edit-course',
  templateUrl: './add-edit-course.component.html',
  styleUrls: ['./add-edit-course.component.css']
})

export class AddEditCourseComponent implements OnInit {

  DomainList:any=[];
  QualificationList:any=[];
  AccessTypeList:any=[];
  StatusTypeList:any=[];


  control: FormControl = new FormControl('',Validators.min(1));

  constructor(public courseService:CourseService,private toastrService:ToastrService) { }

  ngOnInit(): void {

    this.loadAccessList();
    this.loadDomainList();
    this.loadStatusList();
    this.loadQualificationList();
    console.log('Course Service',this.courseService.formData);
  }

  log(txt){
    console.log(txt);
  }
  resetform(form?:NgForm){
    if(form!=null){
      form.resetForm();
    }

    this.courseService.formData={
      courseId:null,
      courseName:'',
      description:'',
      duration:'',
      fees:'',
      status:null,
      access:null,
      domain:null,
      qualifications:null,
      ageCriteria:null,
      scoreCriteria:null
    }
  }


  insertCourse(form:NgForm){
    
    console.log(form.value.qualifications);

    // Create a empty array to hold qualifications
    let list:Array<any> = [];
    // Add qualification selected from <select> to list
    list.push(form.value.qualifications);

    // Assign qualification list to 'qualification'
    form.value.qualifications=list;
    
    console.log('Insert Clicked',form.value);
    
    this.courseService.addCourse(form.value).subscribe(res=>{
      
      this.toastrService.success('Success','Course Added Successfully');
      this.resetform(form);
      this.refreshList();
    });
  }

  refreshList(){
    this.courseService.getCourse().subscribe(res=>{
      console.log('GetCourseList',res);
      this.courseService.list=res;
    });
  }
  onSubmit(form:NgForm){
    console.log('courseId',form.value);
    form.value.courseId=this.courseService.formData.courseId;
    if(form.value.courseId==null){
      this.insertCourse(form);
    }
    else{
      this.updateCourse(form);
    }
  }


  updateCourse(form:NgForm){

    console.log('Update clicked',form.value);

    this.courseService.updateCourse(form.value).subscribe(res=>{
      this.toastrService.success('Success','Course Updated Successfully');
      this.resetform(form);
      this.refreshList();
    });
  }

  loadDomainList(){
    this.courseService.getDomainList().subscribe(res=>{
      this.DomainList=res;
    });
  }

  loadAccessList(){
    this.courseService.getAccessTypeList().subscribe(res=>{
      this.AccessTypeList=res;
    });
  }

  loadStatusList(){
    this.courseService.getStatusList().subscribe(res=>{
      this.StatusTypeList=res;
    });
  }

  loadQualificationList(){
    this.courseService.getQualificationList().subscribe(res=>{
      this.QualificationList=res;
    });
  }

}
