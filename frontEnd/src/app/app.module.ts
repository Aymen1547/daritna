import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'
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
import { RouterModule } from '@angular/router';

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
    CartComponent
    
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    FormsModule,
    NotificationModule,
    BrowserModule,
    FontAwesomeModule,
    FormsModule,
  ],
  providers: [NotificationService, AuthenticationGuard, AuthenticationService, UserService,
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true } ],
  bootstrap: [AppComponent]
})
export class AppModule { }