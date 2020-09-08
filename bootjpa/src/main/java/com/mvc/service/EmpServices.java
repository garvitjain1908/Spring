package com.mvc.service;

import java.util.ArrayList;

import com.mvc.bean.Employee;

public interface EmpServices {
   boolean createEmp(Employee e);
    Employee getEmployee(int id);
    ArrayList<Employee> getAllEmployee();
    boolean deleteEmploye(int id);
    
}
