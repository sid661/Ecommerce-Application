import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { Filehandle } from 'src/app/filehandle';
import { Product } from 'src/app/product';
import { ProductserviceService } from 'src/app/services/productservice.service';

@Component({
  selector: 'app-addnewproduct',
  templateUrl: './addnewproduct.component.html',
  styleUrls: ['./addnewproduct.component.css']
})
export class AddnewproductComponent implements OnInit {
  product: Product = {
    productId: '',
    productName: '',
    cost: '',
    productImages: []
  }
  constructor(private productservice: ProductserviceService, private sanatizer: DomSanitizer) { }

  ngOnInit(): void {
  }

  addProduct(productForm: NgForm) {

const productFormData = this.prepareFormData(this.product);

    this.productservice.addproduct(productFormData).subscribe(
      (response: Product) => {
        console.log(response);
      }, (error: HttpErrorResponse) => {
        console.log(error);
      }
    );
    console.log(this.product);

  }



  prepareFormData(product: Product): FormData {
    const formData = new FormData();
    formData.append(
      'product',
      new Blob([JSON.stringify(product)], { type: 'application/json' })
    );

    for (var i = 0; i < product.productImages.length; i++) {
      formData.append(
        'image',
        product.productImages[i].file,
        product.productImages[i].file.name
      );
    }
     return formData;
  }


  onFileSelected(event: any) {
    if (event.target.files) {
      const file = event.target.files[0];


      const filehandle: Filehandle = {
        file: file,
        url: this.sanatizer.bypassSecurityTrustUrl(
          window.URL.createObjectURL(file))
      }
      this.product.productImages.push(filehandle);
    }

  }
}
