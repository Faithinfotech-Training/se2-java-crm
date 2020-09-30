import { Component, OnInit, TemplateRef } from '@angular/core';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { OrderPipe } from 'ngx-order-pipe';
import { ToastrService } from 'ngx-toastr';
import { ClickEnquiryModule } from 'src/app/models/click-enquiry/click-enquiry.module';
import { Resource } from 'src/app/models/resource.model';
import { ResourceEnquiryService } from 'src/app/services/resource-enquiry.service';
import { ResourceService } from 'src/app/services/resource.service';

@Component({
  selector: 'app-web-resource',
  templateUrl: './web-resource.component.html',
  styleUrls: ['./web-resource.component.css']
})
export class WebResourceComponent implements OnInit {

  modalRef: BsModalRef;  
  ModelTitle:string;
  ActivateViewResources:boolean=false;
  SelectedResource:Resource;
  AddEditModalTitle:String;
  p:any;
  term:any;
  eDate:string;
  clickEnquiry:ClickEnquiryModule=new ClickEnquiryModule();
  orderString:any;
  sortButtonToogle:boolean=false;
  order:any;
  reverseToggle:Boolean;
  status:any   = {
    statusId:1,
    statusValue:"Received"
  };

  constructor(public resourceService:ResourceService,
              private modalService: BsModalService,
              private toastrService:ToastrService,
              private orderPipe: OrderPipe,
              private resourceEnquiryService:ResourceEnquiryService) {

              }

  ngOnInit(): void {
   
    this.GetResourcesList();
    this.orderString="resourceName";
    this.reverseToggle=false;
    // this.GetOrder();
  }

  toggleSort(){
    this.reverseToggle=!this.reverseToggle;
    this.sortButtonToogle=!this.sortButtonToogle;
  }

  GetOrder(){
    this.resourceService.list = this.orderPipe.transform(this.resourceService
      .list, 'info.Name');

  }



  GetResourcesList(){
   
    console.log('Get resources list called');
    this.resourceService.getResourcesByAccess().subscribe(res=>{
      console.log('GetResourcesListByAccess',res);
      this.resourceService.list=res;

    
    });
  }

  
  viewResourceClick(){
    this.ModelTitle="View Resource";
    this.ActivateViewResources=true;
    console.log('viewResources clicked!');
  }

  closeClick(){
    this.ActivateViewResources=false;
  }

  openModelWithClass(template:TemplateRef<any>,resource:Resource){

    this.SelectedResource=resource;
    this.modalRef=this.modalService.show(
      template,
      
    );
  }

  openAddEditModel(template:TemplateRef<any>,resource:Resource){

  
    console.log("Resource,", resource);
    this.AddEditModalTitle="Insert a Resource Enquiry";
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
    this.resourceService.formData = Object.assign({},resource);
    this.modalRef=this.modalService.show(
      template,
    );
 this.eDate=new Date().toISOString().slice(0, 10).replace('T', ' ');
 var dArr = this.eDate.split("-");
 this.eDate=dArr[2]+ "-" +dArr[1]+ "-" +dArr[0].substring(2);
   console.log(this.eDate);
   this.clickEnquiry.date=this.eDate;
   this.clickEnquiry.page='Resource';
   this.clickEnquiry.count=1;
   console.log(this.clickEnquiry);
this.resourceEnquiryService.putClickEnquiry(this.clickEnquiry);
  }

  deleteClick(resource:Resource){
    if(confirm("Are you sure you want to delete")){
      this.resourceService.deleteResource(resource.resourceId).subscribe(res=>{
          let responseObj:any=res;
          console.log(res);
    
          if(responseObj.status==500){
            this.toastrService.error('error','Error while Deleting');
          }
          else
          {
              this.toastrService.success('Success','Resource Deleted Successfully');
          }


          this.GetResourcesList();
      });      
    }
  }

}
