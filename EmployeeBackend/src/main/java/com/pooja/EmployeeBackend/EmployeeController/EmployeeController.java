package com.pooja.EmployeeBackend.EmployeeController;

import com.pooja.EmployeeBackend.DTO.EmployeeDTO;
import com.pooja.EmployeeBackend.DTO.EmployeeSaveDTO;
import com.pooja.EmployeeBackend.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/employee/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/add")
    public String addEmployee(@RequestBody EmployeeSaveDTO employeeSaveDTO){
        String id = employeeService.addEmployee(employeeSaveDTO);
        return id;
    }

    @GetMapping(path="/getEmployee") //used for automatic dependency injection
    public List<EmployeeDTO>  getEmployees(){
        List<EmployeeDTO> employees = employeeService.getEmployees();
        return employees;
    }

    @DeleteMapping(path="/delete/{id}")
    public String  deleteEmployee(@PathVariable(value = "id") int id){
        String i = employeeService.deleteEmployee(id);
        return i;
    }

}
