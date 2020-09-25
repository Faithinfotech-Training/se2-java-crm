import { Component, OnInit } from '@angular/core';
import { NgForm,FormControl,Validators } from '@angular/forms';
import {  ResourceService } from "src/app/services/resource.service";
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-add-edit-resource',
  templateUrl: './add-edit-resource.component.html',
  styleUrls: ['./add-edit-resource.component.css']
})
export class AddEditResourceComponent implements OnInit {

  ResourceTypeList:any=[];
  AccessTypeList:any=[];
  StatusTypeList:any=[];


  control: FormControl = new FormControl('',Validators.min(1));

  constructor(public resourceService:ResourceService,private toastrService:ToastrService) { }

  ngOnInit(): void {

    this.loadAccessList();
    this.loadResourcesTypeList();
    this.loadStatusList();
    console.log('Resource Service lOg',this.resourceService.formData);

 
    
  }

  log(txt){
    console.log(txt);
  }
  resetform(form?:NgForm){
    if(form!=null){
      form.resetForm();
    }

    this.resourceService.formData={
      resourceId:null,
      resourceName:'',
      resourceDescription:'',
      capacity:'',
      fees:'',
      status:null,
      access:null,
      resourceType:null,
    }
  }


  insertResource(form:NgForm){
    console.log('Insert Clicked',form.value);
    
    this.resourceService.addResource(form.value).subscribe(res=>{
      
      this.toastrService.success('Success','Resource Added Successfully');
      this.resetform(form);
      this.refreshList();
    });
  }

  refreshList(){
    this.resourceService.getResources().subscribe(res=>{
      console.log('GetResourcesList',res);
      this.resourceService.list=res;
    });
  }
  onSubmit(form:NgForm){
    console.log('resourcesId',form.value);
    form.value.resourceId=this.resourceService.formData.resourceId;
    if(form.value.resourceId==null){
      this.insertResource(form);
      
    }
    else{
      this.updateResource(form);
    }
  }


  updateResource(form:NgForm){

    console.log('Update clicked',form.value);

    this.resourceService.updateResource(form.value).subscribe(res=>{
      this.toastrService.success('Success','Resource Updated Successfully');
      this.resetform(form);
      this.refreshList();
    });
  }
  loadResourcesTypeList(){
    this.resourceService.getResourcesTypeList().subscribe(res=>{
      this.ResourceTypeList=res;
    });
  }

  loadAccessList(){
    this.resourceService.getAccessTypeList().subscribe(res=>{
      this.AccessTypeList=res;
    });
  }

  loadStatusList(){
    this.resourceService.getStatusList().subscribe(res=>{
      this.StatusTypeList=res;
    });
  }


}
