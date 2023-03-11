import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './component/navbar/navbar.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { LoginuserComponent } from './component/loginuser/loginuser.component';
import { LoginAdminComponent } from './component/login-admin/login-admin.component';
import { RegisteruserComponent } from './component/registeruser/registeruser.component';
import { RegisteradminComponent } from './component/registeradmin/registeradmin.component';
import {MatButtonModule} from '@angular/material/button';
import { UserComponent } from './component/user/user.component';
import { AdminComponent } from './component/admin/admin.component';
import {MatTabsModule} from '@angular/material/tabs';
import { HomeComponent } from './component/home/home.component';
import {MatIconModule} from '@angular/material/icon';
import {MatTableModule} from '@angular/material/table';
import {ReactiveFormsModule} from '@angular/forms';
import { MatDialogModule } from '@angular/material/dialog';
import {MatInputModule} from '@angular/material/input';

import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import {MatCardModule} from '@angular/material/card';
import { HttpClientModule } from '@angular/common/http';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';
import { AdmindashboardComponent } from './component/admindashboard/admindashboard.component';
import { AddnewproductComponent } from './component/addnewproduct/addnewproduct.component';
import {MatGridListModule} from '@angular/material/grid-list';
import { UpdateComponent } from './component/update/update.component';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    DashboardComponent,
    LoginuserComponent,
    LoginAdminComponent,
    RegisteruserComponent,
    RegisteradminComponent,
    UserComponent,
    AdminComponent,
    HomeComponent,
    UserdashboardComponent,
    AdmindashboardComponent,
    AddnewproductComponent,
    UpdateComponent,
    
 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatTabsModule,
    MatIconModule,
    MatTableModule,
    FormsModule,
    MatInputModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatCardModule,
    MatGridListModule,
    HttpClientModule,
    MatDialogModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
