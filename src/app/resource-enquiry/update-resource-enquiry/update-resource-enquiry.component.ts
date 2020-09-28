import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
//import { OrderPipe } from 'ngx-order-pipe';
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
  

  constructor(public resourceEnquiryService:ResourceEnquiryService,
    private toastrService:ToastrService,
    private modalService: BsModalService,
    ) { }

  ngOnInit(): void {
    this.refreshResourceEnquiryList()
      this.refreshResourceEnquiryStatusList()
      this.refreshResourceEnquiryListByStatus()
      this.order="";
      this.term="";
     // this.sortedCollection = this.orderPipe.transform(this.resourceEnquiryService.list, 'order');
  }
  refreshResourceEnquiryListByStatus(){
    this.resourceEnquiryService.getResourceEnquiryListByStatus().subscribe(res=>{
      this.resourceEnquiryService.resourceEnquiryListByStatus = res;
    });
  }
    refreshSelect(){

      this.refreshResourceEnquiryStatusList();
      console.log('Resource Enquiry Status in Service', this.resourceEnquiryService.resourceEnquiryStatus);
      console.log('Course Enquiry Status List', this.resourceEnquiryService.resourceEnquiryListByStatus);
      this.refreshResourceEnquiryListByStatus();
    }
    pageChanged(event){
      this.config.currentPage = event;
  }
  setOrder(value: string) {
    if (this.order === value) {
      this.reverse = !this.reverse;
    }
    this.order = value;
  }
  refreshResourceEnquiryStatusList(){
    this.resourceEnquiryService.getStatusList().subscribe(
      data=>{
        this.resourceEnquiryStatusList=data;
        this.resourceEnquiryService.resourceEnquiryStatusList = data;

      }
    );
  }      
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

  onClickUpdate(dataItem:any){
    console.log("Before" ,dataItem);
    dataItem.status = this.resourceEnquiryStatus;
    this.resourceEnquiryService.updateResourceEnquiry(dataItem).subscribe( res=>{
      console.log(res);
      this.toastrService.success('Success','Resource Enquiry Inserted Successfully');
      console.log("After" ,dataItem);
      
      this.refreshResourceEnquiryList();
      this.refreshSelect();
    });
  }
  changeOption(enquiryStatus:any){
    console.log(enquiryStatus);
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
