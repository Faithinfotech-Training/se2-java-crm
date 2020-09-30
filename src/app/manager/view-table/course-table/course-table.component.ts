import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CourseEnquiry } from 'src/app/models/course-enquiry.model';
import { CourseEnquirySummaryService } from 'src/app/services/course-enquiry-summary.service';
import { ResourceEnquiry, ResourceEnquirySummaryService } from 'src/app/services/resource-enquiry-summary.service';

@Component({
  selector: 'app-course-table',
  templateUrl: './course-table.component.html',
  styleUrls: ['./course-table.component.css']
})
export class CourseTableComponent implements OnInit {

  constructor(public courseEnquirySummaryService:CourseEnquirySummaryService,public resourceEnquirySummaryService:ResourceEnquirySummaryService) { }

  enquiryList:CourseEnquiry[];
  resourceTypeList:any[];
  enquiryStatusList:any[];
  resourceenquiryList:ResourceEnquiry[];
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
 this.GetCoursesEnquiryListByDate();
    this.loadCourseEnquiryStatusList();
    this.getTotalCourseEnquiriesCount();
    this.GetResourcesEnquiryListByDate();
  }

  log(str){
    console.log(str);
  }
  GetCoursesEnquiryList(){
   
    
    this.courseEnquirySummaryService.getCoursesEnquiryList().subscribe(res=>{
      console.log('GetCoursesEnquiryList',res);
      this.enquiryList=res;   
    });
  }

  onSubmit(form:NgForm){
    let date1:any = new Date(form.value.date1);
    let date2:any = new Date(form.value.date2);
    let date1Str=date1.toLocaleDateString('en-GB', { day: 'numeric', month: 'short', year: '2-digit' }).split(' ').join('-');
    let date2Str=date2.toLocaleDateString('en-GB', { day: 'numeric', month: 'short', year: '2-digit' }).split(' ').join('-');
    console.log(date1Str);
    console.log(date2Str);
    this.date1=date1Str;
    this.date2=date2Str;

    this.GetCoursesEnquiryListByDate();
    this.GetResourcesEnquiryListByDate();
    this.searched=true;
  }

  GetResourcesEnquiryListByDate(){
    console.log("In resourceEnquiry");
    this.statusSelected=true;
    console.log(this.date1);
    console.log(this.date2);
    this.resourceEnquirySummaryService.getResourceEnquiryFilterByDate(this.date1,this.date2).subscribe(res=>{
      console.log('GetResourcesEnquiryList',res);
      this.resourceenquiryList=res;   
      console.log(this.resourceenquiryList);
    });
  }
  
  GetCoursesEnquiryListByDate(){
    console.log("In courseEnquiry");
    this.statusSelected=true;
    this.courseEnquirySummaryService.getCourseEnquiryFilterByDate(this.date1,this.date2).subscribe(res=>{
    //  console.log('GetCoursesEnquiryList',res);
      this.enquiryList=res;   
      console.log(this.enquiryList);
    });
  }

// Get List of all Course Enquiries Status
  loadCourseEnquiryStatusList(){
    this.courseEnquirySummaryService.getCoursesEnquiryStatusList(status).subscribe(res=>{
      console.log('status list',res);
      this.enquiryStatusList=res;
    })
  }
// Get total number of count of status
  
  
  selectStatus(id){
    this.statusSelected=false;
    this.statusSelectedId=id;
    console.log('Selected status id ',this.statusSelectedId);
    
      // this.filterList=this.enquiryList.filter((e)=>e.status.statusId==id);
   this.courseEnquirySummaryService.getCourseEnquiryFilterByStatus(this.date1,this.date2,id).subscribe(res=>{
        this.filterList=res;
     
    });
    
  }

  getCourseTypeCount(id){
    if(this.filterList!=null){
      return this.filterList.filter((e)=>e.resourcesId.resourceType.resourceTypeId==id).length;

      }
  }

  getTotalCourseEnquiriesCount(){
    this.courseEnquirySummaryService.getCourseEnquiryCount().subscribe(res=>{
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

