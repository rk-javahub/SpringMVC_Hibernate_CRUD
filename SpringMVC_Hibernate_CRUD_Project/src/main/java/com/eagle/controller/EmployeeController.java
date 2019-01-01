package com.eagle.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.eagle.entity.Employee;
import com.eagle.service.EmployeeService;

/**
 * @author Rohit
 *
 */
@Controller
public class EmployeeController {
	private static final Logger logger = Logger.getLogger(Employee.class);

	public EmployeeController() {
		System.out.println("Employee controller");
	}

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("createEmployee")
	public ModelAndView createEmployee(@ModelAttribute Employee employee) {
		logger.info("Creating Employee. Data: " + employee);
		return new ModelAndView("employeeFrom");
	}

	@RequestMapping("editEmployee")
	public ModelAndView updateEmployee(@RequestParam long id, @ModelAttribute Employee employee) {
		logger.info("updating the employee information for the Id: " + id);
		employee = employeeService.getEmployee(id);
		return new ModelAndView("employeeForm", "employeeObject", employee);
	}

	@RequestMapping("saveEmployee")
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		logger.info("Saving the Employee. Data: " + employee);
		if (employee.getId() == 0) {
			employeeService.createEmployee(employee);
		} else {
			employeeService.updateEmployee(employee);
		}
		return new ModelAndView("redirect:getAllEmployees");
	}

	@RequestMapping("deleteEmployee")
	public ModelAndView deleteEmployee(@RequestParam long id) {
		logger.info("Deleting the Employee. Id : " + id);
		employeeService.deleteEmployee(id);
		return new ModelAndView("redirect:getAllEmployees");
	}

	@RequestMapping(value = { "getAllEmployees", "/" })
	public ModelAndView getAllEmployees() {
		logger.info("Getting the all Employees.");
		List<Employee> employeeList = employeeService.getAllEmployees();
		return new ModelAndView("employeeList", "employeeList", employeeList);
	}

	// Under construction
	@RequestMapping("searchEmployee")
	public ModelAndView searchEmployee(@RequestParam("searchName") String searchName) {
		logger.info("Searching the Employee. Employee Names: " + searchName);
		List<Employee> employeeList = employeeService.getAllEmployees(searchName);
		return new ModelAndView("employeeList", "employeeList", employeeList);
	}
}
