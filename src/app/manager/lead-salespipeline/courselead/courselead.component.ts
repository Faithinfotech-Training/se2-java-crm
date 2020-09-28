import { Component, OnInit } from '@angular/core';
import { LeadserviceService } from 'src/app/services/leadservice.service';


@Component({
  selector: 'app-courselead',
  templateUrl: './courselead.component.html',
  styleUrls: ['./courselead.component.css']
})
export class CourseleadComponent implements OnInit {


  course_enquiry_count:number;


   
   
  public pieChartLabels:string[] = [];
  public pieChartData:number[] = [];
  public pieChartLegend = true;
  public pieChartType:string = 'pie';
  public pieChartColors: Array < any > = [{
   backgroundColor: ['#fc5858', '#19d863', '#fdf57d',"#FF6384",
   "#4BC0C0",
   "#FFCE56",
   "#E7E9ED",
   "#36A2EB"],
   borderColor: ['rgba(252, 235, 89, 0.2)', 'rgba(77, 152, 202, 0.2)', 'rgba(241, 107, 119, 0.2)']
 }];
  public pieChartOptions:any = {'backgroundColor': [
               "#FF6384",
            "#4BC0C0",
            "#FFCE56",
            "#E7E9ED",
            "#36A2EB"
            ]}
 
  // events on slice click
  public chartClicked(e:any):void {
    console.log(e);
  }
 
 // event on pie chart slice hover
  public chartHovered(e:any):void {
    console.log(e);
  }




 constructor(public service:LeadserviceService) { }

 ngOnInit(): void {
 
   this.getCourseStatusTable();
   console.log("check");
 }
 

 getCourseStatusTable()
 {
   console.log("check");
    this.service.getCourseStatusTable().subscribe(

      res=>{
        this.service.courseStatusList=res;
     //   this.resource_enquiry_count=this.service.courseStatusLIst.length;
       // console.log(this.resource_enquiry_count);
       this.course_enquiry_count=  this.service.courseStatusList[0].totalCount;
  
       console.log(this.course_enquiry_count);
  
       for(var i=0;i<this.service.courseStatusList.length;i++)
       {
          this.service.courseStatusList[i].leadCount=(this.service.courseStatusList[i].leadCount)/(this.course_enquiry_count)*100;
       
         
          this.pieChartLabels.push(this.service.courseStatusList[i].lead);
          console.log(this.service.courseStatusList[i].lead);
          this.pieChartData.push(this.service.courseStatusList[i].leadCount);  
          console.log(this.service.courseStatusList[i].leadCount);
         
        }
      }
    );
      
      }



}
