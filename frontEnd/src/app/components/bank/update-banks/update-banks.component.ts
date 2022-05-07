import { Component, OnInit } from '@angular/core';
import {BankCredit} from "../../../models/BankCredit";
import {BankCreditService} from "../../../services/bankcredit.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-update-banks',
  templateUrl: './update-banks.component.html',
  styleUrls: ['./update-banks.component.css']
})
export class UpdateBanksComponent implements OnInit {

  id: number;
  bank: BankCredit = new BankCredit();
  constructor(private bankService: BankCreditService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.bankService.getBankById(this.id).subscribe(data => {
      this.bank = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.bankService.updatebanks(this.id, this.bank).subscribe( data =>{
        this.goToBankList();
      }
      , error => console.log(error));
  }

  goToBankList(){
    this.router.navigate(['/banks']);
  }

}
