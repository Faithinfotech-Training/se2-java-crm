import { Component, OnInit, TemplateRef } from '@angular/core';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';  
import { ToastrService } from 'ngx-toastr';
import { ResourceEnquiryService } from 'src/app/services/resource-enquiry.service';
import { ResourceEnquiry } from 'src/app/models/resource-enquiry.model';

@Component({
  selector: 'app-view-resource-enquiry',
  templateUrl: './view-resource-enquiry.component.html',
  styleUrls: ['./view-resource-enquiry.component.css']
})
export class ViewResourceEnquiryComponent implements OnInit {

  
  modalRef: BsModalRef;  
  ModelTitle:string;
  ActivateViewResourceEnquiry:boolean=false;
  SelectedResourceEnquiry:ResourceEnquiry;
  AddEditModalTitle:String;
  p: number = 1;
  searchValue:string;
  constructor(public resourceEnquiryService:ResourceEnquiryService,private modalService: BsModalService,private toastrService:ToastrService) { }

  ngOnInit(): void {
    
    this.GetResourceEnquiryList();
  }

  GetResourceEnquiryList(){
    this.resourceEnquiryService.getResourceEnquiries().subscribe(res=>{
      this.resourceEnquiryService.list=res;
      console.log(this.resourceEnquiryService.list);

  });
}

   
  /*viewResourceEnquiryClick(){
    this.ModelTitle="View Resource Enquiry";
    this.ActivateViewResourceEnquiry=true;

    console.log('viewResources clicked!');
  }*/

  closeClick(){
    this.ActivateViewResourceEnquiry=false;

  }

  openModelWithClass(template:TemplateRef<any>,resourceEnquiry:ResourceEnquiry){

    this.SelectedResourceEnquiry=resourceEnquiry;
    this.modalRef=this.modalService.show(
      template,
      
    );
  }

  openAddEditModel(template:TemplateRef<any>,resourceEnquiry:ResourceEnquiry){

    if(resourceEnquiry===null){
      this.AddEditModalTitle="Insert a new Resource Enquiry";
    }else{
      this.AddEditModalTitle="Edit Resource Enquiry";
    }
    this.resourceEnquiryService.formData = Object.assign({},resourceEnquiry);


    this.modalRef=this.modalService.show(
      template,
    );
  }

  deleteClick(resourceEnquiry:ResourceEnquiry){
    if(confirm("Are you sure you want to delete")){
      this.resourceEnquiryService.deleteResourceEnquiry(resourceEnquiry.resourceEnquiryId).subscribe(res=>{
          let responseObj:any=res;
          console.log(res);
          
          if(responseObj.status==500){
          
            this.toastrService.error('error','Error while Deleting');
          }
          else
          {
             
              this.toastrService.success('Success','Resource Enquiry Deleted Successfully');
          }


          this.GetResourceEnquiryList();
      });
      
  
      
    }
  }



}
