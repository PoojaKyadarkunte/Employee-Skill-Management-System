import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Employee } from 'src/models/employee.model';


import { EmployeeService } from './services/employee.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit, AfterViewInit {
  starRating = 0;
  // @ViewChild('fileInput') fileInput: any;
  @ViewChild('addEmployeeButton') addEmployeeButton: any;
  title = 'EmployeeCRUD';

  employeeForm: FormGroup;

  employees: Employee[];
  employeesToDisplay: Employee[];
  educationOptions = [
    '1 month',
    '2 month',
    '3 month',
    '6 month',
    '1 year',
    '2 year'
  ];

  ratingList = ['1', '2', '3','4','5']; 
performanceList = ['Bad Performance','Very Bad Performance','Good Performance','Extremely Good Performance','Excellent!','No feedback'];
completedItemsOptions = ['Creating Database', 'Implementing Backend','Implementing Front-end','User Interface','Everything is done']
pendingItemsOptions = ['CTask1', ' Task2','Task 3','Task 4']

  constructor(
    private fb: FormBuilder,
    private employeeService: EmployeeService
  ) {
    this.employeeForm = fb.group({});
    this.employees = [];
    this.employeesToDisplay = this.employees;
  }

  ngOnInit(): void {
    this.employeeForm = this.fb.group({
      firstname: this.fb.control(''),
      lastname: this.fb.control(''),
      rating: this.fb.control(''),
      feedback: this.fb.control(''),
      duration: this.fb.control('default'),
      improvements: this.fb.control(''),
      completedItems: this.fb.control(''),
      pendingItems:this.fb.control(''),
      jobExperience: this.fb.control(''),
      salary: this.fb.control(''),
    });

    this.employeeService.getEmployees().subscribe((res) => {
      for (let emp of res) {
        this.employees.unshift(emp);
      }
      this.employeesToDisplay = this.employees;
    });
  }

  ngAfterViewInit(): void {
    //this.buttontemp.nativeElement.click();
  }

  addEmployee() {
    let employee: Employee = {
      firstname: this.FirstName.value,
      lastname: this.LastName.value,
      rating: this.Rating.value,
      feedback: this.Feedback.value,
      duration: this.Duration.value,
      improvements: this.Improvements.value,
      completedItems:this.CompletedItems.value,
      pendingItems:this.PendingItems.value,
      // jobExperience: this.JobExperience.value,
      // salary: this.Salary.value,
      // profile: this.fileInput.nativeElement.files[0]?.name,
    };
    this.employeeService.postEmployee(employee).subscribe((res) => {
      this.employees.unshift(res);
      this.clearForm();
      location.href="/";
    });
  }

  removeEmployee(event: any) {
    this.employees.forEach((val, index) => {
      if (val.id === parseInt(event)) {
        this.employeeService.deleteEmployee(event).subscribe((res) => {
          this.employees.splice(index, 1);
        });
      }
    });
  }

  editEmployee(event: any) {
    this.employees.forEach((val, ind) => {
      if (val.id === event) {
        this.setForm(val);
      }
    });
    this.removeEmployee(event);
    this.addEmployeeButton.nativeElement.click();
  }

  setForm(emp: Employee) {
    this.FirstName.setValue(emp.firstname);
    this.LastName.setValue(emp.lastname);
    this.Rating.setValue(emp.rating);
    this.Feedback.setValue(emp.feedback);

    
    this.Duration.setValue(emp.duration);

    this.Improvements.setValue(emp.improvements);    
    this.CompletedItems.setValue(emp.completedItems);
    this.PendingItems.setValue(emp.pendingItems);
    
  }

  searchEmployees(event: any) {
    let filteredEmployees: Employee[] = [];

    if (event === '') {
      this.employeesToDisplay = this.employees;
    } else {
      filteredEmployees = this.employees.filter((val, index) => {
        let targetKey = val.firstname.toLowerCase() + '' + val.lastname.toLowerCase();
        let searchKey = event.toLowerCase();
        return targetKey.includes(searchKey);
      });
      this.employeesToDisplay = filteredEmployees;
    }
  }

  clearForm() {
    this.FirstName.setValue('');
    this.LastName.setValue('');
    this.Rating.setValue('');
    this.Feedback.setValue('');
    this.Duration.setValue('');
    this.Improvements.setValue('');
    this.CompletedItems.setValue('');
    this.PendingItems.setValue('');

  }

  public get FirstName(): FormControl {
    return this.employeeForm.get('firstname') as FormControl;
  }
  public get LastName(): FormControl {
    return this.employeeForm.get('lastname') as FormControl;
  }
  public get Rating(): FormControl {
    return this.employeeForm.get('rating') as FormControl;
  }
  public get Feedback(): FormControl {
    return this.employeeForm.get('feedback') as FormControl;
  }
  public get Duration(): FormControl {
    return this.employeeForm.get('duration') as FormControl;
  }
  public get Improvements(): FormControl {
    return this.employeeForm.get('improvements') as FormControl;
  }
  public get CompletedItems(): FormControl {
    return this.employeeForm.get('completedItems') as FormControl;
  }
  public get PendingItems(): FormControl {
    return this.employeeForm.get('pendingItems') as FormControl;
  }
  
}