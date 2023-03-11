import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Product } from 'src/app/product';
import { ProductserviceService } from 'src/app/services/productservice.service';
import { UpdateComponent } from '../update/update.component';

@Component({
  selector: 'app-admindashboard',
  templateUrl: './admindashboard.component.html',
  styleUrls: ['./admindashboard.component.css']
})
export class AdmindashboardComponent implements OnInit {

  product:Product[]=[];
  constructor(private service:ProductserviceService,private dialog:MatDialog) { }

  ngOnInit(): void {
    this.service.getAllProduct().subscribe(x=>this.product=x)
  }
  delete(x:any)
  {
    this.service.deleteProduct(x).subscribe(x=>alert("data deleted"))
  }
  update(x:any){
    this.dialog.open(UpdateComponent,
      {
        data:x
      })
    

  }
}
