import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Admin } from 'src/app/admin';
import { AdminloginserviceService } from 'src/app/services/adminloginservice.service';

@Component({
  selector: 'app-login-admin',
  templateUrl: './login-admin.component.html',
  styleUrls: ['./login-admin.component.css']
})
export class LoginAdminComponent implements OnInit {
  admin : Admin = new Admin();

  constructor(private adminloginservice:AdminloginserviceService,private router:Router) { }

  ngOnInit(): void {
  }
  login= new FormGroup({
    email:new FormControl(''),
    password: new FormControl(''),
    comapanyname: new FormControl('')
  
  })
  loginadminmethod(){
    this.admin.email=this.login.value.email!;
    this.admin.companyName=this.login.value.comapanyname!;
    this.admin.password=this.login.value.password!;
    console.log(this.login.value)
    
    console.log(this.admin);
    this.adminloginservice.adminlogin(this.admin).subscribe(data=>{
      
      this.router.navigate(['/admindashboard']);
      alert("Admin login sucessfully");
    },error=>alert("Invalid Email or Password or company name"))
    this.login.reset();
      
  }

}
