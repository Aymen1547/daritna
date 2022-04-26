import { RouterModule, Routes } from '@angular/router';

import { LocationDashboardComponent } from './components/locationsManagement/location-dashboard/location-dashboard.component';

export const routes: Routes = [
    { path: 'locations', component: LocationDashboardComponent}
];

