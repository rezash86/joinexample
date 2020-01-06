package johnabbott.session7.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import johnabbott.session7.model.Address;
import johnabbott.session7.model.Customer;
import johnabbott.session7.model.Department;
import johnabbott.session7.model.Employee;
import johnabbott.session7.model.Project;

@Repository
public class EmplpoyeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void addEmployee(Employee c) {
		Address address = new Address();
		//address.setStreetName(c.getAddress().getStreetName());
		getSession().saveOrUpdate(address);
		//c.setAddress(address);
		Department dep = new Department();
		dep.setName("test dep");
		getSession().save(dep);
		c.setDepartment(dep);
		getSession().saveOrUpdate(c);
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void persist(Customer c) {
		getSession().persist(c);
	}

	public void delete(Customer c) {
		getSession().delete(c);
	}

	@Override
	public void addEmployees(List<Employee> emps, List<Project> prjs) {
		for (Employee emp : emps) {
			getSession().saveOrUpdate(emp.getAddress());
			getSession().save(emp.getDepartment());
			emp.setProjects(prjs);
			getSession().persist(emp);

		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		return getSession().createQuery("from Employee emp inner join emp.department").list();
	}

}
