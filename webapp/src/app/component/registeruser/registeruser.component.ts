import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Registeruser } from 'src/app/registeruser';
import { RegisterserviceService } from 'src/app/services/registerservice.service';

@Component({
  selector: 'app-registeruser',
  templateUrl: './registeruser.component.html',
  styleUrls: ['./registeruser.component.css']
})
export class RegisteruserComponent implements OnInit {
  registeruser:Registeruser = new Registeruser();
  constructor(private registerservice: RegisterserviceService,private router:Router) { }

  register= new FormGroup({
    email:new FormControl(''),
    firstname:new FormControl(''),
    lastname:new FormControl(''),
    password: new FormControl(''),
    phoneno:new FormControl('')
  })
  ngOnInit(): void {
  }
  registerusermethod(){
    this.registeruser.email=this.register.value.email!;
    this.registeruser.firstName=this.register.value.firstname!;
    this.registeruser.lastName=this.register.value.lastname!;
    this.registeruser.password=this.register.value.password!;
    this.registeruser.phoneNumber=this.register.value.phoneno!;
    console.log(this.register.value)
    
    console.log(this.registeruser);
    this.registerservice.registeruser(this.registeruser).subscribe(data=>{
      alert("created new account");
    })
    this.register.reset();
    


  }
}
