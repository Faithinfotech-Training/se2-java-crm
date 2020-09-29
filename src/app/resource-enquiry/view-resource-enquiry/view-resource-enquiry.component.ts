import { Component, OnInit, TemplateRef } from '@angular/core';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';  
import { ToastrService } from 'ngx-toastr';
import { ResourceEnquiryService } from 'src/app/services/resource-enquiry.service';
import { ResourceEnquiry } from 'src/app/models/resource-enquiry.model';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-view-resource-enquiry',
  templateUrl: './view-resource-enquiry.component.html',
  styleUrls: ['./view-resource-enquiry.component.css']
})
export class ViewResourceEnquiryComponent implements OnInit {

  //Declaring the variables
  modalRef: BsModalRef;  
  ModelTitle:string;
  ActivateViewResourceEnquiry:boolean=false;
  SelectedResourceEnquiry:ResourceEnquiry;
  AddEditModalTitle:String;
  StatusTypeList:any;
  ResourceEnquiryStatus:any;
  p: number = 1;
  searchValue:string;
  status:any   = {
    statusId:1,
    statusValue:"Received"
  };

  constructor(public resourceEnquiryService:ResourceEnquiryService,private modalService: BsModalService,private toastrService:ToastrService) { }

  //This function is called on loading of the page.
  ngOnInit(): void {
    this.GetResourceEnquiryList();
    this.refreshEnquiryStatusList();
  }

  //Resets the input form
  resetForm(form?:NgForm){
    if(form!=null)
    {
      form.resetForm();
    }
  }

  //Gets the List of all the resource Enquiries
  GetResourceEnquiryList(){
    this.resourceEnquiryService.getResourceEnquiries().subscribe(res=>{
      this.resourceEnquiryService.list=res;
      console.log(this.resourceEnquiryService.list);

  });
}

//gets the list of all the status
refreshEnquiryStatusList(){
  this.resourceEnquiryService.getStatusList().subscribe(
    data=>{
      this.StatusTypeList=data;
      console.log(data);
    }
  );
} 

//When submit button is clicked this function is called. 
onSubmit(form:NgForm){
  this.updateResourceEnquiry(form);
}

//Updates the customer details
updateResourceEnquiry(form:NgForm){
  console.log(form.value);
  this.resourceEnquiryService.updateResourceEnquiry(form.value).subscribe(res=>{
    alert(res.toString());
    this.resetForm(form);
    this.GetResourceEnquiryList();
  });
  
}

//when update button is clicked.
onClickUpdate(dataItem:any){
  console.log(this.ResourceEnquiryStatus);
  dataItem.enquiryStatus = this.ResourceEnquiryStatus;
  this.resourceEnquiryService.updateResourceEnquiry(dataItem).subscribe( res=>{
    console.log(res);
    this.toastrService.success('Success','Resource Enquiry Inserted Successfully');
    this.GetResourceEnquiryList();
  });
}

ChangeOption(enquiryStatus:any){
  console.log(enquiryStatus);
  this.StatusTypeList.forEach(element => {
    if(element.statusValue == enquiryStatus)
    {
      this.ResourceEnquiryStatus = element;
    }  
  });
  console.log(this.ResourceEnquiryStatus);
}

//When delete button is clicked this function is called
onClickDelete(dataItem:any){
  if(confirm("Are you sure?"))
  {
    console.log(dataItem.registrationId);
    this.resourceEnquiryService.deleteResourceEnquiry(dataItem.resourceEnquiryId).subscribe( res=>{
       console.log(res);
       
       this.toastrService.success('Success','Resource Enquiry Deleted Successfully');  
       this.GetResourceEnquiryList();
       
      });
     
  }
 }

  closeClick(){
    this.ActivateViewResourceEnquiry=false;

  }

  //This opens the modal
  openModelWithClass(template:TemplateRef<any>,resourceEnquiry:ResourceEnquiry){

    this.SelectedResourceEnquiry=resourceEnquiry;
    this.modalRef=this.modalService.show(
      template,
      
    );
  }

  //This opens the add edit model
  openAddEditModel(template:TemplateRef<any>,resourceEnquiry:ResourceEnquiry){

    if(resourceEnquiry==null){
      this.AddEditModalTitle="Insert a new Resource Enquiry";
      this.resourceEnquiryService.formData={
        resourceEnquiryId:null,
        resourcesId:{
          resourceId:null,
          resourceName:'',
          resourceDescription:'',
          capacity:'',
          fees:'',
          status:'',
          access:'',
          resourceType:'',

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
        status:this.status
  
      };
    }else{
      this.AddEditModalTitle="Edit Resource Enquiry";
        this.resourceEnquiryService.formData = Object.assign({},resourceEnquiry);

    }
    this.modalRef=this.modalService.show(
      template,
    );
  }

  //When delete is clickd this function is called
  deleteClick(resourceEnquiry:ResourceEnquiry){
    if(confirm("Are you sure you want to delete")){
      this.resourceEnquiryService.deleteResourceEnquiry(resourceEnquiry.resourceEnquiryId).subscribe(res=>{
          let responseObj:any=res;
          console.log(res);
          this.toastrService.success('Success','Resource Enquiry Deleted Successfully');
          this.GetResourceEnquiryList();
          window.location.reload();
      });
      
  
      
    }
  }



}
