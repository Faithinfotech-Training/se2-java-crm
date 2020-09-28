import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class CourseEnquirySummaryService {

  formData:CourseEnquiry
  list:CourseEnquiry[];

  constructor(private http:HttpClient) { }

  getCoursesEnquiryList():Observable<any[]>{
    return this.http.get<any>(`${environment.API_URL}/enquiry/course`);
  }

  getCoursesEnquiryStatusList(status):Observable<any[]>{
    return this.http.get<any>(`${environment.API_URL}/enquiry/coursestatus`);
  }

// Get course enquiry list and filter by date
  getCourseEnquiryFilterByDate(date1,date2):Observable<any[]>{
    return this.http.get<any>(`${environment.API_URL}/enquiry/course/filter/date/${date1}/${date2}`);
  }
// Get course enquiry list and filter by date and status
  getCourseEnquiryFilterByStatus(date1,date2,status):Observable<any[]>{
    return this.http.get<any>(`${environment.API_URL}/enquiry/course/filter/date/${date1}/${date2}/${status}`);
  }
// Get courses count
  getCourseEnquiryCount():Observable<any[]>{
    return this.http.get<any>(`${environment.API_URL}/enquiry/course/count`);

  }
}


export class CourseEnquiry{
  registrationId:any;
  customerId:any;
  courseId:any;
  enquiryStatus:any;
  enquiryDate:any;

}