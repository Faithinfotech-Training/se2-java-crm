import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { CourseEnquiry } from '../models/course-enquiry.model';


@Injectable({
  providedIn: 'root'
})
export class CourseEnquiryService {
  order:any;
  reverse:any;
  CourseEnquiryList:any[];
  readonly  APIUrl = "http://localhost:8000/api/";
  form:CourseEnquiry;
  constructor(private http:HttpClient) { }

  getCourseEnquiryList():Observable<any[]>{
    return this.http.get<any>(`${this.APIUrl}enquiry/course`);
  }

  getCourseEnquiryById(val:any):Observable<any>{
    return this.http.get<any>(this.APIUrl + 'enquiry/course/'+val);
  }

  addCourseEnquiry(val:any){
    return this.http.post(this.APIUrl + 'enquiry/course', val);
  }

  updateCourseEnquiry(val:any){
    return this.http.put(this.APIUrl + 'enquiry/course', val);
  }

  deleteCourseEnquiry(val:any){
    return this.http.delete(this.APIUrl + 'enquiry/course/' + val);
  }
  getCourseEnquiryStatusList():Observable<any[]>{
    return this.http.get<any>(`${this.APIUrl}enquiry/coursestatus`);
  }


}
