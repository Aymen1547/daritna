import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { abonnement } from '../models/Abonnement';
import { abonnementService } from '../service/abonnement.service';
import { SubSink } from 'subsink';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-abonnement',
  templateUrl: './abonnement.component.html',
  styleUrls: ['./abonnement.component.css']
})
export class AbonnementComponent implements OnInit {
  abonnements!:Observable<abonnement[]>;
  public abonnement: abonnement= {
    id: 0,
    duree: 0,
    prix: 0,
    type: "",
   
  };
  private subs = new SubSink();


  constructor(private service:abonnementService) { }

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData() {
    this.abonnements = this.service.retrieveAll();
  }
  public retrieveAll(): void {
    this.subs.add(
      this.service.retrieveAll().subscribe(
        (response) => {
          if (response.body != null) {

            this.abonnements = response.body;
            // console.log(response.body);
          }
        },
        (error: HttpErrorResponse) => {
          console.log(error);
        }
      )
    );
  }
  onAddUser(addForm: NgForm) {
 
    this.subs.add(
      this.service.add(addForm.value).subscribe(

        (response) => {
          addForm.onReset();
        },
        (error: HttpErrorResponse) => {
          console.log(error);
        }
      )
    );
  }
  public setAbonnement(abonnement: abonnement) {
    this.abonnement= abonnement;
  }
  public onUpdate(editForm: NgForm){
  
    editForm.value.id = this.abonnement.id;
  
    if (editForm.value.duree == '') {
      editForm.value.duree = this.abonnement.duree;
    }
    if (editForm.value.prix == '') {
      editForm.value.prix = this.abonnement.prix;
    }
    if (editForm.value.type == '') {
      editForm.value.type = this.abonnement.type;
    }
    
    this.subs.add(
      this.service.update(editForm.value).subscribe(
        (response) => {
          console.log(response);
          // location.reload();
        },
        (error: HttpErrorResponse) => {
          console.log(error);
        }
      )
    );
  }

  public delete(id: number) {
    this.subs.add(
      this.service.delete(id).subscribe(
        (response) => {
          console.log(response);
          location.reload();
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      )
    );
  }

}
