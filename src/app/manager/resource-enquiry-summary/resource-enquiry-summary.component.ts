import { Component, ComponentFactoryResolver, OnInit } from '@angular/core';
import { ResourceEnquirySummaryService, ResourceEnquiry } from 'src/app/services/resource-enquiry-summary.service'
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

  ngOnInit(): void {
    this.GetResourcesEnquiryList();
    this.loadResourcesTypeList();
    this.loadResourceEnquiryStatusList();
  }

  log(str){
    console.log(str);
  }
  GetResourcesEnquiryList(){
   
    
    this.resourceEnquirySummaryService.getResourcesEnquiryList().subscribe(res=>{
      console.log('GetResourcesEnquiryList',res);
      this.enquiryList=res;   
    });
  }

  loadResourcesTypeList(){
    this.resourceEnquirySummaryService.getResourcesTypeList().subscribe(res=>{
      console.log('loadResourcesTypeList',res);
      this.resourceTypeList=res;
    });
  }

  loadResourceEnquiryStatusList(){
    this.resourceEnquirySummaryService.getResourcesEnquiryStatusList().subscribe(res=>{
      console.log('status list',res);
      this.enquiryStatusList=res;
    })
  }

  getCountOfStatusType(id){
    if(this.enquiryList!=null){
          return this.enquiryList.filter((e)=>e.status.statusId==id).length;

    }
  }
  

}

