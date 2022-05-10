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
  {path: 'banks', component: BankComponent},
  {path: 'create-banks', component: CreateBanksComponent},
  {path: 'update-banks/:id', component: UpdateBanksComponent},
  {path: 'simulation', component: SimulationComponent},
  {path: 'appointments', component: AppointmentListComponent},
  {path: 'create-appointment', component: CreateAppointmentComponent},
  { path: 'locations', component: LocationDashboardComponent},
  { path: 'reclamations', component: ReclamationDashboardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
    constructor (router : Router) {}
}