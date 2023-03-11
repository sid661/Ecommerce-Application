import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { GuardserviceService } from './guardservice.service';

@Injectable({
  providedIn: 'root'
})
export class LoginadminGuard implements CanActivate {
  constructor(private log:GuardserviceService, private r:Router){}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      if(this.log.isAuth){
        return true;
       }
       else{
        this.r.navigateByUrl("loginadmin")
        return false;
       }
  }
  
}
