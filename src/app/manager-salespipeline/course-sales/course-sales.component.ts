import { Component, OnInit } from '@angular/core';
import { ManagerSalespipelineService } from 'src/app/services/manager-salespipeline.service';

@Component({
  selector: 'app-course-sales',
  templateUrl: './course-sales.component.html',
  styleUrls: ['./course-sales.component.css']
})
export class CourseSalesComponent implements OnInit {

   course_enquiry_count:number;


   // Pie chart data initialization
   
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




  constructor(public service:ManagerSalespipelineService) { }

  ngOnInit(): void {
  
    this.getCourseStatusTable();
    
  }
  
 
  getCourseStatusTable()
  {
    this.service.getCourseStatusTable().subscribe(res=>{
      this.service.statusList=res;
   //   this.resource_enquiry_count=this.service.courseStatusLIst.length;
     // console.log(this.resource_enquiry_count);
     this.course_enquiry_count=0;
     for(var i=0;i<this.service.statusList.length;i++)
     {
         this.course_enquiry_count=this.course_enquiry_count+this.service.statusList[i].statusCount;
     }
     console.log(this.course_enquiry_count);

     for(var i=0;i<this.service.statusList.length;i++)
     {
        this.service.statusList[i].statusCount=(this.service.statusList[i].statusCount)/(this.course_enquiry_count)*100;
     
       
        this.pieChartLabels.push(this.service.statusList[i].statusValue);
        console.log(this.service.statusList[i].statusValue);
        this.pieChartData.push(this.service.statusList[i].statusCount);  
        console.log(this.service.statusList[i].statusCount);
       
      }

    })
    console.log("In getStatusTableComponent");
    console.log(this.service.statusList);
  }
}
