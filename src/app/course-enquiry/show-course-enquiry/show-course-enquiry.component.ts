import { HttpClient } from '@angular/common/http';
import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { ToastrService } from 'ngx-toastr';
import { CourseEnquiry } from 'src/app/models/course-enquiry.model';
import { Resource } from 'src/app/models/resource.model';
import { CourseEnquiryService } from 'src/app/services/course-enquiry.service';
import { OrderPipe } from 'ngx-order-pipe';

@Component({
  selector: 'app-show-course-enquiry',
  templateUrl: './show-course-enquiry.component.html',
  styleUrls: ['./show-course-enquiry.component.css']
})
export class ShowCourseEnquiryComponent implements OnInit {
  // declarations
  // table headings to make it configurable
  tableHeadings:any = ['Course Name', 'Name', 'Email Id', 'Enquiry Date', 'Enquiry Status'];
  // config var declaration for pagination 
  config: any;
  term:any;
  collection = { count: 60, data: [] };
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
  SelectedCourseEnquiry:CourseEnquiry;
  enquiryStatus: any = {
    statusId:1,
    statusValue:"Received"
  };
  constructor(public service:CourseEnquiryService,
              private toastrService:ToastrService,
              private modalService: BsModalService,
              private orderPipe: OrderPipe) {
               
               }

  ngOnInit(): void {
      this.refreshCourseEnquiryList()
      this.refreshCourseEnquiryStatusList()
      this.order="";
      this.term="";
      this.sortedCollection = this.orderPipe.transform(this.service.CourseEnquiryList, 'order');
    }
  // logging function for debugging
  log(txt:any){
     console.log(txt);
   }
  // pagechange event function  
  pageChanged(event){
      this.config.currentPage = event;
  }
  // setting the variables
  setOrder(value: string) {
    if (this.order === value) {
      this.reverse = !this.reverse;
    }
    this.order = value;
  }
  // refreshing course enquiry status list  
  refreshCourseEnquiryStatusList(){
    this.service.getCourseEnquiryStatusList().subscribe(
      data=>{
        this.CourseEnquiryStatusList=data;
        console.log(data);
      }
    );
  }  
  //refresh course enquiry list
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

  // reset form after addition and updation
  resetForm(form?:NgForm){
    if(form!=null)
    {
      form.resetForm();
    }
  }

  // after submit update the form
  onSubmit(form:NgForm){
    this.updateCourseEnquiry(form);
  }

  //update the course enquiry using service
  updateCourseEnquiry(form:NgForm){
    console.log(form.value);
    this.service.updateCourseEnquiry(form.value).subscribe(res=>{
      alert(res.toString());
      this.resetForm(form);
      this.refreshCourseEnquiryList();
    });
  }
 

  ChangeOption(enquiryStatus:any){
    console.log(enquiryStatus);
    this.CourseEnquiryStatusList.forEach(element => {
      if(element.statusValue == enquiryStatus)
      {
        this.CourseEnquiryStatus = element;
      }  
    });
    console.log(this.CourseEnquiryStatus);
  }
  // delete the course enquiry if user confirms the deletion
  onClickDelete(dataItem:any){
    if(confirm("Are you sure?"))
    {
      console.log(dataItem.registrationId);
      this.service.deleteCourseEnquiry(dataItem.registrationId).subscribe( res=>{
         console.log(res);
         this.toastrService.success('Success','Course Enquiry Deleted Successfully');  
         this.refreshCourseEnquiryList();
        });
    }
   }
   // update the variable 
   viewCourseEnquiryClick(){
    this.ModelTitle="View Course Enquiry";
    this.ActivateViewCourseEnquiry=true;
    console.log('View Course Enquiry clicked!');
  }
  // close the modal
  closeClick(){
    this.ActivateViewCourseEnquiry=false;
  }

  // open the modal for viewing the course enquiry
  openModelWithClass(template:TemplateRef<any>,courseEnquiry:CourseEnquiry){
    this.SelectedCourseEnquiry=courseEnquiry;
    this.modalRef=this.modalService.show(
      template,
    );
  }
  // open the modal for course enquiry add/update
  openAddEditModel(template:TemplateRef<any>,courseEnquiry:CourseEnquiry){

    // if course enquiry is null
    // create a new course enquiry
    // else update the course enquiry
    if(courseEnquiry===null){
      console.log("Insider create a new Course Enquiry");
      this.AddEditModalTitle="Insert a new Course Enquiry";
      this.service.form={
        registrationId:null,
        courseId: {
          courseId: '',
          courseName: '',
          description: '',
          fees: '',
          scoreCriteria: '',
          ageCriteria: '',
          duration: '',
          domain: {
              domainId: '',
              domainName: ''
          },
          access: {
              accessId: '',
              accessType: ''
          },
          status: {
              statusId: '',
              statusType: ''
          },
          qualifications: []
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
    }else{
      this.AddEditModalTitle="Edit a Course Enquiry";  
      console.log(Object.assign({},courseEnquiry));
      this.service.form = Object.assign({},courseEnquiry);
      console.log("trial--->",this.service.form);
    }
    
    console.log(courseEnquiry);
    this.modalRef=this.modalService.show(
      template
    );
  }
  // delete the course enquiry after confirmation
  deleteClick(courseEnquiry:any){
    if(confirm("Are you sure you want to delete")){
      this.service.deleteCourseEnquiry(courseEnquiry.registrationId).subscribe(res=>{
          let responseObj:any=res;
          console.log(res);
          if(responseObj.status==500){
          
            this.toastrService.error('error','Error while Deleting');
          }
          else
          {
             
              this.toastrService.success('Success','Resource Deleted Successfully');
          }


          this.refreshCourseEnquiryList();
      });
      
  
      
    }
  }


}