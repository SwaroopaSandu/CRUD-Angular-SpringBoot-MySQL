import { Component } from '@angular/core';
import { StudentService } from '../student.service';
import { HttpClient } from '@angular/common/http';
import { Student } from '../registration/student';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {


  constructor(private ms:StudentService,private http:HttpClient){

  }


  formHeader: string = "Add student";
  stuId: string = "";
  name: string = "";
  address: string = "";
  contact: string = "";
  showForm:boolean = false;
  id:any = null;


  students: any = null;

  ngOnInit(){
    this.getDetails();
  }

  getDetails() {
  return this.ms.fetchStudents().subscribe(
      (results)=>{
        this.students = results;
        console.log(results);
      },
      (error)=>{
        console.log(error)
      })
  }

  

  deleteStudent(id: string) {
    console.log("Entered in this method of delete student");
    this.ms.deleteStudent(id).subscribe(
      (res) => {
        console.log(res);
        this.getDetails();
      },
      (error) => {
        console.error("Failed to delete student:", error);
      }
    );
  }


  openForm(data:any = null){
    this.showForm=true;
    if(data){
      this.stuId = data.stuId;
      this.name = data.name;
      this.address =data.address;
      this.contact = data.contact;
      this.id = data.id;
      this.formHeader = "Edit Student";
    }
    else{
      this.clearForm();
      this.formHeader = "Add Student";
    }
  }
  

  saveStudent(){

    this.showForm = false;
    let body = {
      stuId:this.stuId,
      name:this.name,
      address:this.address,
      contact:this.contact
    }

    if(this.stuId){
      body['stuId'] = this.stuId
      this.ms.editStudent(body).subscribe(
        (res)=>{
          this.getDetails()
        }
      )
    }
    else{
      this.ms.addStudent(body).subscribe(
        (res)=>{
          this.getDetails()
        }
      )
    }


  }

  closeForm(){
    this.showForm=false;
    this.clearForm();
  }

  clearForm(){
  
      this.stuId = "";
      this.name = "";
      this.address ="";
      this.contact = "";
  }


}