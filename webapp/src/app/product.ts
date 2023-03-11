import { Filehandle } from "./filehandle"

export interface Product {
    productId:string,
    productName:string,
    cost:string,
    productImages:Filehandle[]
    // constructor()
    // {
    //     this.productId="";
    //     this.productName="";
    //     this.cost="";
    // }
}
