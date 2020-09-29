import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { ToastrService } from 'ngx-toastr';
import { Resource } from 'src/app/models/resource.model';
import { ResourceEnquiryService } from 'src/app/services/resource-enquiry.service';
import { ResourceEnquiry } from 'src/app/models/resource-enquiry.model';

@Component({
  selector: 'app-update-resource-enquiry',
  templateUrl: './update-resource-enquiry.component.html',
  styleUrls: ['./update-resource-enquiry.component.css']
})
export class UpdateResourceEnquiryComponent implements OnInit {

  //Declaring all the variables
  tableHeadings:any = ['Resource Name', 'Name', 'Email Id', 'Enquiry Date', 'Enquiry Status'];
  config: any;
  term:any;
  p: number = 1;
  collection = { count: 60, data: [] };
  order: string = 'resourceId.resourceName';
  reverse: boolean = false;
  sortedCollection: any[];
  modalRef: BsModalRef;  
  ModelTitle:string;
  ActivateViewResourceEnquiry:boolean=false;
  SelectedResource:Resource;
  AddEditModalTitle:String;
  resourceEnquiryList:any;
  resourceEnquiryStatusList:any;
  resourceEnquiry:ResourceEnquiry;
  resourceEnquiryStatus:any;
  selectedResourceEnquiry:ResourceEnquiry;
  selectEnquiryStatus:any;
  searchValue:string;

  constructor(public resourceEnquiryService:ResourceEnquiryService,
    private toastrService:ToastrService,
    private modalService: BsModalService,
    ) { }

    //These functions are called on initialising of the page
  ngOnInit(): void {
    this.refreshResourceEnquiryList()
      this.refreshResourceEnquiryStatusList()
      this.refreshResourceEnquiryListByStatus()
      this.order="";
      this.term="";
     
  }

  //gets the List of Resource enquiries according to the status given
  refreshResourceEnquiryListByStatus(){
    this.resourceEnquiryService.getResourceEnquiryListByStatus().subscribe(res=>{
      this.resourceEnquiryService.resourceEnquiryListByStatus = res;
    });
  }

  //gets the list of status and list of resource enquiries. 
    refreshSelect(){

      this.refreshResourceEnquiryStatusList();
      this.refreshResourceEnquiryListByStatus();
    }
    //pagination page change event
    pageChanged(event){
      this.config.currentPage = event;
  }

  setOrder(value: string) {
    if (this.order === value) {
      this.reverse = !this.reverse;
    }
    this.order = value;
  }

  //Gets the list of all the status
  refreshResourceEnquiryStatusList(){
    this.resourceEnquiryService.getStatusList().subscribe(
      data=>{
        this.resourceEnquiryStatusList=data;
        this.resourceEnquiryService.resourceEnquiryStatusList = data;

      }
    );
  }   
  
  //Gets all the list of Resource Enquiries
  refreshResourceEnquiryList(){
    this.resourceEnquiryService.getResourceEnquiries().subscribe(data=> 
      {
        console.log(data);
        this.resourceEnquiryService.list=data;
        console.log(data);
        this.config = {
          itemsPerPage: 5,
          currentPage: 1,
          totalItems: this.resourceEnquiryService.list.length
        };
      });
  }

  //Resets the input form
  resetForm(form?:NgForm){
    if(form!=null)
    {
      form.resetForm();
    }
  }


  onClickRow(resourceEnquiry:ResourceEnquiry){
    this.selectedResourceEnquiry = resourceEnquiry;
  }
  onChange(resourceEnquiryStatus:any){
    this.resourceEnquiryStatus = resourceEnquiryStatus;
  }

  //When click button is pressed this function is called
  onClickUpdate(dataItem:any){

    dataItem.status = this.resourceEnquiryStatus;
    this.resourceEnquiryService.updateResourceEnquiry(dataItem).subscribe( res=>{
      console.log(res);
      let responseObj:any = res;
      if(responseObj.resultValue=='1'){
        this.toastrService.success('Success','Resource Enquiry Updated Successfully');
      
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


  changeOption(enquiryStatus:any){
   
    this.resourceEnquiryStatusList.forEach(element => {
      if(element.statusValue == enquiryStatus)
      {
        this.resourceEnquiryStatus = element;
      }  
    });
    console.log(this.resourceEnquiryStatus);
  }

  onChangeEnquiryStatus(enquiryStatus:any){
    this.selectEnquiryStatus = enquiryStatus;
}
}
