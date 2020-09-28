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
// Get Resources enquiry list
  getResourcesEnquiryList():Observable<any[]>{
    return this.http.get<any>(`${environment.API_URL}/enquiry/resource`);
  }
// Get resources enquiry status list 
  getResourcesEnquiryStatusList():Observable<any[]>{
    return this.http.get<any>(`${environment.API_URL}/enquiry/resourcestatus`);
  }
// Get List of all resource types
  getResourcesTypeList():Observable<any[]>{
    return this.http.get<any>(`${environment.API_URL}/resourceTypes`);
  }
// Get resource enquiry list and filter by date
  getResourceEnquiryFilterByDate(date1,date2):Observable<any[]>{
    return this.http.get<any>(`${environment.API_URL}/enquiry/resource/filter/date/${date1}/${date2}`);
  }
// Get resource enquiry list and filter by date and status
  getResourceEnquiryFilterByStatus(date1,date2,status):Observable<any[]>{
    return this.http.get<any>(`${environment.API_URL}/enquiry/resource/filter/date/${date1}/${date2}/${status}`);
  }
// Get resources count
  getResourceEnquiryCount():Observable<any[]>{
    return this.http.get<any>(`${environment.API_URL}/enquiry/resource/count`);

  }


}


export class ResourceEnquiry{
  resourceEnquiryId:any;
  customerId:any;
  resourcesId:any;
  status:any;
  enquiryDate:any;

}