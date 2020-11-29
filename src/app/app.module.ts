import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Pipe } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeComponent } from './employee/employee.component';
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';  
import {EmployeedataService} from './employeedata.service';
import { HttpClientModule } from '@angular/common/http';
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import { environment } from './../environments/environment';

import { AddemployeeComponent } from './addemployee/addemployee.component';

import  {  FormsModule,  ReactiveFormsModule  }  from  '@angular/forms';
import { EditemployeeComponent } from './editemployee/editemployee.component';
import {EmployeedetailsComponent} from './employeedetails/employeedetails.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {EmployeeFilterPipe} from './employee/employee-filter.pipe';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    
    AddemployeeComponent,
    EditemployeeComponent,
    EmployeedetailsComponent,
    EmployeeFilterPipe
    
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    InMemoryWebApiModule.forRoot(EmployeedataService),
    HttpClientModule,
    environment.production ?
    [] : HttpClientInMemoryWebApiModule.forRoot(EmployeedataService),
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
