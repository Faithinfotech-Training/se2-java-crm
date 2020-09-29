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
  //defining required variables
  modalRef: BsModalRef;
  ModelTitle: string;
  ActivateViewCourse: boolean = false;
  SelectedCourse: Course;
  AddEditModelTitle: String;
  config: any;

  constructor(public courseService: CourseService, private modalService: BsModalService, private toastrService: ToastrService,
    private orderPipe: OrderPipe) { }

  //calling three functions in loading
  ngOnInit(): void {
    this.GetCourseList();
    this.GetOrder();
    this.GetPagination();
  }
  //pagination function to configure pagination
  GetPagination() {
    this.config = {
      itemsPerPage: 5,
      currentPage: 1,
    };
  }
  //getting order and reverse order
  GetOrder() {
    this.courseService.sortedlist = this.orderPipe.transform(this.courseService
      .list, 'info.name');
    console.log("Sorted List");
  }

  //getting course list
  GetCourseList() {
    console.log('Get courses list called');
    this.courseService.getCourse().subscribe(res => {
      console.log('GetCourseList', res);
      this.courseService.list = res;
    });
  }
  //view course by id
  viewCourseClick() {
    this.ModelTitle = "View Course";
    this.ActivateViewCourse = true;

    console.log('viewCourse clicked!');
  }
  //close function
  closeClick() {
    this.ActivateViewCourse = false;

  }
  //model function for open course by id
  openModelWithClass(template: TemplateRef<any>, course: Course) {

    this.SelectedCourse = course;
    this.modalRef = this.modalService.show(
      template,

    );
  }
  //open course for insert or edit
  openAddEditModel(template: TemplateRef<any>, course: Course) {

    if (course === null) {
      this.AddEditModelTitle = "Insert a new Course";
    } else {
      this.AddEditModelTitle = "Edit Course";
    }
    this.courseService.formData = Object.assign({}, course);


    this.modalRef = this.modalService.show(
      template,
    );
  }
  //setting order for course name
  setOrder(value: string) {
    if (this.courseService.order === value) {
      this.courseService.reverse = !this.courseService.reverse;
    }
    this.courseService.order = value;
  }
  //page changed in pagination
  pageChanged(event) {
    this.config.currentPage = event;
  }
  //delete course 
  deleteClick(course: Course) {
    if (confirm("Are you sure you want to delete")) {
      this.courseService.deleteCourse(course.courseId).subscribe(res => {
        let responseObj: any = res;
        if (responseObj.status == 500) {

          this.toastrService.error('error', 'Error while Deleting');
        }
        else {
          this.toastrService.success('Success', 'Course Deleted Successfully');
        }
      });

    }
    this.GetCourseList();
  }
}










