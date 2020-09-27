import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class ResourceEnquirySummaryService {

  formData:ResourceEnquiry
  list:ResourceEnquiry[];

  constructor(private http:HttpClient) { }

  getResourcesEnquiryList():Observable<any[]>{
    return this.http.get<any>(`${environment.API_URL}/enquiry/resource`);
  }

  getResourcesEnquiryStatusList():Observable<any[]>{
    return this.http.get<any>(`${environment.API_URL}/enquiry/resourcestatus`);
  }

  getResourcesTypeList():Observable<any[]>{
    return this.http.get<any>(`${environment.API_URL}/resourceTypes`);
  }


}

export class ResourceEnquiry{
  resourceEnquiryId:any;
  customerId:any;
  resourcesId:any;
  status:any;
  enquiryDate:any;

}