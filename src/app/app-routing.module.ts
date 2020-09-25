import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './login/login.component';
import { ManagerComponent } from './manager/manager.component';
import { AuthGaurdService } from './service/auth-guard.service';

const routes: Routes = [

  {path:'admin',component:AdminComponent,canActivate:[AuthGaurdService]},
  {path:'login',component:LoginComponent},
  {path:'manager', component:ManagerComponent,canActivate:[AuthGaurdService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})



export class AppRoutingModule {

 }
 
