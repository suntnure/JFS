import { EmployeeComponent } from './employee/employee.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EditemployeeComponent } from './editemployee/editemployee.component';
import {AddemployeeComponent} from  './addemployee/addemployee.component';
import{EmployeedetailsComponent} from './employeedetails/employeedetails.component';
const routes: Routes = [
  {path: 'employees',component: EmployeeComponent},
  {path:'editEmployee/:id',component: EditemployeeComponent},
  {path:'addemployee',component:AddemployeeComponent},
  {path:'details/:id',component:EmployeedetailsComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
   _contextPath = "${pageContext.request.contextPath}";

}
