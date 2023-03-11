import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ProductserviceService } from 'src/app/services/productservice.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  constructor(public dailog: MatDialogRef<UpdateComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,private service:ProductserviceService) { }

    updateForm=new FormGroup(
      {
        productName:new FormControl(""),
        cost:new FormControl("")
      }
    )

  ngOnInit(): void {
    this.updateForm.get("productName")?.setValue(this.data.productName);
    this.updateForm.get("cost")?.setValue(this.data.cost);
  }

  update()
  {
    this.data.productName=this.updateForm.value.productName
    this.data.cost=this.updateForm.value.cost;
    this.service.update(this.data).subscribe(x=>alert("data updated"))
  }

}
