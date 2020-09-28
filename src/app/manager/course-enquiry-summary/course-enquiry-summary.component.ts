import { Component, ComponentFactoryResolver, OnInit } from '@angular/core';
import { CourseEnquirySummaryService, CourseEnquiry } from 'src/app/services/course-enquiry-summary.service'
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-course-enquiry-summary',
  templateUrl: './course-enquiry-summary.component.html',
  styleUrls: ['./course-enquiry-summary.component.css']
})
export class CourseEnquirySummaryComponent implements OnInit {

  constructor(public resourceEnquirySummaryService:CourseEnquirySummaryService) { }

  enquiryList:CourseEnquiry[];
  resourceTypeList:any[];
  enquiryStatusList:any[];

  statusSelected:boolean=true;
  statusSelectedId:any;
  filterList:any;
  date1:any;
  date2:any;

  form:DatePicker;
//  Total count of resource enquiries
  totalCount:any;
  
  searched:Boolean=false;
  ngOnInit(): void {
    this.GetCoursesEnquiryList();
    this.loadCourseEnquiryStatusList();
    this.getTotalCourseEnquiriesCount();
  }

  log(str){
    console.log(str);
  }
  GetCoursesEnquiryList(){

    this.resourceEnquirySummaryService.getCoursesEnquiryList().subscribe(res=>{
      console.log('GetCoursesEnquiryList',res);
      this.enquiryList=res;   
    });
  }

  onSubmit(form:NgForm){
    let date1:any = new Date(form.value.date1);
    let date2:any = new Date(form.value.date2);
    let date1Str=date1.toLocaleDateString('en-GB', { day: 'numeric', month: 'numeric', year: '2-digit' }).split(' ').join('-');
    let date2Str=date2.toLocaleDateString('en-GB', { day: 'numeric', month: 'numeric', year: '2-digit' }).split(' ').join('-');
    this.date1=date1Str;
    this.date2=date2Str;

    this.GetCoursesEnquiryListByDate();
    this.searched=true;
  }


  GetCoursesEnquiryListByDate(){
    this.statusSelected=true;
    this.resourceEnquirySummaryService.getCourseEnquiryFilterByDate(this.date1,this.date2).subscribe(res=>{
      console.log('GetCoursesEnquiryList',res);
      this.enquiryList=res;   
    });
  }

// Get List of all Course Enquiries Status
  loadCourseEnquiryStatusList(){
    this.resourceEnquirySummaryService.getCoursesEnquiryStatusList(status).subscribe(res=>{
      console.log('status list',res);
      this.enquiryStatusList=res;
    })
  }
// Get total number of count of status
  getCountOfStatusType(id){
    if(this.enquiryList!=null){
         
        return this.enquiryList.filter((e)=>e.status.statusId==id).length;

    }
  }
  
  selectStatus(id){
    this.statusSelected=false;
    this.statusSelectedId=id;
    console.log('Selected status id ',this.statusSelectedId);
    
      // this.filterList=this.enquiryList.filter((e)=>e.status.statusId==id);
   this.resourceEnquirySummaryService.getCourseEnquiryFilterByStatus(this.date1,this.date2,id).subscribe(res=>{
        this.filterList=res;
     
    });
    
  }

  getCourseTypeCount(id){
    if(this.filterList!=null){
      return this.filterList.filter((e)=>e.resourcesId.resourceType.resourceTypeId==id).length;

      }
  }

  getTotalCourseEnquiriesCount(){
    this.resourceEnquirySummaryService.getCourseEnquiryCount().subscribe(res=>{
      this.totalCount=res;
      console.log('Total Count',this.totalCount);

    }
  );
  }
}



export class DatePicker{
    date1:any;
    date2:any;
}

