package com.mvc.serviceimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.bean.Employee;
import com.mvc.dao.EmpDAO;
import com.mvc.service.EmpServices;
@Service
public class EmpServiceApp implements EmpServices {
     @Autowired
     EmpDAO dao;
	@Override
	public boolean createEmp(Employee e) {
		  dao.save(e);
		  
		return true;
	}

	@Override
	public Employee getEmployee(int id) {
		Employee e=null;
		if(dao.existsById(id))
		e=dao.getOne(id);
		return e;
	}

	@Override
	public ArrayList<Employee> getAllEmployee() {
		ArrayList<Employee> list =(ArrayList<Employee>) dao.findAll();
		return list;
	}

	@Override
	public boolean deleteEmploye(int id) {
		
		if(dao.existsById(id))
			{dao.deleteById(id);
		return true;}
		else
		return false;
	}

}
