package poly.datn.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.datn.entity.Booking;
import poly.datn.entity.Employee;
import poly.datn.entity.Statusbooking;
import poly.datn.service.BookingService;
import poly.datn.service.StatusBookingService;

@RestController
@RequestMapping("/rest/booking")
public class BookingRestController {

	@Autowired
	BookingService bookingService;

	@Autowired
	StatusBookingService statusBookingService;

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


}
