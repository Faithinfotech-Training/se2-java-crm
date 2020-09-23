import { Component, OnInit, TemplateRef } from '@angular/core';
import { ResourceService } from 'src/app/services/resource.service';
import { Resource } from 'src/app/models/resource.model';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';  
import { Template } from '@angular/compiler/src/render3/r3_ast';
import { ToastrService } from 'ngx-toastr';

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

  constructor(public resourceService:ResourceService,private modalService: BsModalService,private toastrService:ToastrService) { }

  ngOnInit(): void {
   
    this.GetResourcesList();
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
