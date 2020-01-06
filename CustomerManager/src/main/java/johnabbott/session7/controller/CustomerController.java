package johnabbott.session7.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import johnabbott.session7.model.Address;
import johnabbott.session7.model.Customer;
import johnabbott.session7.model.Department;
import johnabbott.session7.model.Employee;
import johnabbott.session7.model.Project;
import johnabbott.session7.service.CustomerService;
import johnabbott.session7.service.EmployeeService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping("/customer")
	public ModelAndView getCustomers() {
		ModelAndView mav = new ModelAndView("list-customer");
		List<Customer> customers = service.getCustomers();
		mav.addObject("customers", customers);
		return mav;
	}
	
	
	@RequestMapping("/add")
	public ModelAndView addCustomers() {
		service.saveCustomer(new Customer("reza", "email1", "add1"));
		ModelAndView mav = new ModelAndView("list-customer");
		List<Customer> customers = service.getCustomers();
		mav.addObject("customers", customers);
		return mav;
	}
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("list-customer");
		List<Customer> customers = service.getCustomers();
		mav.addObject("customers", customers);
		return mav;
	}
	
	@RequestMapping("/update")
	public ModelAndView editCustomerForm(@RequestParam int id) {
		System.out.println("I am editing id= " + id);
		ModelAndView mav = new ModelAndView("edit-customer");
		Customer customer = service.getCustomer(id);
		mav.addObject("customer", customer);
		return mav;
	}
	
	@RequestMapping(value = "/savecustomer", method = RequestMethod.GET)
	public String saveCustomerRedirect(@ModelAttribute("customer") Customer customer) {
		 return "save-customer";
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		service.saveCustomer(customer);
		return "redirect:/customers/customer";
	}
	
	
	@RequestMapping(value = "/saveemployee", method = RequestMethod.GET)
	public String saveEmployeeRedirect(@ModelAttribute("employee") Employee emp) {
		return "save-employee";
	}
	
	@RequestMapping(value = "/getemployee", method = RequestMethod.GET)
	public ModelAndView getEmployeeList(@ModelAttribute("employee") Employee emp) {
		List<Employee> employeeList = empService.getEmployeeList();
		ModelAndView mv = new ModelAndView("emplist");
		mv.addObject("lstEmployee", employeeList);
		return mv;
		
	}
	
	
	
	
	@RequestMapping(value = "/save_emp", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		empService.saveEmployee(employee);
		return "redirect:/customers/customer";
	}
	
	@RequestMapping(value = "/saveprjs", method = RequestMethod.GET)
	public String saveProjects() {
        String[] projectData = { "IT Project", "Networking Project" };
        List<Project> projects = new ArrayList<Project>();
        
        for (String proj : projectData) {
            projects.add(new Project(proj));
        }
        
        Employee emp1 = new Employee("Reza", new Address("str1"), new Department("toto1"));
        Employee emp2 = new Employee("Alex", new Address("str2"), new Department("toto2"));
        
        
        List<Employee> emps = new ArrayList<Employee>();
        emps.add(emp1);
        emps.add(emp2);
 
		empService.saveEmployees(emps, projects);
		return "redirect:/customers/customer";
	}
	
}
