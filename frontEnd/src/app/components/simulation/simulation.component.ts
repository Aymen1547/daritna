import { Component, OnInit } from '@angular/core';
import {SimulationDeCredit} from "../../models/SimulationCredit";
import {BankCreditService} from "../../services/bankcredit.service";
import {Router} from "@angular/router";
import {SimulationService} from "../../services/simulation.service";
import {BankCredit} from "../../models/BankCredit";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-simulation',
  templateUrl: './simulation.component.html',
  styleUrls: ['./simulation.component.css']
})
export class SimulationComponent implements OnInit {

  SimulForm: FormGroup;
  submitted = false;
  banklist:any;
  result='';
  s:any;

  sim : SimulationDeCredit =new SimulationDeCredit();
  constructor( private  simulation:SimulationService,
  private router: Router, private formBuilder: FormBuilder) {}


  saveSimulation(){
    this.simulation.addSimulation(this.sim).subscribe( data =>{
        console.log(data);
        this.oncalcul()
      },
      error =>         this.oncalcul()
    );
  }

   oncalcul ()
  {

      this.simulation.calcul(this.sim).subscribe(data => {
          this.result = data.toString();
        },
        error => console.log(error));
  }

  ngOnInit(): void {
    this.ShowAll();
    this.SimulForm=this.formBuilder.group({
      bank:['',Validators.required],
      salaire:[null,Validators.required],
      montant:[null,Validators.required],
      duree:[null,Validators.compose([Validators.required,Validators.max(240),Validators.min(12)])],
      acceptTerms: [false, Validators.requiredTrue]
      }
    );
  }
  get f() { return this.SimulForm.controls; }

  ShowAll(){
    this.simulation.getAllBanksByName().subscribe(data =>
      {
        console.log(data);
        this.banklist=data;
      }
    )

  }
  onSubmit(){
    this.submitted = true;
    this.saveSimulation();
    if (this.SimulForm.invalid)
    {
      return;
    }

  }



}
