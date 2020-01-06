package johnabbott.session7.dao;

import java.util.List;

import johnabbott.session7.model.Employee;
import johnabbott.session7.model.Project;

public interface EmployeeDAO {
	public List<Employee> getAllEmployees();
	public void addEmployee(Employee c);
	public void addEmployees(List<Employee> emps, List<Project> prjs);
}
