import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { environment } from 'src/environments/environment';
import { CourseEnquiry } from '../models/course-enquiry.model';


@Injectable({
  providedIn: 'root'
})
export class CourseEnquiryService {
  order:any;
  reverse:any;
  courseEnquiryStatus: any = {
    statusId: 1,
    statusValue: 'Received'
  };
  CourseEnquiryList:any[];
  courseEnquiryStatusList:any[];
  CourseEnquiryListByStatus:any[];
  readonly  APIUrl = "http://localhost:9090/api/";
  form:CourseEnquiry;
  constructor(private http:HttpClient) { }

  getCourseEnquiryList():Observable<any[]>{
    return this.http.get<any>(environment.API_URL+'/enquiry/course');
  }

  getCourseEnquiryById(val:any):Observable<any>{
    return this.http.get<any>(environment.API_URL + '/enquiry/course/'+val);
  }

  addCourseEnquiry(val:any){
    return this.http.post(environment.API_URL + '/enquiry/course', val);
  }

  updateCourseEnquiry(val:any){
    return this.http.put(environment.API_URL + '/enquiry/course', val);
  }

  deleteCourseEnquiry(val:any){
    return this.http.delete(environment.API_URL + '/enquiry/course/' + val);
  }
  getCourseEnquiryStatusList():Observable<any[]>{
    return this.http.get<any>(environment.API_URL+'/enquiry/coursestatus');
  }

  getCourseEnquiryListByStatus(){
    return this.http.get<any>(environment.API_URL+'/enquiry/course/filter/status/' + this.courseEnquiryStatus.statusId);
  }

}
