import { Component, OnInit } from '@angular/core';
import { InteractionService } from '../interaction.service';
import { EmployeeService } from '../employee.service';
import { Employees } from '../employees';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employeedetails',
  templateUrl: './employeedetails.component.html',
  styleUrls: ['./employeedetails.component.css']
})
export class EmployeedetailsComponent implements OnInit {
  employeecount :number=0;
  constructor(private employeeService: EmployeeService ,private router:Router,private interactionService:InteractionService,) { }
  employee:any[]=[];
  public editid:number;
  userModel=new Employees(this.employeecount+1,'','','',+92);
  ngOnInit() {
    this.interactionService.Editid$.subscribe((ID:number)=>{
      console.log("imported id:"+ID);
      this.editid=ID;
      
    });

   console.log(this.editid) 
   this.employeeService.getemployee(this.editid).subscribe((ret:any)=>{
    console.log("Employee details with id: ", ret);
      this.userModel=ret;
      this.employeecount=this.employee.length;
       
});
   

  }
   public back(){

this.router.navigate(["/employees"]);
  }

}
