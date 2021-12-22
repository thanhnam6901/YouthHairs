package poly.datn.rest.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import poly.datn.entity.Booking;
import poly.datn.entity.BookingDetail;
import poly.datn.entity.Employee;
import poly.datn.entity.Statusbooking;
import poly.datn.entity.ThongBaoUCF;
import poly.datn.service.*;
import poly.datn.service.dto.BookingCustomerDTO;
import poly.datn.service.dto.BookingDTO;
import poly.datn.service.dto.Role;

@RestController
@RequestMapping("/rest/booking")
public class BookingRestController {

	@Autowired
	BookingService bookingService;

	@Autowired
	StatusBookingService statusBookingService;

	@Autowired
	IServiceService iServiceService;

	@Autowired
	BookingDetailService bookingDetailService;

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	HttpSession session;

	@GetMapping("")
	public List<Booking> getAll(){
		return bookingService.findAll(Sort.by(Sort.Direction.DESC, "createDate"));
	}

	@GetMapping("/WFC")
	public List<Booking> getByStatusBooking(){
		return  bookingService.findBookingByStatusbooking("WFC");
	}

	@GetMapping("/WFP")
	public List<Booking> getByStatusBookingWFP(){return bookingService.findBookingByStatusbooking("WFP");}

	@GetMapping("/UCF")
	public List<Booking> getByStatusBookingUCF(){return bookingService.findBookingByStatusbooking("UCF");}

	@GetMapping("/CPM")
	public List<Booking> getByStatusBookingCPM(){return bookingService.findBookingByStatusbooking("CPM");}
	
	@GetMapping("/CAN")
	public List<Booking> getByStatusBookingCAN(){return bookingService.findBookingByStatusbooking("CAN");}

	@GetMapping("/COM")
	public List<Booking> getByStatusBookingCOM(){return bookingService.findBookingByStatusbooking("COM");}

	@GetMapping("/employee")
	public String[] getAllEmployee(){
		return bookingService.finbyEmployee();
	}

	@GetMapping("/stylist")
	public List<Employee> findByRoleAndStatusWork(){
		return bookingService.findByRoleAndSatus();
	};

	@GetMapping("/stylist/waiting/{id}")
	public  List<Booking> findByStatusWFCAndStylist(@PathVariable int id){
		return bookingService.findByStatusWFCAndStylist(id);
	}

	@GetMapping("/checkedService")
	public Map<String,Object> getSerciceChecked(){
		Map<String,Object> data=new HashMap<>();
		data.put("bookings",bookingService.findAll());
		data.put("bookingDetails",bookingDetailService.findAll());
		data.put("services",iServiceService.findServicesActive());
		return data;
	}

	@GetMapping("/EmployeeConfirm")
	public List<Employee> employeeConfirm(){
		return employeeService.bookingByStylist();
	}

	@GetMapping("/stylist/cutting/{id}")
	public  Booking findBookingIATbyStylist(@PathVariable Integer id){
		return bookingService.findBookingIATbyStylist(id);
	}

	@GetMapping("/bookingWaiting/{id}")
	public  List<Booking> findBookingWFCbyStylist(@PathVariable Integer id, Date date){
		return bookingService.findBookingWFCbyStylist(id, date);
	}
	
	@PutMapping("/setWorkForStylist/{id}")
	public Booking setWorkForStylist(@PathVariable("id")Integer id,@RequestBody Booking booking) {
		return bookingService.save(booking);
	}
	
	@GetMapping("/bookingIAT")
	public  List<Booking> getAllBookingIAT(){
		return bookingService.getAllBookingIAT();
	}

	@PostMapping("/updateToCOM")
	public BookingDTO AddBookingInfo(@RequestBody BookingDTO bookingDTO) {
		bookingService.AddInfoBookingUpdate(bookingDTO);
		return bookingDTO;
	}

	@PostMapping("/updateToWFC")
	public BookingDTO AddBookingInfoToWFC(@RequestBody BookingDTO bookingDTO) {
		System.out.println("Update com to wfc");
		bookingService.AddInfoBookingUpdateToWFC(bookingDTO);
		return bookingDTO;
	}

	@PostMapping("/updateWFC")
	public BookingDTO AddBookingInfoWFC(@RequestBody BookingDTO bookingDTO) {
		bookingService.AddInfoBookingUpdateWFC(bookingDTO);
		return bookingDTO;
	}

	@PutMapping("/updateToCan/{id}")
	public void updateBookingToCAN(@PathVariable int id){
		System.out.println(id);
		bookingService.updateCAN(id);
	}

	@GetMapping("/seachBooking")
	public List<Booking> seachBooking(String toDateStr, String formDateStr,String statusId, String cusName){
		return bookingService.seachBooking(toDateStr, formDateStr,statusId,cusName);
	}

	@GetMapping("/getAllTimeBooking")
	public String[] getALlTimeBooking(){
		return bookingService.getAllTimeBooking();
	}
	
	@GetMapping("/alertBookingUCF")
	public List<ThongBaoUCF> alertBookingUCF(){
		return bookingService.alertBookingUCF();
	}
	
	@GetMapping("/author")
	public Role getRole(){
		Role role= new Role();
		var roleSs= session.getAttribute("role");
		var roleStr = String.valueOf(roleSs);
		if (roleStr.equals("admin")){
			role.setRoleName("admin");
		}else if(roleStr.equals("staff")) {
			role.setRoleName("staff");
		}
		return role;
	}
}
