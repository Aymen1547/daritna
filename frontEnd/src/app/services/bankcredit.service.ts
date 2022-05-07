import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {BankCredit} from "../models/BankCredit";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class BankCreditService {

  private apiServerUrl = environment.apiServerUrl;
  constructor(private http: HttpClient){}

  public getAllBanks(): Observable<BankCredit[]> {
    return this.http.get<BankCredit[]>(`${this.apiServerUrl}/api/BankCredit/retrieveAllBank`);
  }
  getBankById(bankId: number): Observable<BankCredit>{
    return this.http.get<BankCredit>(`${this.apiServerUrl}/api/BankCredit/retrieveBank/${bankId}`);
  }
  public addBank(bank: BankCredit): Observable<BankCredit> {
    return this.http.post<BankCredit>(`${this.apiServerUrl}/api/BankCredit/addBank`, bank);
  }
  public updateBank(bank: BankCredit): Observable<BankCredit> {
    return this.http.put<BankCredit>(`${this.apiServerUrl}/api/BankCredit/updateBank`, bank);
  }
  updatebanks(bankId: number, banks: BankCredit): Observable<Object>{
    return this.http.put(`${this.apiServerUrl}/api/BankCredit/bank/${bankId}`, banks);
  }
  public deleteBank(bankId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/api/BankCredit/removeBank/${bankId}`);
  }
  getBankByname(nom: string){
    return this.http.get<string>(`${this.apiServerUrl}/api/BankCredit/RechercheBank/${nom}`);
  }

}
