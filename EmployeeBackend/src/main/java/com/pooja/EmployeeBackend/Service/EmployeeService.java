package com.pooja.EmployeeBackend.Service;

import com.pooja.EmployeeBackend.DTO.EmployeeDTO;
import com.pooja.EmployeeBackend.DTO.EmployeeSaveDTO;





















import java.util.List;

public interface EmployeeService {
    String addEmployee(EmployeeSaveDTO employeeSaveDTO);

    List<EmployeeDTO> getEmployees();

    String deleteEmployee(int id);
}
