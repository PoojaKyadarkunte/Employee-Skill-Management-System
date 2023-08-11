package com.pooja.EmployeeBackend.EmployeeRepo;

import com.pooja.EmployeeBackend.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
