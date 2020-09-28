import { Component, OnInit, TemplateRef } from '@angular/core';
import { NgForm } from '@angular/forms';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { OrderPipe } from 'ngx-order-pipe';
import { ToastrService } from 'ngx-toastr';
import { CourseEnquiry } from 'src/app/models/course-enquiry.model';
import { Resource } from 'src/app/models/resource.model';
import { CourseEnquiryService } from 'src/app/services/course-enquiry.service';

@Component({
  selector: 'app-update-course-enquiry',
  templateUrl: './update-course-enquiry.component.html',
  styleUrls: ['./update-course-enquiry.component.css']
})
export class UpdateCourseEnquiryComponent implements OnInit {
  tableHeadings:any = ['Course Name', 'Name', 'Email Id', 'Enquiry Date', 'Enquiry Status'];
  config: any;
  term:any;
  order: string = 'courseId.courseName';
  reverse: boolean = false;
  sortedCollection: any[];
  modalRef: BsModalRef;  
  ModelTitle:string;
  ActivateViewCourseEnquiry:boolean=false;
  SelectedResource:Resource;
  AddEditModalTitle:String;
  CourseEnquiryList:any;
  CourseEnquiryStatusList:any;
  CourseEnquiry:CourseEnquiry;
  CourseEnquiryStatus:any;
  selectedCourseEnquiry:CourseEnquiry;
  selectEnquiryStatus:any;
  
  constructor(public service:CourseEnquiryService,
              private toastrService:ToastrService,
              private modalService: BsModalService,
              private orderPipe: OrderPipe) {
               
               }

  ngOnInit(): void {
      this.refreshCourseEnquiryList()
      this.refreshCourseEnquiryStatusList()
      this.refreshCourseEnquiryListByStatus()
      this.refreshSelect()
      this.order="";
      this.term="";
      this.sortedCollection = this.orderPipe.transform(this.service.CourseEnquiryList, 'order');
    }
    refreshCourseEnquiryListByStatus(){
      this.service.getCourseEnquiryListByStatus().subscribe(res=>{
        this.service.CourseEnquiryListByStatus = res;
      });
      
    }
    refreshSelect(){

      this.refreshCourseEnquiryStatusList();
      console.log('Course Enquiry Status in Service', this.service.courseEnquiryStatus);
      console.log('Course Enquiry Status List', this.service.CourseEnquiryListByStatus);
      this.refreshCourseEnquiryListByStatus();
    }
   log(txt:any){
     console.log(txt);
   } 
  pageChanged(event){
      this.config.currentPage = event;
  }
  setOrder(value: string) {
    if (this.order === value) {
      this.reverse = !this.reverse;
    }
    this.order = value;
  }
    
  refreshCourseEnquiryStatusList(){
    this.service.getCourseEnquiryStatusList().subscribe(
      data=>{
        this.CourseEnquiryStatusList=data;
        this.service.courseEnquiryStatusList = data;

      }
    );
  }  
  refreshCourseEnquiryList(){
    this.service.getCourseEnquiryList().subscribe(data=> 
      {
        console.log(data);
        this.service.CourseEnquiryList=data;
        console.log(data);
        this.config = {
          itemsPerPage: 5,
          currentPage: 1,
          totalItems: this.service.CourseEnquiryList.length
        };
      });
  }

  resetForm(form?:NgForm){
    if(form!=null)
    {
      form.resetForm();
    }
  }

  onClickRow(courseEnquiry:CourseEnquiry){
    this.selectedCourseEnquiry = courseEnquiry;
  }
  onChange(CourseEnquiryStatus:any){
    this.CourseEnquiryStatus = CourseEnquiryStatus;
  }
  onClickUpdate(dataItem:any){
    console.log("Before" ,this.CourseEnquiryStatus);
    dataItem.enquiryStatus = this.CourseEnquiryStatus;
    this.service.updateCourseEnquiry(dataItem).subscribe( res=>{
      console.log(res);
      this.toastrService.success('Success','Course Enquiry Inserted Successfully');
      this.refreshCourseEnquiryList();
      this.refreshSelect()
    });
  }

  changeOption(enquiryStatus:any){
    console.log(enquiryStatus);
    this.CourseEnquiryStatusList.forEach(element => {
      if(element.statusValue == enquiryStatus)
      {
        this.CourseEnquiryStatus = element;
      }  
    });
    console.log(this.CourseEnquiryStatus);
  }

  onChangeEnquiryStatus(enquiryStatus:any){
      this.selectEnquiryStatus = enquiryStatus;
  }

}
