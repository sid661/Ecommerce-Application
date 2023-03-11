import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Registeradmin } from 'src/app/registeradmin';
import { Registeruser } from 'src/app/registeruser';
import { AdminregisterserviceService } from 'src/app/services/adminregisterservice.service';

@Component({
  selector: 'app-registeradmin',
  templateUrl: './registeradmin.component.html',
  styleUrls: ['./registeradmin.component.css']
})
export class RegisteradminComponent implements OnInit {
  registeradmin:Registeradmin = new Registeradmin();
  constructor(private registeradminservice: AdminregisterserviceService,private router:Router) { }

  register= new FormGroup({
    email:new FormControl(''),
    comapanyname:new FormControl(''),
    firstname:new FormControl(''),
    lastname:new FormControl(''),
    password: new FormControl(''),
    phoneno:new FormControl('')
  })
  ngOnInit(): void {
  }
  registeradminmethod(){
    this.registeradmin.email=this.register.value.email!;
    this.registeradmin.companyName=this.register.value.comapanyname!;
    this.registeradmin.firstName=this.register.value.firstname!;
    this.registeradmin.lastName=this.register.value.lastname!;
    this.registeradmin.password=this.register.value.password!;
    this.registeradmin.phoneNumber=this.register.value.phoneno!;
    console.log(this.register.value)
    
    console.log(this.registeradmin);
    this.registeradminservice.registeradmin(this.registeradmin).subscribe(data=>{
      alert("created new account");
    })
    this.register.reset();
    


  }

}
