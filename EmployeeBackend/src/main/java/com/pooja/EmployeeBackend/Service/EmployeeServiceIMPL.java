package com.pooja.EmployeeBackend.Service;

import com.pooja.EmployeeBackend.DTO.EmployeeDTO;
import com.pooja.EmployeeBackend.DTO.EmployeeSaveDTO;
import com.pooja.EmployeeBackend.EmployeeRepo.EmployeeRepo;
import com.pooja.EmployeeBackend.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceIMPL implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public String addEmployee(EmployeeSaveDTO      employeeSaveDTO) {
        Employee employee = new Employee(
                employeeSaveDTO.getFirstname(),
                employeeSaveDTO.getLastname(),
                employeeSaveDTO.getRating(),
                employeeSaveDTO.getFeedback(),
                employeeSaveDTO.getDuration(),
                employeeSaveDTO.getDuration(),
                employeeSaveDTO.getCompletedItems(),
                employeeSaveDTO.getPendingItems()
        );
        employeeRepo.save(employee);
        return String.valueOf(employee.getId());
    }

    @Override
    public List<EmployeeDTO> getEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (Employee employee : employees){
            EmployeeDTO employeeDTO = new EmployeeDTO(
                   employee.getId(),
                    employee.getFirstname(),
                    employee.getLastname(),
                    employee.getRating(),
                    employee.getFeedback(),
                    employee.getDuration(),
                    employee.getImprovements(),
                    employee.getCompletedItems(),
                    employee.getPendingItems()
            );
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }

    @Override
    public String deleteEmployee(int id) {
        employeeRepo.deleteById(id);
        return String.valueOf(id);
    }
}
