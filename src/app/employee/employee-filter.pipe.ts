import {Pipe, PipeTransform} from '@angular/core';
import {Employees} from '../employees';

@Pipe({
    name:'employeeFilter'
})
export class EmployeeFilterPipe implements PipeTransform{
 transform(employees:Employees[],searchterm:string):Employees[]{

    if(!employees||!searchterm){
        return employees;
    }
    return employees.filter(employee=>
        employee.name.toLowerCase().indexOf(searchterm.toLowerCase()) !=-1);
 }
}