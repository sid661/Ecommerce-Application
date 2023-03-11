import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Registeradmin } from '../registeradmin';

@Injectable({
  providedIn: 'root'
})
export class AdminregisterserviceService {

  constructor(private HttpClient:HttpClient) { }
  userloginurl="http://localhost:1000/admin/register";


  registeradmin(registeradmin:Registeradmin):Observable<object>{
    console.log(registeradmin)
     return  this.HttpClient.post<Registeradmin>(this.userloginurl,registeradmin);
   }
}
