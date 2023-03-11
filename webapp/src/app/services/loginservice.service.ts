import { ObserversModule } from '@angular/cdk/observers';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  constructor(private HttpClient:HttpClient) { }
   userloginurl="http://localhost:1000/userauth/login";


  loginuser(user:User):Observable<object>{
   console.log(user)
    return  this.HttpClient.post<User>(this.userloginurl,user);
  }

}
