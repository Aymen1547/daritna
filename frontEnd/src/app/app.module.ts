import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { AppRoutingModule } from './Routing';
import { AppComponent } from './app.component';
import { routes } from './Routing';
import { AuthenticationService } from './services/userServices/authentication.service';
import { UserService } from './services/userServices/user.service';
import { NotificationService } from './services/userServices/notification.service';
import { RegisterComponent } from './components/usersManagement/register/register.component';
import { LoginComponent } from './components/usersManagement/login/login.component';
import { UserComponent } from './components/usersManagement/user/user.component';
import { NotificationModule } from './notification/notification.module';
import { AuthInterceptor } from './interceptor/auth.interceptor';
import { AuthenticationGuard } from './guard/authentication.guard';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { AdminBarComponent } from './components/admin-bar/admin-bar.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { ProductDetailComponent } from './components/product-detail/product-detail.component';
import { CartComponent } from './components/cart/cart.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { SuccessComponent } from './components/success/success.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { CancelComponent } from './components/cancel/cancel.component';

import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';
import { BankComponent } from './components/bank/bank.component';
import { CreateBanksComponent } from './components/bank/create-banks/create-banks.component';
import { UpdateBanksComponent } from './components/bank/update-banks/update-banks.component';
import { SimulationComponent } from './components/simulation/simulation.component';
import { AppointmentListComponent } from './components/appointment-list/appointment-list.component';
import { CreateAppointmentComponent } from './components/create-appointment/create-appointment.component';
import { LocationDashboardComponent } from './components/locationsManagement/location-dashboard/location-dashboard.component';
import { ReclamationDashboardComponent } from './components/reclamationsManagement/reclamation-dashboard/reclamation-dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    UserComponent,
    NavbarComponent,
    HomeComponent,
    AdminBarComponent,
    ProductListComponent,
    ProductDetailComponent,
    CheckoutComponent,
    CancelComponent,
    SuccessComponent,
    CartComponent,
    BankComponent,
    SimulationComponent,
    CreateBanksComponent,
    UpdateBanksComponent,
    AppointmentListComponent,
    CreateAppointmentComponent,
    LocationDashboardComponent,
    ReclamationDashboardComponent,

   
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    FormsModule,
    NotificationModule,
    BrowserModule,
    FontAwesomeModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatButtonModule,
    ReactiveFormsModule
  ],
  providers: [NotificationService, AuthenticationGuard, AuthenticationService, UserService,
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true } ],
  bootstrap: [AppComponent]
})
export class AppModule { }