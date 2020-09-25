import { Component, OnInit } from '@angular/core';
import { NgForm,FormControl,Validators } from '@angular/forms';
import {  ResourceEnquiryService } from "src/app/services/resource-enquiry.service";
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-add-edit-resource-enquiry',
  templateUrl: './add-edit-resource-enquiry.component.html',
  styleUrls: ['./add-edit-resource-enquiry.component.css']
})
export class AddEditResourceEnquiryComponent implements OnInit {

  
 
  StatusTypeList:any=[];
  ResourceList:any=[];

  control: FormControl = new FormControl('',Validators.min(1));

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
      resourceId:null,
      customerId:null,
      statusId:null
    }
  }
  
  insertResourceEnquiry(form:NgForm){
    console.log('Insert Clicked',form.value);
    
    this.resourceEnquiryService.addResourceEnquiry(form.value).subscribe(res=>{
      
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
