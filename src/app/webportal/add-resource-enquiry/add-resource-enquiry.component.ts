import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { ResourceEnquiry } from 'src/app/models/resource-enquiry.model';
import { ResourceEnquiryService } from 'src/app/services/resource-enquiry.service';
import { ResourceService } from 'src/app/services/resource.service';

@Component({
  selector: 'app-add-resource-enquiry',
  templateUrl: './add-resource-enquiry.component.html',
  styleUrls: ['./add-resource-enquiry.component.css']
})
export class AddResourceEnquiryComponent implements OnInit {

  //Declaring Variables
  resourceEnquiry:ResourceEnquiry;
  StatusTypeList:any;
  ResourceList:any;
  customer: any;
  resource:any;
  status:any;
  

  constructor(public resourceEnquiryService:ResourceEnquiryService,
              private toastrService:ToastrService,
              public resourceService:ResourceService) 
              {
                
               }

  //Initializing and loading the list of all the statuses and resources
  ngOnInit(): void {
    this.status={
      statusId:1,
      statusValue:'Received'
    };
  }

  //Resets all the values in the form
  resetform(form?:NgForm){
    if(form!=null){
      form.resetForm();
    }

  }
  
  //When submit button is clicked this function is called.
  onSubmit(form:NgForm){
    console.log(form.value);
    form.value.status = this.status;
    this.insertResourceEnquiry(form);

  }

  //When Add new Resource Enquiry Button is clicked. This method is called.
  insertResourceEnquiry(form:NgForm){  
  form.value.customerId.customerId=null;
  form.value.customerId.customerDOB='2020-10-10';
  form.value.customerId.customerPercentage='0';
  form.value.customerId.customerQualification='NA';
  form.value.customerId.leadSource='website';
  form.value.customerId.customerEmailId = this.resourceEnquiryService.formData.customerId.customerEmailId;
  form.value.customerId.customerName = this.resourceEnquiryService.formData.customerId.customerName;
  form.value.customerId.customerPhoneNumber = this.resourceEnquiryService.formData.customerId.customerPhoneNumber;
  form.value.enquiryDate=new Date().toISOString().slice(0,10).replace('T','');
  console.log("Resource Id:", this.resourceService.formData);
  form.value.resourcesId = this.resourceService.formData;
  console.log("Resource Form ID:", form.value.resourceId);
  this.resourceEnquiryService.addResourceEnquiry(form.value).subscribe(res=>{
    let ResponceObj:any = res;
      console.log(ResponceObj);
    this.toastrService.success('Success','Resource Enquiry Added Successfully');
      this.resetform(form);
    });
  }

 
 
  //On clicking the update button this method is called. It updates the data in the form for given resource Enquiry
  updateResourceEnquiry(form:NgForm){ 

  form.value.customerId.customerDOB='2020-10-10';
  form.value.customerId.customerPercentage='0';
  form.value.customerId.customerQualification='NA';
  form.value.customerId.leadSource='website';
  form.value.enquiryDate='2020-09-27';
  form.value.status = this.resourceEnquiryService.formData.status

  this.resourceEnquiryService.updateResourceEnquiry(form.value).subscribe(res=>{
      let ResponceObj:any = res;
      console.log(ResponceObj);
      this.toastrService.success('Success','Resource Enquiry Updated Successfully');
      this.resetform(form);
      this.resourceEnquiryService.getResourceList().subscribe(res=>{
      this.resourceEnquiryService.list= res;
      window.location.reload();
    });
  });
  }


}
