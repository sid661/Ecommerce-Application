import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from '../admin';

@Injectable({
  providedIn: 'root'
})
export class AdminloginserviceService {

  constructor(private HttpClient:HttpClient) { }
  adminloginurl="http://localhost:1000/AdminAuthentication/login";


 adminlogin(admin:Admin):Observable<object>{
  console.log(admin)
   return  this.HttpClient.post<Admin>(this.adminloginurl,admin);
 }
}
