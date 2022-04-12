import { RouterModule, Routes } from '@angular/router';
import { UserDashboardComponent } from './components/usersManagement/user-dashboard/user-dashboard.component';


export const routes: Routes = [
    { path: 'users', component: UserDashboardComponent}
];

