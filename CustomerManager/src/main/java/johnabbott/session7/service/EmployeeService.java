package johnabbott.session7.service;

import java.util.List;

import johnabbott.session7.model.Employee;
import johnabbott.session7.model.Project;


public interface EmployeeService {
	
	public List<Employee> getEmployeeList();
	public void saveEmployee(Employee emp);
	
	public void saveEmployees(List<Employee> emps, List<Project> projects);
	
}