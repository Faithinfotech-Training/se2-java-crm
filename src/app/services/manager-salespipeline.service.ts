import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CoursestatusresponseModule } from '../manager/coursestatusresponse/coursestatusresponse.module';
import { StatusresponseModule } from '../manager/statusresponse/statusresponse.module';


@Injectable({
  providedIn: 'root'
})
export class ManagerSalespipelineService {

  statusList:StatusresponseModule[];
  courseStatusList:CoursestatusresponseModule[];
  constructor(private http:HttpClient) { }

  getResourceStatusTable():Observable<any>
  {
    return this.http.get<any>(environment.API_URL+'/stats/resource/table');
  }
  getCourseStatusTable():Observable<any>
  {
    return this.http.get<any>(environment.API_URL+'/stats/course/table');
  }
}
