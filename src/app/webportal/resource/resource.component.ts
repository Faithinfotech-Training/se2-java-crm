import { Component, OnInit, TemplateRef } from '@angular/core';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { OrderPipe } from 'ngx-order-pipe';
import { ToastrService } from 'ngx-toastr';
import { Resource } from 'src/app/models/resource.model';
import { ResourceService } from 'src/app/services/resource.service';

@Component({
  selector: 'app-resource',
  templateUrl: './resource.component.html',
  styleUrls: ['./resource.component.css']
})
export class ResourceComponent implements OnInit {

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
    this.resourceService.getResources().subscribe(res=>{
      console.log('GetResourcesList',res);
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

