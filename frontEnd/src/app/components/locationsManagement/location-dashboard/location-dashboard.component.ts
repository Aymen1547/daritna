import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Location } from 'src/app/models/Location';
import { LocationService } from 'src/app/services/locationService/location.service';
import { SubSink } from 'subsink';

@Component({
  selector: 'app-location-dashboard',
  templateUrl: './location-dashboard.component.html',
  styleUrls: ['./location-dashboard.component.css']
})
export class LocationDashboardComponent implements OnInit {

  public locations!: Location[];
  public location: Location= {
    id: 0,
    titre: "",
    lieu: "",
    description: "",
    dated: new Date(),
    datef: new Date(),
    prix: 3,
  };
  private subs = new SubSink();

  constructor(private service: LocationService) { }

  ngOnInit(){
    this.getLocation();
  }

  public getLocation(): void {
    this.subs.add(
      this.service.getLocations().subscribe(
        (response) => {
          if (response.body != null) {

            this.locations = response.body;
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
      this.service.addLocation(addForm.value).subscribe(

        (response) => {
          addForm.onReset();
        },
        (error: HttpErrorResponse) => {
          console.log(error);
        }
      )
    );
  }

  public setLocation(location: Location) {
    this.location = location;
  }

public onUpdate(editForm: NgForm){
  
  editForm.value.id = this.location.id;

  if (editForm.value.titre == '') {
    editForm.value.titre = this.location.titre;
  }
  if (editForm.value.lieu == '') {
    editForm.value.lieu = this.location.lieu;
  }
  if (editForm.value.description == '') {
    editForm.value.description = this.location.description;
  }
  if (editForm.value.dated == '') {
    editForm.value.dated = this.location.dated;
  }
  if (editForm.value.datef == '') {
    editForm.value.datef = this.location.datef;
  }
  if (editForm.value.prix == '') {
    editForm.value.prix = this.location.prix;
  }
  this.subs.add(
    this.service.updateLocation(editForm.value).subscribe(
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

  public deleteLocation(id: number) {
    this.subs.add(
      this.service.deleteLocation(id).subscribe(
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