import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { environment } from 'src/environments/environment';
import {ResourceEnquiry} from 'src/app/models/resource-enquiry.model';
import { Customer } from '../customer.model';

@Injectable({
  providedIn: 'root'
})
export class ResourceEnquiryService {

  
  formData:ResourceEnquiry;
  list:ResourceEnquiry[];
  formCustomer:Customer;
  constructor(private http:HttpClient) { }
    
  getResourceEnquiries():Observable<any[]>{
    return this.http.get<any>(environment.API_URL+'/enquiry/resource');
  }

  getResourceEnquiryById(val:any):Observable<any>{
    return this.http.get<any>(environment.API_URL + '/enquiry/resource/'+val);
  }

  
  getResourceById(val:any){
    return this.http.get(environment.API_URL + '/resource',val );
  }
  addResourceEnquiry(val:any){
    
    return this.http.post(environment.API_URL + '/enquiry/resource', val);
  }

  updateResourceEnquiry(val:any){
    return this.http.put(environment.API_URL + '/enquiry/resource', val);
  }

  deleteResourceEnquiry(val:any){
    return this.http.delete(environment.API_URL + '/enquiry/resource/' + val);
  }
 
  findAllResourceEnquiriesByStatus(val:any){
    return this.http.get(environment.API_URL+'/resource/filter/status/'+ val);
}


getStatusList():Observable<any[]>{
  return this.http.get<any>(environment.API_URL+'/enquiry/resourcestatus');
}
getResourceList():Observable<any[]>{
  return this.http.get<any>(environment.API_URL+'/resources');
}
  
}
