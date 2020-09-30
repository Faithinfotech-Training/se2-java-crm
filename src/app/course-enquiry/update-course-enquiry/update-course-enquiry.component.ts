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
  // Variable declarations
  // Table headings to make it configurable
  tableHeadings:any = ['Name', 'Email Id', 'Enquiry Date', 'Enquiry Status'];
  // Pagination configurations variable
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
  enquiryStatus:any;
  
  constructor(public service:CourseEnquiryService,
              private toastrService:ToastrService,
              private modalService: BsModalService,
              private orderPipe: OrderPipe) {
               
              }

  ngOnInit(): void {
      this.enquiryStatus = {
        statusId:1,
        statusValue:'Received'
        };
      this.refreshCourseEnquiryList()
      this.refreshCourseEnquiryStatusList()
      this.refreshCourseEnquiryListByStatus()
      this.refreshSelect()
      this.order="courseId.courseName";
      this.term="";
    }
  
  refreshCourseEnquiryListByStatus(){
      this.service.getCourseEnquiryListByStatus().subscribe(res=>{
        this.service.CourseEnquiryListByStatus = res;
        this.sortedCollection = this.orderPipe.transform(this.service.CourseEnquiryListByStatus, this.order);
        console.log('Course Enquiry Status in Service', this.service.courseEnquiryStatus);
        console.log('Course Enquiry Status List', this.service.CourseEnquiryListByStatus);
      
        this.config = {
          itemsPerPage: 5,
          currentPage: 1
        };
      });  
    }
  
  refreshSelect(){
      this.refreshCourseEnquiryStatusList();
      this.refreshCourseEnquiryListByStatus();
  }
    // Log function for debugging purposes
  log(txt:any){
     console.log(txt);
   }
   // pagination function for page change event 
  pageChanged(event){
      this.config.currentPage = event;
    }
  // set the order to be sorted with
  setOrder(value: string) {
    if (this.order === value) {
      this.reverse = !this.reverse;
    }
    this.order = value;
  }
  // refreshing the course enquiry status list for the drop downs
  refreshCourseEnquiryStatusList(){
    this.service.getCourseEnquiryStatusList().subscribe(
      data=>{
        this.CourseEnquiryStatusList=data;
        this.service.courseEnquiryStatusList = data;
      }
    );
  }  
  // refreshing the course enquiry list
  refreshCourseEnquiryList(){
    this.service.getCourseEnquiryList().subscribe(data=> 
      {
        console.log(data);
        this.service.CourseEnquiryList=data;
        console.log(data);
      }
    );
  }
  // reset form function
  resetForm(form?:NgForm){
    if(form!=null)
    {
      form.resetForm();
    }
    this.service.form.enquiryStatus = this.enquiryStatus;
  }

  // store the current course enquiry selected which is to be updated
  onClickRow(courseEnquiry:CourseEnquiry){
    this.selectedCourseEnquiry = courseEnquiry;
  }
  // store the course enquiry status which is mapped to the drop down.
  onChange(CourseEnquiryStatus:any){
    this.CourseEnquiryStatus = CourseEnquiryStatus;
  }

  // updates the course enquiry by calling the put http method
  onClickUpdate(dataItem:any){
    console.log("Before" ,this.CourseEnquiryStatus);
    dataItem.enquiryStatus = this.CourseEnquiryStatus;
    console.log(dataItem);
    this.service.updateCourseEnquiry(dataItem).subscribe( res=>{
      console.log(res);
      
      let ResponseObj:any = res;
      if(ResponseObj.resultValue == '1'){
        this.toastrService.success('Success','Course Enquiry Inserted Successfully');
        this.refreshCourseEnquiryList();
        this.refreshCourseEnquiryListByStatus();
        this.refreshSelect();
      }
      else{
        this.toastrService.error('Error', ResponseObj.result);
        }
      }
    );
  }

  changeOption(enquiryStatus:any){
    console.log(enquiryStatus);
    this.CourseEnquiryStatusList.forEach(element => {
        if(element.statusValue == enquiryStatus)
        {
          this.CourseEnquiryStatus = element;
        }  
      }
    );
    console.log(this.CourseEnquiryStatus);
  }

  onChangeEnquiryStatus(enquiryStatus:any){
    this.selectEnquiryStatus = enquiryStatus;
  }
}
