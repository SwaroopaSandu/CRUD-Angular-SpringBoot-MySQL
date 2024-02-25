import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http:HttpClient) { }

  url = "http://localhost:8080/student";

  fetchStudents(){

    return this.http.get(this.url);

  }

  deleteStudent(id:any){

    return this.http.delete(this.url+"/"+id, { observe: 'response', responseType: 'text' });
  }


  addStudent(body:any){

    return this.http.post(this.url,body,{ observe: 'response', responseType: 'text' });
  }

  editStudent(body:any){
    return this.http.put(this.url,body,{ observe: 'response', responseType: 'text' });
  }

}
