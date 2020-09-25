import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ResourceComponent } from './resource/resource.component';
import { ResourceEnquiryComponent } from './resource-enquiry/resource-enquiry.component'
const routes: Routes = [
  {path:'resource',component:ResourceComponent},
  {path:'enquiry/resource',component:ResourceEnquiryComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
