import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GuardserviceService {
  isAuth= false ;
  redirect: string | null=null;
  constructor() { }
}
