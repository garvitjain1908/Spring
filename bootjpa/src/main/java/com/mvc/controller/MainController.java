package com.mvc.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.bean.Employee;

import com.mvc.serviceimpl.EmpServiceApp;


@Controller
public class MainController {
	@Autowired 
	EmpServiceApp app;
	

 @PostMapping("/create")
 public ModelAndView createEmp(@RequestParam int eid,@RequestParam String ename,ModelAndView mv)
 {       Employee e=new Employee(eid,ename);
    
	     if(app.createEmp(e))
	     {
	     mv.setViewName("result");
	     mv.addObject("result",ename+" is added");
	     return mv;
	     }
	     else
	     {
	    	 mv.setViewName("result");
		     mv.addObject("result","Employee not added");
		     return mv;
	     }
 }
 @PostMapping("/show")
 public ModelAndView show(@RequestParam int eid,ModelAndView mv)
 {   
	 Employee e=app.getEmployee(eid);
	 mv.setViewName("result");
	 if(e==null)
		 mv.addObject("result", " Employe not found");
	 else
       mv.addObject("result", e);
	 
     return mv;
 }
 
 
 @PostMapping("/showAll")
 public ModelAndView showAll(ModelAndView mv)
 {   
	 ArrayList<Employee> list=app.getAllEmployee();
	 mv.setViewName("result");
		 if(list.isEmpty())
			 mv.addObject("result", "no employee found");
		 else
	     mv.addObject("result", list);
   
	 return mv;
 }
 @PostMapping("/delete")
 public ModelAndView delete(@RequestParam int eid,ModelAndView mv)
 {   
	 if(app.deleteEmploye(eid))
	 { mv.setViewName("result");
     mv.addObject("result", "Employee deleted");
     return mv;
     }
	 else
	 { mv.setViewName("result");
     mv.addObject("result", "Employee not deleted");
     return mv;
     }
 }
 
}
