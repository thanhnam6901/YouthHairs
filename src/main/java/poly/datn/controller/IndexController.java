package poly.datn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.datn.entity.Employee;
import poly.datn.service.ContactService;
import poly.datn.service.EmployeeService;
import poly.datn.service.IServiceService;

@Controller
public class IndexController {
	
	@Autowired
	IServiceService iService;
	
	@Autowired
	ContactService contactService;

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("sers",iService.findServicesActive());
		List<Employee> listStylist = employeeService.loadStylist();
		model.addAttribute("stylist",listStylist);
		model.addAttribute("serviceTop3",iService.findServicesActiveTop3());
		
		return "layout/home";
	}
	
	@RequestMapping("/services")
	public String service(Model model) {
		model.addAttribute("services",iService.findServicesActive());
		model.addAttribute("serviceTop3",iService.findServicesActiveTop3());
		return "layout/services";
	}
	
	
	@RequestMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("serviceTop3",iService.findServicesActiveTop3());

		return "layout/contact";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("stylists", employeeService.getAllEmployeeActive());
		model.addAttribute("serviceTop3",iService.findServicesActiveTop3());
		
		return "layout/about";
	}

	@RequestMapping("/booking")
	public String booking(Model model) {
		model.addAttribute("sers",iService.findServicesActive());
		List<Employee> listStylist = employeeService.loadStylist();
		model.addAttribute("stylist",listStylist);
//		for(int i=0; i<listStylist.size();i++){
//			model.addAttribute("bookingIAT",bookingCustomerService.bookingStatusIAT(listStylist.get(i).getId()));
//		}
		return "layout/booking";
	}


	@RequestMapping("/admin")
	public String admin() {
		return "redirect:/admin/templates/index.html";
	}

}
