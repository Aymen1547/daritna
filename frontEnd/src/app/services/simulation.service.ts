import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {BankCredit} from "../models/BankCredit";
import {SimulationDeCredit} from "../models/SimulationCredit";


@Injectable({
  providedIn: 'root'
})
export class SimulationService {

  private apiServerUrl = environment.apiServerUrl;
  constructor(private http: HttpClient){}

  public getAllBanksByName(): Observable<BankCredit[]> {
    return this.http.get<BankCredit[]>(`${this.apiServerUrl}/api/BankCredit/getAllBankByNames`);
  }
  public addSimulation(simul: SimulationDeCredit): Observable<SimulationDeCredit> {
    return this.http.put<SimulationDeCredit>(`${this.apiServerUrl}/api/SimulationDeCredit/updateSimulation`, simul);
  }
  public calcul(bank: SimulationDeCredit){

    return this.http.post<number>(`${this.apiServerUrl}/api/BankCredit/calculate`, bank);
  }

}
