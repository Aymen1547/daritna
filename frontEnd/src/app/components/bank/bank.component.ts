import { Component, OnInit } from '@angular/core';
import {BankCredit} from "../../models/BankCredit";
import {BankCreditService} from "../../services/bankcredit.service";
import {HttpErrorResponse} from "@angular/common/http";
import {NgForm} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-bank',
  templateUrl: './bank.component.html',
  styleUrls: ['./bank.component.css']
})
export class BankComponent implements OnInit {
  public bank : BankCredit[];
  constructor(private bankservice: BankCreditService, private router: Router){}

  ngOnInit() {
    this.getAllBanks();
  }

  public getAllBanks() {
    this.bankservice.getAllBanks().subscribe(data => {
      this.bank=data;
    });
  }

  public updatebank(bankId: number){
    this.router.navigate(['update-banks', bankId] );
  }

  deletebank(id: number){
   this.bankservice.deleteBank(id).subscribe( data => {
      console.log(data);
      this.getAllBanks();
    })
  }


}
