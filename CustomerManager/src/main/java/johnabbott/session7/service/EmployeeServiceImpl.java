package johnabbott.session7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import johnabbott.session7.dao.EmployeeDAO;
import johnabbott.session7.model.Employee;
import johnabbott.session7.model.Project;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;
	
	

	@Override
	@Transactional
	public void saveEmployee(Employee emp) {
		employeeDAO.addEmployee(emp);
		
	}



	@Override
	@Transactional
	public void saveEmployees(List<Employee> emps, List<Project> projects) {
		employeeDAO.addEmployees(emps, projects);
	}



	@Override
	public List<Employee> getEmployeeList() {
		return employeeDAO.getAllEmployees();
	}
}
