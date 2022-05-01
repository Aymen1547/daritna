import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/usersManagement/login/login.component';
import { RegisterComponent } from './components/usersManagement/register/register.component';
import { UserComponent } from './components/usersManagement/user/user.component';
import { AuthenticationGuard } from './guard/authentication.guard';


export const routes: Routes = [
    { path: '', pathMatch:'full', redirectTo:'login' },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'user/management', component: UserComponent, canActivate: [AuthenticationGuard] },
];

