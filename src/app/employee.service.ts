
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  SERVER_URL: string = 'api/';

  constructor(private httpClient: HttpClient) { }

  public getemployees(){ 
       return this.httpClient.get(this.SERVER_URL + 'employees');
       console.log("employee sevice completed");
  }
  public addemployee(employee: { id:number,name: string, location: string, email: string, mobile: number}){
    return this.httpClient.post(`${this.SERVER_URL + 'employees'}`, employee)
}
public deleteemployee(employeeId){
  console.log("deleting employe throw service"+employeeId);
  console.log(`${this.SERVER_URL + 'employees'}/${employeeId}`);
  return this.httpClient.delete(`${this.SERVER_URL + 'employees'}/${employeeId}`)
  
}
public updateemployee(employee: {id: number, name: string, location: string, email: string, mobile: number}){
  return this.httpClient.put(`${this.SERVER_URL + 'employees'}}/${employee.id}`, employee)
}
public getemployee(employeeId){
  return this.httpClient.get(`${this.SERVER_URL + 'employees'}/${employeeId}`); 
}

}
