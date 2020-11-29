import { Observable } from 'rxjs';
import { EmployeeService } from './../employee.service';
import{InteractionService} from './../interaction.service';
import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import { DataSource } from '@angular/cdk/table';
@Injectable({
  providedIn: 'root'
})
@Component({
  selector: '[app-employee]',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})

export class EmployeeComponent implements OnInit {
   title="Employee List";
  employee: any[] = [];
  public datasource:any;
  employeecount :number;
   public editid:number;
   public id:number;
   searchterm :string;
  constructor(private employeeService: EmployeeService,private router: Router,private interactionService:InteractionService) { }

  ngOnInit() {
    
    this.employeeService.getemployees().subscribe((data : any[])=>{
        console.log("Employee List data",data);
        this.employee=data;
        this.datasource=new MatTableDataSource(data);
        this.employeecount=this.employee.length;

    });
  }
  
  public deleteEmployee(employeeId){
    console.log(employeeId);
    this.employeeService.deleteemployee(employeeId).subscribe((ret)=>{
          console.log("Deleted Employee with id: ", ret);
          this.ngOnInit();    
    })
}
public editemployee(id){
  this.editid=id;
  this.interactionService.sendEditid(this.editid);
  
  this.router.navigate(["/editEmployee/"+id]);
 
  console.log("clicked on :"+id);

  this.employeeService.getemployee(id).subscribe((ret)=>{
    console.log("Employee details with ID: ", ret);

})

}
 public showdetails(id){
  this.router.navigate(["/details/"+id]);
  this.interactionService.sendEditid(id);
  
 }
}