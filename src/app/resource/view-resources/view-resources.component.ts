import { Component, OnInit, TemplateRef } from '@angular/core';
import { ResourceService } from 'src/app/services/resource.service';
import { Resource } from 'src/app/models/resource.model';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';  
import { Template } from '@angular/compiler/src/render3/r3_ast';
import { ToastrService } from 'ngx-toastr';
import { OrderPipe } from 'ngx-order-pipe';

@Component({
  selector: 'app-view-resources',
  templateUrl: './view-resources.component.html',
  styleUrls: ['./view-resources.component.css']
})
export class ViewResourcesComponent implements OnInit {

  modalRef: BsModalRef;  
  ModelTitle:string;
  ActivateViewResources:boolean=false;
  SelectedResource:Resource;
  AddEditModalTitle:String;
  p:any;
  term:any;
  orderString:any;
  sortButtonToogle:boolean=false;
  order:any;
  reverseToggle:Boolean;

  constructor(public resourceService:ResourceService,private modalService: BsModalService,private toastrService:ToastrService,private orderPipe: OrderPipe) { }

  ngOnInit(): void {
   
    this.GetResourcesList();
    this.orderString="resourceName";
    this.reverseToggle=false;
    // this.GetOrder();
  }
// Change sort direction
  toggleSort(){
    this.reverseToggle=!this.reverseToggle;
    this.sortButtonToogle=!this.sortButtonToogle;
  }
// 
  GetOrder(){
    this.resourceService.list = this.orderPipe.transform(this.resourceService
      .list, 'info.Name');

  }


// Get list of resources
  GetResourcesList(){
   
    console.log('Get resources list called');
    this.resourceService.getResources().subscribe(res=>{
      console.log('GetResourcesList',res);
      this.resourceService.list=res;

    
    });
  }

  // View resource on clicking resource name 
  viewResourceClick(){
    this.ModelTitle="View Resource";
    this.ActivateViewResources=true;

    console.log('viewResources clicked!');
  }
// Close the model 
  closeClick(){
    this.ActivateViewResources=false;

  }

  openModelWithClass(template:TemplateRef<any>,resource:Resource){

    this.SelectedResource=resource;
    this.modalRef=this.modalService.show(
      template,
      
    );
  }
// Open modal for add and delete
  openAddEditModel(template:TemplateRef<any>,resource:Resource){

    if(resource===null){
      this.AddEditModalTitle="Insert a new Resource";
    }else{
      this.AddEditModalTitle="Edit Resource";
    }
    this.resourceService.formData = Object.assign({},resource);


    this.modalRef=this.modalService.show(
      template,
    );
  }
// Delete resource by resource Id
  deleteClick(resource:Resource){
    console.log('In dlete click');
    let flag:Boolean=false;
    if(confirm("Are you sure you want to delete")){
      console.log('selected yes');
      this.resourceService.deleteResource(resource.resourceId).subscribe(res=>{
          let responseObj:any=res;
          console.log('Console log',res);
          console.log('Response Status',responseObj.status);
          if(responseObj.status==500){
          
            this.toastrService.info('Cannot Delete','This Resource Id is used in Resource Enquiry');
          }
          else
          {
              flag=true;
              this.toastrService.success('Success','Resource Deleted Successfully');
          }


          this.GetResourcesList();
      },err=>{this.toastrService.info('Cannot Delete','This Resource Id is used in Resource Enquiry');
      });

      
      
  
      
    }
  }
}
