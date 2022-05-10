import { Router, RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/usersManagement/login/login.component';
import { RegisterComponent } from './components/usersManagement/register/register.component';
import { UserComponent } from './components/usersManagement/user/user.component';
import { AuthenticationGuard } from './guard/authentication.guard';
import { CartComponent } from './components/cart/cart.component';
import { CancelComponent } from './components/cancel/cancel.component';
import { CheckoutComponent } from './components/checkout/checkout.component';

import { ProductDetailComponent } from './components/product-detail/product-detail.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { SuccessComponent } from './components/success/success.component';

export const routes: Routes = [
    { path: '', pathMatch:'full', redirectTo:'home' },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'user/management', component: UserComponent, canActivate: [AuthenticationGuard] },
    { path: 'home', component: HomeComponent },
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
