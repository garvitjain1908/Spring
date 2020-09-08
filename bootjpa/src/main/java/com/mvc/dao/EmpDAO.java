package com.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.bean.Employee;


public interface EmpDAO extends JpaRepository<Employee, Integer> {
  
}
