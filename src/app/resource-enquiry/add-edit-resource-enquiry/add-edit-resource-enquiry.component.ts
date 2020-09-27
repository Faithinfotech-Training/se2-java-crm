import { Component, OnInit } from '@angular/core';
import { NgForm,FormControl,Validators } from '@angular/forms';
import {  ResourceEnquiryService } from "src/app/services/resource-enquiry.service";
import { ToastrService } from 'ngx-toastr';
import { ResourceEnquiry } from 'src/app/models/resource-enquiry.model';
import { ResourceEnquiryComponent } from '../resource-enquiry.component';


@Component({
  selector: 'app-add-edit-resource-enquiry',
  templateUrl: './add-edit-resource-enquiry.component.html',
  styleUrls: ['./add-edit-resource-enquiry.component.css']
})
export class AddEditResourceEnquiryComponent implements OnInit {

  
  resourceEnquiry:ResourceEnquiry;
  StatusTypeList:any=[];
  ResourceList:any=[];

  control: FormControl = new FormControl('',Validators.min(1));
  customer: any;
  resource:any;
  constructor(public resourceEnquiryService:ResourceEnquiryService,private toastrService:ToastrService) { }

  ngOnInit(): void {
    this.loadStatusList();
    this.loadResourceList();
  }
  resetform(form?:NgForm){
    if(form!=null){
      form.resetForm();
    }

    this.resourceEnquiryService.formData={
      resourceEnquiryId:null,
      enquiryDate:null,
      resourcesId:{
        
      },
      customerId:{customerName:'',
      
      customerPercentage:'',
      customerDOB:'',
      customerPhoneNumber:'',
      customerQualification:'',
      leadSource:''},
      status:{statusId:1,statusValue:"Interested"}
    }
  }
  
  insertResourceEnquiry(form:NgForm){
    this.resource=form.value["resource"];
    
    this.customer={
      customerName:form.value["customerId.customerName"],
    customerEmailId:form.value["customerId.customerEmailId"],
    customerDOB:'1998-01-30',
    customerQualification:'NA',
    customerPercentage:'0',
    customerPhoneNumber:form.value["customerId.customerPhoneNumber"],
    leadSource:'Website'};


    this.resourceEnquiry={
    resourceEnquiryId:null,
    enquiryDate:"2020-10-10",
    resourcesId:this.resource,
    customerId:this.customer,
    status:{statusId:1,statusValue:"Received"}
  }


  console.log('Insert Clicked',this.resourceEnquiry);
  
  console.log(this.resourceEnquiry.resourcesId);

  this.resourceEnquiryService.addResourceEnquiry(this.resourceEnquiry).subscribe(res=>{
      this.toastrService.success('Success','Resource Enquiry Added Successfully');
      this.resetform(form);
      this.refreshList();
    });
  }

  refreshList(){
    this.resourceEnquiryService.getResourceEnquiries().subscribe(res=>{
      console.log('GetResourceEnquiryList',res);
      this.resourceEnquiryService.list=res;
    });
  }
  onSubmit(form:NgForm){
    
    form.value.resourceEnquiryId=this.resourceEnquiryService.formData.resourceEnquiryId;
    if(form.value.resourceEnquiryId==null){
      this.insertResourceEnquiry(form);
      
    }
    else{
      this.updateResourceEnquiry(form);
    }
  }


  updateResourceEnquiry(form:NgForm){

    console.log('Update clicked',form.value);
    
    this.resourceEnquiryService.updateResourceEnquiry(form.value).subscribe(res=>{
      this.toastrService.success('Success','Resource Enquiry Updated Successfully');
      this.resetform(form);
      this.refreshList();
    });
  }

  loadStatusList(){
    this.resourceEnquiryService.getStatusList().subscribe(res=>{
      this.StatusTypeList=res;
    });
  }

  loadResourceList(){
    this.resourceEnquiryService.getResourceList().subscribe(res=>{
      this.ResourceList=res;
    });
  }
}
