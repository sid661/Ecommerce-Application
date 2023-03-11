import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../product';

@Injectable({
  providedIn: 'root'
})
export class ProductserviceService {

  constructor(private http:HttpClient) { }

  public addproduct(product:FormData){
    return this.http.post<Product>("http://localhost:1000/product/add",product);

  }
  public getAllProduct(){
    return this.http.get<Product[]>("http://localhost:1000/product/all");
  }

  public deleteProduct(product:any)
  {
    return this.http.delete("http://localhost:1000/product/delete/"+product);
  }
  public update(product:Product){
    return this.http.put<Product>("http://localhost:1000/product/update",product);
  }
}
