import { EmployeeComponent } from './../employee/employee.component';
import { Employees } from './../employees';
import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { EmployeeService } from './../employee.service';
import{EmployeedataService} from './../employeedata.service';
import { FormBuilder, FormGroup , FormControl } from '@angular/forms';
import {NgForm} from '@angular/forms';
import  {  FormsModule,  ReactiveFormsModule  }  from  '@angular/forms';
import { Router } from "@angular/router";
import{InteractionService} from './../interaction.service';

@Component({
  selector: 'app-editemployee',
  templateUrl: './editemployee.component.html',
  styleUrls: ['./editemployee.component.css']
})
export class EditemployeeComponent implements OnInit {

  employee: any[] = [];
  newemployee: any[]=[];
  employeecount :number=0;
  

    constructor(private employeeService: EmployeeService ,private interactionService:InteractionService,private employeedataService:EmployeedataService,private router: Router,private employeeComponent:EmployeeComponent) {
    
   }
   userModel=new Employees(this.employeecount+1,'','','',+92);
   public editid:number;
    
  ngOnInit() {
  
    this.interactionService.Editid$.subscribe((ID:number)=>{
      console.log("imported id:"+ID);
      this.editid=ID;
      
    });

   console.log(this.editid) 
   this.employeeService.getemployee(this.editid).subscribe((ret:any)=>{
    console.log("Employee details with id: ", ret);
      this.userModel=ret;

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
