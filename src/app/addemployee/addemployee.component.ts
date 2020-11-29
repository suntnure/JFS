import { Employees } from './../employees';
import { Component, OnInit } from '@angular/core';
import { EmployeeService } from './../employee.service';
import{EmployeedataService} from './../employeedata.service';
import { FormBuilder, FormGroup , FormControl } from '@angular/forms';
import {NgForm} from '@angular/forms';
import  {  FormsModule,  ReactiveFormsModule  }  from  '@angular/forms';
import { Router } from "@angular/router";


@Component({
  selector: 'app-addemployee',
  templateUrl: './addemployee.component.html',
  styleUrls: ['./addemployee.component.css']
})
export class AddemployeeComponent implements OnInit {

  employee: any[] = [];
  newemployee: any[]=[];
  employeecount :number;
  

    constructor(private employeeService: EmployeeService ,private employeedataService:EmployeedataService,private router: Router) {
    
   }
   userModel=new Employees(this.employeecount+1,'','','',+92);
   
  ngOnInit() {
    this.employeeService.getemployees().subscribe((data : any[])=>{
      console.log("Employee List data",data);
      this.employee=data;
      this.employeecount=this.employee.length;
});
  }

  
  public createEmployee(newemployee){
   this.employeeService.addemployee(newemployee).subscribe((ret)=>{
     console.log("new employee added to the database")
   });
}
onSubmit() {
  console.log("form data : ",this.userModel);
  this.employeeService.addemployee(this.userModel).subscribe((ret :any[])=>{
    console.log("new employee created: ", ret);
    this.newemployee=ret;
    this.employee.push(ret);
});
this.router.navigate(['employees']);
}
}
