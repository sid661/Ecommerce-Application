import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdmindashboardComponent } from './component/admindashboard/admindashboard.component';
import { AdminComponent } from './component/admin/admin.component';

import { DashboardComponent } from './component/dashboard/dashboard.component';
import { HomeComponent } from './component/home/home.component';
import { LoginAdminComponent } from './component/login-admin/login-admin.component';
import { LoginuserComponent } from './component/loginuser/loginuser.component';
import { RegisteruserComponent } from './component/registeruser/registeruser.component';
import { UserComponent } from './component/user/user.component';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';
import { AddnewproductComponent } from './component/addnewproduct/addnewproduct.component';
import { LoginadminGuard } from './services/loginadmin.guard';

const routes: Routes = [
 {path:'',component:HomeComponent},
  { path:'dashborad',component:DashboardComponent},
  {path:'loginuser',component:LoginuserComponent},
  {path:'registeruser',component:RegisteruserComponent},
  {path:'loginadmin',component:LoginAdminComponent},
  {path:'user',component:UserComponent},
  {path:'admin',component:AdminComponent},
  {path:'home',component:HomeComponent},
  {path:'userdashboard',component:UserdashboardComponent},
  {path:'admindashboard',component:AdmindashboardComponent},
  {path:'addnewproduct',component:AddnewproductComponent}



 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
