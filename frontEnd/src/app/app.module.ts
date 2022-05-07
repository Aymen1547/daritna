import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { routes } from './Routing';
import { BankComponent } from './components/bank/bank.component';
import {BankCreditService} from "./services/bankcredit.service";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { SimulationComponent } from './components/simulation/simulation.component';
import { CreateBanksComponent } from './components/bank/create-banks/create-banks.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { UpdateBanksComponent } from './components/bank/update-banks/update-banks.component';



@NgModule({
  declarations: [
    AppComponent,
    BankComponent,
    SimulationComponent,
    CreateBanksComponent,
    UpdateBanksComponent,


  ],
    imports: [
        BrowserModule,
        RouterModule.forRoot(routes),
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
