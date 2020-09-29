import { Component, OnInit } from '@angular/core';
import { NgForm, FormControl, Validators } from '@angular/forms';
import { CourseService } from "src/app/services/course.service";
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-add-edit-course',
  templateUrl: './add-edit-course.component.html',
  styleUrls: ['./add-edit-course.component.css']
})

export class AddEditCourseComponent implements OnInit {

  DomainList: any = [];
  QualificationList: any = [];
  AccessTypeList: any = [];
  StatusTypeList: any = [];


  control: FormControl = new FormControl('', Validators.min(1));

  constructor(public courseService: CourseService, private toastrService: ToastrService) { }

  ngOnInit(): void {
    //load access list
    this.loadAccessList();
    //load domain list
    this.loadDomainList();
    //load status list
    this.loadStatusList();
    //load qualification list
    this.loadQualificationList();
    console.log('Course Service', this.courseService.formData);
  }

  log(txt) {
    console.log(txt);
  }
  //reset form
  resetform(form?: NgForm) {
    if (form != null) {
      form.resetForm();
    }
    //form data fields
    this.courseService.formData = {
      courseId: null,
      courseName: '',
      description: '',
      duration: '',
      fees: '',
      status: null,
      access: null,
      domain: null,
      qualifications: null,
      ageCriteria: null,
      scoreCriteria: null
    }
  }

  //insert course
  insertCourse(form: NgForm) {

    console.log(form.value.qualifications);

    // Create a empty array to hold qualifications
    let list: Array<any> = [];
    // Add qualification selected from <select> to list
    list.push(form.value.qualifications);

    // Assign qualification list to 'qualification'
    form.value.qualifications = list;

    console.log('Insert Clicked', form.value);
    //calling add course function
    this.courseService.addCourse(form.value).subscribe(res => {

      this.toastrService.success('Success', 'Course Added Successfully');
      this.resetform(form);
      this.refreshList();
    });
  }
  //refrest course list
  refreshList() {
    this.courseService.getCourse().subscribe(res => {
      console.log('GetCourseList', res);
      this.courseService.list = res;
    });
  }
  //function for click on submit
  onSubmit(form: NgForm) {
    console.log('courseId', form.value);
    form.value.courseId = this.courseService.formData.courseId;
    if (form.value.courseId == null) {
      this.insertCourse(form);
    }
    else {
      this.updateCourse(form);
    }
  }

  //update course function
  updateCourse(form: NgForm) {
    // Create a empty array to hold qualifications
    let list: Array<any> = [];
    // Add qualification selected from <select> to list
    list.push(form.value.qualifications);

    // Assign qualification list to 'qualification'
    form.value.qualifications = list;

    console.log('Update clicked', form.value);

    this.courseService.updateCourse(form.value).subscribe(res => {
      this.toastrService.success('Success', 'Course Updated Successfully');
      this.resetform(form);
      this.refreshList();
    });
  }
  //load domain list
  loadDomainList() {
    this.courseService.getDomainList().subscribe(res => {
      this.DomainList = res;
    });
  }

  //load access list
  loadAccessList() {
    this.courseService.getAccessTypeList().subscribe(res => {
      this.AccessTypeList = res;
    });
  }
  //load status list
  loadStatusList() {
    this.courseService.getStatusList().subscribe(res => {
      this.StatusTypeList = res;
    });
  }
  //load qualification list
  loadQualificationList() {
    this.courseService.getQualificationList().subscribe(res => {
      this.QualificationList = res;
    });
  }

}
