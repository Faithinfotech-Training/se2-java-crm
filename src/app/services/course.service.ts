import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { environment } from 'src/environments/environment';
import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  formData : Course
  list : Course[];
  constructor(private http:HttpClient) { }

  getCourse():Observable<any[]>{
    return this.http.get<any>(`${environment.API_URL}/course`);
  }

  getCourseById(val:any):Observable<any>{
    return this.http.get<any>(environment.API_URL + '/course/'+val);
  }

  addCourse(val:any){
    return this.http.post(environment.API_URL + '/course', val);
  }

  updateCourse(val:any){
    return this.http.put(environment.API_URL + '/course', val);
  }

  deleteCourse(val:any){
    return this.http.delete(environment.API_URL + '/course/' + val);
  }

  getStatusList():Observable<any[]>{
    return this.http.get<any>(`${environment.API_URL}/status/all`);
  }

  getAccessTypeList():Observable<any[]>{
    return this.http.get<any>(`${environment.API_URL}/access`);
  }

  getDomainList():Observable<any[]>{
    return this.http.get<any>(`${environment.API_URL}/domain`);
  }

  getQualificationList():Observable<any[]>{
    return this.http.get<any>(`${environment.API_URL}/qualification`);
  }

}

