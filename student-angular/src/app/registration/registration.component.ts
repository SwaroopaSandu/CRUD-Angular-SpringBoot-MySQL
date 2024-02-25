import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {

  
  email: String = "";
  password: String = "";



  constructor(private http: HttpClient){

  }



  save(){

    let bodyData = {
      "email":this.email,
      "password": this.password
    };

    this.http.post("http://localhost:8080/register",bodyData,{responseType: 'text'}).subscribe((resultData: any) =>
    {
      console.log(resultData);
      alert("Registered Successfully");
    });
  }



}
