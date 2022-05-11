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
import {BankComponent} from "./components/bank/bank.component";

import {CreateBanksComponent} from "./components/bank/create-banks/create-banks.component";
import {UpdateBanksComponent} from "./components/bank/update-banks/update-banks.component";
import {SimulationComponent} from "./components/simulation/simulation.component";

import { ProductDetailComponent } from './components/product-detail/product-detail.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { SuccessComponent } from './components/success/success.component';
import { AppointmentListComponent } from './components/appointment-list/appointment-list.component';
import { CreateAppointmentComponent } from './components/create-appointment/create-appointment.component';
import { LocationDashboardComponent } from './components/locationsManagement/location-dashboard/location-dashboard.component';
import { ReclamationDashboardComponent } from './components/reclamationsManagement/reclamation-dashboard/reclamation-dashboard.component';
import { AuthorizationGuard } from './guard/authorization.guard';

export const routes: Routes = [
    { path: '', pathMatch:'full', redirectTo:'home' },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'user/management', component: UserComponent, canActivate: [AuthenticationGuard] },
    { path: 'home', component: HomeComponent },
    {path: 'shop', component: ProductListComponent, canActivate: [AuthenticationGuard]},
    {path: 'shop/:term', component: ProductListComponent, canActivate: [AuthenticationGuard]},
    {path: 'shop/products/:id', component: ProductDetailComponent, canActivate: [AuthenticationGuard]},
    {path: 'cart', component: CartComponent, canActivate: [AuthenticationGuard]},
    {path: 'checkout',component: CheckoutComponent, canActivate: [AuthenticationGuard]},
    {path: 'cancel', component: CancelComponent },
    {path: 'success', component: SuccessComponent },
  {path: 'banks', component: BankComponent, canActivate: [AuthenticationGuard, AuthorizationGuard],}, 
  {path: 'create-banks', component: CreateBanksComponent, canActivate: [AuthenticationGuard, AuthorizationGuard],}, 
  {path: 'update-banks/:id', component: UpdateBanksComponent, canActivate: [AuthenticationGuard, AuthorizationGuard],}, 
  {path: 'simulation', component: SimulationComponent, canActivate: [AuthenticationGuard]}, 
  {path: 'appointments', component: AppointmentListComponent, canActivate: [AuthenticationGuard, AuthorizationGuard]}, 
  {path: 'create-appointment', component: CreateAppointmentComponent, canActivate: [AuthenticationGuard]},
  { path: 'locations', component: LocationDashboardComponent, canActivate: [AuthenticationGuard, AuthorizationGuard],},
  { path: 'reclamations', component: ReclamationDashboardComponent, canActivate: [AuthenticationGuard, AuthorizationGuard],},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
    constructor (router : Router) {}
}