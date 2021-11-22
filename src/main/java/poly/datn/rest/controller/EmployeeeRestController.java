package poly.datn.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import poly.datn.entity.Employee;
import poly.datn.service.EmployeeService;


@RestController
@RequestMapping("/rest/employee")
public class EmployeeeRestController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping()
	public List<Employee> getAll(){
		return employeeService.findAll();
	}
	
	
	@PostMapping()
	public Employee create(@RequestBody Employee employee) {
		return employeeService.create(employee);
	}
	
	
	
	@PutMapping("{id}")
	public Employee update(@PathVariable("id")Integer id,@RequestBody Employee employee) {
		return employeeService.update(employee);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id")Integer id) {
		employeeService.delete(id);
	}
}