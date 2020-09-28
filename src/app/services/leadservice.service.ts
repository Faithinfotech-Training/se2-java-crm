import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { LeadstatusresponseModule } from '../manager/courseleadstatusresponse/leadstatusresponse.module';
import { CoursestatusresponseModule } from '../manager/coursestatusresponse/coursestatusresponse.module';
import { ResourceleadstatusresponseModule } from '../manager/resourceleadstatusresponse/resourceleadstatusresponse.module';

@Injectable({
  providedIn: 'root'
})
export class LeadserviceService {

  constructor(private http:HttpClient) { }

  statusList:ResourceleadstatusresponseModule[];
  courseStatusList:LeadstatusresponseModule[];

  getResourceStatusTable():Observable<any>
  {
    console.log("checkService");
    return this.http.get<any>(environment.API_URL+'/stats/resource/leadsalespipeline');
  }
  getCourseStatusTable():Observable<any>
  {
    console.log("checkService");
    return this.http.get<any>(environment.API_URL+'/stats/course/leadsalespipeline');
  }

}
