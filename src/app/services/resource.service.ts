import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { environment } from 'src/environments/environment';
import { Resource } from '../models/resource.model';

@Injectable({
  providedIn: 'root'
})
export class ResourceService {

  formData:Resource
  list:Resource[];
  
  constructor(private http:HttpClient) { }

  getResources():Observable<any[]>{
    return this.http.get<any>(environment.API_URL+'/resources');
  }

  getResourceById(val:any):Observable<any>{
    return this.http.get<any>(environment.API_URL + '/resources/'+val);
  }
 getResourcesByAccess():Observable<any>
 {
  return this.http.get<any>(environment.API_URL+'/resource/active/public')
}
  

  addResource(val:any){
    return this.http.post(environment.API_URL + '/resources', val);
  }

  updateResource(val:any){
    return this.http.put(environment.API_URL + '/resources', val);
  }

  deleteResource(val:any){
    return this.http.delete(environment.API_URL + '/resources/' + val);
  }

  getResourcesTypeList():Observable<any[]>{
    return this.http.get<any>(`${environment.API_URL}/resourceTypes`);
  }

  getStatusList():Observable<any[]>{
    return this.http.get<any>(`${environment.API_URL}/status/all`);
  }

  getAccessTypeList():Observable<any[]>{
    return this.http.get<any>(`${environment.API_URL}/access`);
  }

}
