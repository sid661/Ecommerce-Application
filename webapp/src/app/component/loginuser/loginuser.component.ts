import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { LoginserviceService } from 'src/app/services/loginservice.service';
import { User } from 'src/app/user';


@Component({
  selector: 'app-loginuser',
  templateUrl: './loginuser.component.html',
  styleUrls: ['./loginuser.component.css']
})
export class LoginuserComponent implements OnInit {


  user:User =new User();
  constructor(private LoginserviceService :LoginserviceService,private router:Router) { }

 
 login= new FormGroup({
  email:new FormControl(''),
  password: new FormControl('')

 })
  ngOnInit(): void {
  }

  loginusermethod(){
    this.user.email=this.login.value.email!;
    this.user.password=this.login.value.password!;
    console.log(this.login.value)
    
    console.log(this.user);
    this.LoginserviceService.loginuser(this.user).subscribe(data=>{
      
      this.router.navigate(['/userdashboard']);
      alert("login sucessfully");
    },error=>alert("Invalid Email or Password"))
    this.login.reset();
      
  }
  
  
  }
