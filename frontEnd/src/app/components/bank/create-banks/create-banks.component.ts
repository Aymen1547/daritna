import { Component, OnInit } from '@angular/core';

import {BankCreditService} from "../../../services/bankcredit.service";
import {Router} from "@angular/router";
import {BankCredit} from "../../../models/BankCredit";
import {SimulationService} from "../../../services/simulation.service";
import {SimulationDeCredit} from "../../../models/SimulationCredit";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";


@Component({
  selector: 'app-create-banks',
  templateUrl: './create-banks.component.html',
  styleUrls: ['./create-banks.component.css']
})
export class CreateBanksComponent implements OnInit {

  submitted = false;
  BankGroupe: FormGroup;
  bank : BankCredit =new BankCredit();
  constructor(private bankService: BankCreditService,private  simulation:SimulationService,
              private router: Router , private formBuilder: FormBuilder) { }

  savebanks(){
      this.bankService.addBank(this.bank).subscribe(data => {
          console.log(data);
        },
        error => console.log(error));

  }

  ngOnInit(): void {
    this.BankGroupe=this.formBuilder.group({
        bank:['',Validators.required],
        taux:[null,Validators.required],
      }
    );
  }
  get f() { return this.BankGroupe.controls; }
  goToBankList(){
    this.router.navigate(['/banks']);
  }
  onSubmit(){
    this.submitted = true;
    this.savebanks();
    if (this.BankGroupe.invalid)
    {
      return;
    }
    this.goToBankList();
  }
}
