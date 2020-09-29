import { Component, OnInit } from '@angular/core';
import { NgForm,FormControl,Validators } from '@angular/forms';
import {  ResourceEnquiryService } from "src/app/services/resource-enquiry.service";
import { ToastrService } from 'ngx-toastr';
import { ResourceEnquiry } from 'src/app/models/resource-enquiry.model';


@Component({
  selector: 'app-add-edit-resource-enquiry',
  templateUrl: './add-edit-resource-enquiry.component.html',
  styleUrls: ['./add-edit-resource-enquiry.component.css']
})
export class AddEditResourceEnquiryComponent implements OnInit {

  //Declaring Variables
  emailPattern:any = '([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+';
  resourceEnquiry:ResourceEnquiry;
  StatusTypeList:any;
  ResourceList:any;
  customer: any;
  resource:any;
  status:any;
  

  constructor(public resourceEnquiryService:ResourceEnquiryService,private toastrService:ToastrService) { }

  //Initializing and loading the list of all the statuses and resources
  ngOnInit(): void {
    this.status={
      statusId:1,
      statusValue:'Received'
    };
    this.loadStatusList();
    this.loadResourceList();
  }

  //Gets all the list of Status
  loadStatusList(){
    this.resourceEnquiryService.getStatusList().subscribe(res=>{
      this.StatusTypeList=res;
    });
  }

  //Gets all the list of Resources
  loadResourceList(){
    this.resourceEnquiryService.getResourceList().subscribe(res=>{
      this.ResourceList=res;
    });
  }

  //Resets all the values in the form
  resetform(form?:NgForm){
    if(form!=null){
      form.resetForm();
    }
  }
  
  //Resfreshes the page i.e Gets the list of all the resource Enquiries
  refreshList(){
    this.resourceEnquiryService.getResourceEnquiries().subscribe(res=>{
      console.log('GetResourceEnquiryList',res);
      console.log('statusList',this.StatusTypeList);
      this.resourceEnquiryService.list=res;

    });
  }

  //When submit button is clicked this function is called.
  onSubmit(form:NgForm){
    
    form.value.resourceEnquiryId=this.resourceEnquiryService.formData.resourceEnquiryId;
    if(form.value.resourceEnquiryId==null){
      form.value.status = this.status;
      this.insertResourceEnquiry(form);
      console.log(form);
    }
    else{
      console.log(form.value.status);
      
      form.value.customerId.customerId = this.resourceEnquiryService.formData.customerId.customerId;
      this.updateResourceEnquiry(form);
    }
  }

  //When Add new Resource Enquiry Button is clicked. This method is called. customer Details are in the form.
  insertResourceEnquiry(form:NgForm){
  
  form.value.customerId.customerId=null;
  form.value.customerId.customerDOB='2020-10-10';
  form.value.customerId.customerPercentage='0';
  form.value.customerId.customerQualification='NA';
  form.value.enquiryDate=new Date().toISOString().slice(0,10).replace('T','');
 
  this.resourceEnquiryService.addResourceEnquiry(form.value).subscribe(res=>{
    let ResponceObj:any = res;
      console.log(ResponceObj);
    this.toastrService.success('Success','Resource Enquiry Added Successfully');
      this.resetform(form);
      this.refreshList();
      window.location.reload();
    });
  }

 
 
  //On clicking the update button this method is called. It updates the data in the form for given resource Enquiry
  updateResourceEnquiry(form:NgForm){ 

  form.value.customerId.customerDOB='2020-10-10';
  form.value.customerId.customerPercentage='0';
  form.value.customerId.customerQualification='NA';
  
  form.value.enquiryDate= new Date().toISOString().slice(0, 10).replace('T', ' ');
  form.value.status = this.resourceEnquiryService.formData.status

  this.resourceEnquiryService.updateResourceEnquiry(form.value).subscribe(res=>{
      
      console.log(res);
      let responseObj:any = res;
      if(responseObj.resultValue=='1'){
      this.toastrService.success('Success','Resource Enquiry Updated Successfully');
      this.resetform(form);
      this.resourceEnquiryService.getResourceList().subscribe(res=>{
      this.resourceEnquiryService.list= res;
      });
      window.location.reload();
    }
    else{
      this.toastrService.error('Error',responseObj.result);
    }
    
  });
  }

 
}
