import { Component, ComponentFactoryResolver, OnInit } from '@angular/core';
import { CourseEnquirySummaryService, CourseEnquiry } from 'src/app/services/course-enquiry-summary.service'
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-course-enquiry-summary',
  templateUrl: './course-enquiry-summary.component.html',
  styleUrls: ['./course-enquiry-summary.component.css']
})
export class CourseEnquirySummaryComponent implements OnInit {

  constructor(public resourceEnquirySummaryService: CourseEnquirySummaryService) { }
  //course enquiry list 
  enquiryList: CourseEnquiry[];
  //list of status for course enquiry
  enquiryStatusList: any[];
  //status is selected or not
  statusSelected: boolean = true;
  //id of status for drill down view
  statusSelectedId: any;
  //list after filtering by date and status
  filterList: any;
  //start date
  date1: any;
  //end date
  date2: any;
  //date picker from calender
  form: DatePicker;
  //Total count of resource enquiries
  totalCount: any;

  searched: Boolean = false;

  ngOnInit(): void {
    //get course enquiry list
    this.GetCoursesEnquiryList();
    //get status names
    this.loadCourseEnquiryStatusList();
    //count of total course enquries 
    this.getTotalCourseEnquiriesCount();
  }

  log(str) {
    console.log(str);
  }
  //get total enquiry
  GetCoursesEnquiryList() {
    //calling function of api to get course enquiry
    this.resourceEnquirySummaryService.getCoursesEnquiryList().subscribe(res => {
      console.log('GetCoursesEnquiryList', res);
      this.enquiryList = res;
    });
  }

  onSubmit(form: NgForm) {
    //getting start date from calender
    let date1: any = new Date(form.value.date1);
    //getting end date from calender
    let date2: any = new Date(form.value.date2);
    //converting dates in required format of api (dd-MM-YY)
    let date1Str = date1.toLocaleDateString('en-GB', { day: 'numeric', month: 'short', year: '2-digit' }).split(' ').join('-');
    let date2Str = date2.toLocaleDateString('en-GB', { day: 'numeric', month: 'short', year: '2-digit' }).split(' ').join('-');
    //storing converted dates
    this.date1 = date1Str;
    this.date2 = date2Str;
    //getting course enquiry using date filter
    this.GetCoursesEnquiryListByDate();
    this.searched = true;
  }

  //getting course enquiry list by using date filter
  GetCoursesEnquiryListByDate() {
    this.statusSelected = true;
    //calling function of api for getting course enquiry list by using date filter
    this.resourceEnquirySummaryService.getCourseEnquiryFilterByDate(this.date1, this.date2).subscribe(res => {
      console.log('GetCoursesEnquiryList', res);
      this.enquiryList = res;
    });
  }

  // Get List of all Course Enquiries Status
  loadCourseEnquiryStatusList() {
    //calling function of api to get list of status
    this.resourceEnquirySummaryService.getCoursesEnquiryStatusList(status).subscribe(res => {
      this.enquiryStatusList = res;
    })
  }
  // Get total number of count of status
  getCountOfStatusType(id) {
    if (this.enquiryList != null) {
      //geting count of total status
      return this.enquiryList.filter((e) => e.enquiryStatus.statusId == id).length;

    }
  }

  //select id if status is selected
  selectStatus(id) {
    this.statusSelected = false;
    this.statusSelectedId = id;
    console.log('Selected status id ', this.statusSelectedId);

    // this.filterList=this.enquiryList.filter((e)=>e.status.statusId==id);
    this.resourceEnquirySummaryService.getCourseEnquiryFilterByStatus(this.date1, this.date2, id).subscribe(res => {
      this.filterList = res;
    });

  }

  //get total course enquiry count
  getTotalCourseEnquiriesCount() {
    //calling function of rest api for getting count of total course enquiry
    this.resourceEnquirySummaryService.getCourseEnquiryCount().subscribe(res => {
      this.totalCount = res;
      console.log('Total Count', this.totalCount);
    }
    );
  }
}


//class for start date and end date
export class DatePicker {
  date1: any;
  date2: any;
}

 