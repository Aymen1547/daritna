import { RouterModule, Routes } from '@angular/router';
import {BankComponent} from "./components/bank/bank.component";

import {CreateBanksComponent} from "./components/bank/create-banks/create-banks.component";
import {UpdateBanksComponent} from "./components/bank/update-banks/update-banks.component";
import {SimulationComponent} from "./components/simulation/simulation.component";


export const routes: Routes = [
  {path: 'banks', component: BankComponent},
  {path: 'create-banks', component: CreateBanksComponent},
  {path: 'update-banks/:id', component: UpdateBanksComponent},
  {path: 'simulation', component: SimulationComponent},
  {path: '', redirectTo: 'banks', pathMatch: 'full'},
];

