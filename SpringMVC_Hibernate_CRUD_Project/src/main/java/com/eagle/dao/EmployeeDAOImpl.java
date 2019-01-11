package com.eagle.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.eagle.entity.Employee;
import com.eagle.util.HibernateUtil;

/**
 * @author Rohit
 *
 */
public class EmployeeDAOImpl implements EmployeeDAO {
	public EmployeeDAOImpl() {
		super();
		System.out.println("EmployeeDAO constructor called");
		
	}

	@Autowired
	HibernateUtil hibernateUtil;

	@Override
	public long createEmployee(Employee employee) {
		return (long) hibernateUtil.create(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return hibernateUtil.update(employee);
	}

	@Override
	public void deleteEmployee(long id) {
		Employee employee = new Employee();
		employee.setId(id);
		hibernateUtil.delete(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return hibernateUtil.fetchAll(Employee.class);
	}

	@Override
	public Employee getEmployee(long id) {
		return hibernateUtil.fetchById(id, Employee.class);
	}

	@Override
//	Under construction
	public List<Employee> getAllEmployees(String employeeName) {
		String query = "select e.* from employees where employees e where e.name like %" + employeeName + "%";
		return null;
	}

}
