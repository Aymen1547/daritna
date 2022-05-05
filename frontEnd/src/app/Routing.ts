import { NgModule } from '@angular/core';
import { Router, RouterModule, Routes } from '@angular/router';
import { CancelComponent } from './components/cancel/cancel.component';
import { CartComponent } from './components/cart/cart.component';
import { CheckoutComponent } from './components/checkout/checkout.component';

import { ProductDetailComponent } from './components/product-detail/product-detail.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { SuccessComponent } from './components/success/success.component';



const routes: Routes = [
    
   
    {path: 'shop', component: ProductListComponent},
    {path: 'shop/:term', component: ProductListComponent},
    {path: 'shop/products/:id', component: ProductDetailComponent},
    {path: 'cart', component: CartComponent},
    {path: 'checkout',component: CheckoutComponent},
    {path: 'cancel', component: CancelComponent },
    {path: 'success', component: SuccessComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
    constructor (router : Router) {}
}
