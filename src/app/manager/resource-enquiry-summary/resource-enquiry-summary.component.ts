import { Component, ComponentFactoryResolver, OnInit } from '@angular/core';
import { ResourceEnquirySummaryService, ResourceEnquiry } from 'src/app/services/resource-enquiry-summary.service'
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-resource-enquiry-summary',
  templateUrl: './resource-enquiry-summary.component.html',
  styleUrls: ['./resource-enquiry-summary.component.css']
})
export class ResourceEnquirySummaryComponent implements OnInit {

  constructor(public resourceEnquirySummaryService:ResourceEnquirySummaryService) { }

  enquiryList:ResourceEnquiry[];
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
    this.GetResourcesEnquiryList();
    this.loadResourcesTypeList();
    this.loadResourceEnquiryStatusList();
    this.getTotalResourceEnquiriesCount();
  }

    // For debuggin purpose

  log(str){
    console.log(str);
  }
  // Get list of all resource enquiries
  GetResourcesEnquiryList(){
   
    
    this.resourceEnquirySummaryService.getResourcesEnquiryList().subscribe(res=>{
      console.log('GetResourcesEnquiryList',res);
      this.enquiryList=res;   
    });
  }
  //  Submit Form
  onSubmit(form:NgForm){
    let date1:any = new Date(form.value.date1);
    let date2:any = new Date(form.value.date2);
    let date1Str=date1.toLocaleDateString('en-GB', { day: 'numeric', month: 'numeric', year: '2-digit' }).split(' ').join('-');
    let date2Str=date2.toLocaleDateString('en-GB', { day: 'numeric', month: 'numeric', year: '2-digit' }).split(' ').join('-');
    console.log(date1Str);
    console.log(date2Str);
    this.date1=date1Str;
    this.date2=date2Str;

    this.GetResourcesEnquiryListByDate();
    this.searched=true;
  }

  // Get Resource Enquiry List By Date 
  GetResourcesEnquiryListByDate(){
    this.statusSelected=true;
    this.resourceEnquirySummaryService.getResourceEnquiryFilterByDate(this.date1,this.date2).subscribe(res=>{
      console.log('GetResourcesEnquiryList',res);
      this.enquiryList=res;   
    });
  }

  // Get List of all resourceTypes
  loadResourcesTypeList(){
    this.resourceEnquirySummaryService.getResourcesTypeList().subscribe(res=>{
      console.log('loadResourcesTypeList',res);
      this.resourceTypeList=res;
    });
  }
// Get List of all Resource Enquiries Status
  loadResourceEnquiryStatusList(){
    this.resourceEnquirySummaryService.getResourcesEnquiryStatusList().subscribe(res=>{
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
  

  // Select Status from specific status id
  selectStatus(id){
    this.statusSelected=false;
    this.statusSelectedId=id;
    console.log('Selected status id ',this.statusSelectedId);
    
      // this.filterList=this.enquiryList.filter((e)=>e.status.statusId==id);
   this.resourceEnquirySummaryService.getResourceEnquiryFilterByStatus(this.date1,this.date2,id).subscribe(res=>{
        this.filterList=res;
     
    });
    
  }

  // Get count by resource type
  getResourceTypeCount(id){
    if(this.filterList!=null){
      return this.filterList.filter((e)=>e.resourcesId.resourceType.resourceTypeId==id).length;

      }
  }

  // Get total 
  getTotalResourceEnquiriesCount(){
    this.resourceEnquirySummaryService.getResourceEnquiryCount().subscribe(res=>{
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

