import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Location } from 'src/app/models/Location';
import { Reclamation } from 'src/app/models/Reclamation';
import { ReclamationService } from 'src/app/services/reclamationService/reclamation.service';
import { SubSink } from 'subsink';

@Component({
  selector: 'app-reclamation-dashboard',
  templateUrl: './reclamation-dashboard.component.html',
  styleUrls: ['./reclamation-dashboard.component.css']
})
export class ReclamationDashboardComponent implements OnInit {

  public reclamations!: Reclamation[];
  public reclamation: Reclamation= {
    id: 0,
    contenu: "",
    object: "",
    date: new Date(),
    type: "",
    location: location,
  };
  private subs = new SubSink();

  constructor(private service: ReclamationService) { }

  ngOnInit(){
    this.getReclamation();
  }

  public getReclamation(): void {
    this.subs.add(
      this.service.getReclamations().subscribe(
        (response) => {
          if (response.body != null) {

            this.reclamations = response.body;
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
      this.service.addReclamation(addForm.value).subscribe(

        (response) => {
          addForm.onReset();
        },
        (error: HttpErrorResponse) => {
          console.log(error);
        }
      )
    );
  }

  public setReclamation(reclamation: Reclamation) {
    this.reclamation = reclamation;
  }

public onUpdate(editForm: NgForm){
  
  editForm.value.id = this.reclamation.id;

  if (editForm.value.contenu == '') {
    editForm.value.contenu = this.reclamation.contenu;
  }
  if (editForm.value.object == '') {
    editForm.value.object = this.reclamation.object;
  }
  if (editForm.value.date == '') {
    editForm.value.date = this.reclamation.date;
  }
  if (editForm.value.type == '') {
    editForm.value.type = this.reclamation.type;
  }
  if (editForm.value.location == '') {
    editForm.value.location = this.reclamation.location;
  }
  this.subs.add(
    this.service.updateReclamation(editForm.value).subscribe(
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

  public deleteReclamation(id: number) {
    this.subs.add(
      this.service.deleteReclamation(id).subscribe(
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