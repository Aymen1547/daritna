/*import { RouterModule, Routes } from '@angular/router';

import { LocationDashboardComponent } from './components/locationsManagement/location-dashboard/location-dashboard.component';

import { ReclamationDashboardComponent } from './components/reclamationsManagement/reclamation-dashboard/reclamation-dashboard.component';*/

import { RouterModule, Routes } from '@angular/router';

import { LocationDashboardComponent } from './components/locationsManagement/location-dashboard/location-dashboard.component';
import { ReclamationDashboardComponent } from './components/reclamationsManagement/reclamation-dashboard/reclamation-dashboard.component';

export const routes: Routes = [
    { path: 'locations', component: LocationDashboardComponent},
    { path: 'reclamations', component: ReclamationDashboardComponent}
];

