import { Component, OnInit } from '@angular/core';
import { LeadserviceService } from 'src/app/services/leadservice.service';

@Component({
  selector: 'app-resourcelead',
  templateUrl: './resourcelead.component.html',
  styleUrls: ['./resourcelead.component.css']
})
export class ResourceleadComponent implements OnInit {

  

  title = 'app';
  resource_enquiry_count:number;
  public pieChartLabels:string[] = [];
  public pieChartData:number[] = [];
  public pieChartType:string = 'pie';
  public pieChartLegend = true;
  public pieChartOptions:any = {'backgroundColor': [
               "#FF6384",
            "#4BC0C0",
            "#FFCE56",
            "#E7E9ED",
            "#36A2EB"
  ]};
   public pieChartColors: Array < any > = [{
              backgroundColor: ['#fc5858', '#19d863', '#fdf57d',"#FF6384",
              "#4BC0C0",
              "#FFCE56",
              "#E7E9ED",
              "#36A2EB"],
              borderColor: ['rgba(252, 235, 89, 0.2)', 'rgba(77, 152, 202, 0.2)', 'rgba(241, 107, 119, 0.2)']
            }];
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
    this.getStatusTable();
  }
    getStatusTable()
    {
      this.service.getResourceStatusTable().subscribe(res=>{
        this.service.statusList=res;
        this.resource_enquiry_count=this.service.statusList[0].totalCount;
      
        console.log(this.resource_enquiry_count);
   
        for(var i=0;i<this.service.statusList.length;i++)
        {
           this.service.statusList[i].leadCount=(this.service.statusList[i].leadCount)/(this.resource_enquiry_count)*100;
        
          
           this.pieChartLabels.push(this.service.statusList[i].lead);
           console.log(this.service.statusList[i].lead);
           this.pieChartData.push(this.service.statusList[i].leadCount);  
           console.log(this.service.statusList[i].leadCount);
          
         }
   

      }
      )
      console.log("In getStatusTableComponent");
      console.log(this.service.statusList);
    }


}
