import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from 'src/models/employee.model';


@Injectable({
  providedIn: 'root',
})
export class EmployeeService {


  constructor(private http: HttpClient) {}

  getEmployees() {
    return this.http.get<Employee[]>("http://localhost:8084/api/employee/getEmployee");
  }

  postEmployee(employee: Employee) {
    return this.http.post<Employee>("", employee);
  }

  deleteEmployee(id: number) {
    return this.http.delete(`http://localhost:8084/api/employee/delete/${id}`);
  }
}