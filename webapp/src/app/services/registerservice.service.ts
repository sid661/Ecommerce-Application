import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Registeruser } from '../registeruser';

@Injectable({
  providedIn: 'root'
})
export class RegisterserviceService {

  constructor(private HttpClient:HttpClient) { }
  userloginurl="http://localhost:1000/user/register";


  registeruser(registeruser:Registeruser):Observable<object>{
    console.log(registeruser)
     return  this.HttpClient.post<Registeruser>(this.userloginurl,registeruser);
   }
 
}
