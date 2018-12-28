/**
 * 
 */
package com.eagle.dao;

import java.util.List;

import com.eagle.entity.Employee;

/**
 * @author Rohit
 *
 */
public interface EmployeeDAO {
	public long createEmployee(Employee employee);

	public Employee updateEmployee(Employee employee);

	public void deleteEmployee(long id);

	public List<Employee> getAllEmployees();

	public Employee getEmployee(long id);

	public List<Employee> getAllEmployees(String employeeName);

}
