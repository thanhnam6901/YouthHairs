package poly.datn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.datn.dao.*;
import poly.datn.entity.*;
import poly.datn.service.BookingCustomerService;
import poly.datn.service.dto.BookingCustomerDTO;

import java.util.Date;

@Service

public class BookingCustomerServiceImpl  implements BookingCustomerService{

	@Autowired
	BookingDAO bookingDao;

	@Autowired
	BookingDetailDAO bDetailDAO;

	@Autowired
	ServiceDAO serDao;

	@Autowired
	CustomerDAO cusDAO;

	@Autowired
	StatusBookingDAO statusDAO;

	@Autowired
	EmployeeDAO empDAO;


	public boolean checkNullCustomer(Customer customer){
		return customer != null ? true :false;
	}

	public boolean checkNullBooking(Booking booking){
		return booking != null ? true :false;
	}

	public BookingCustomerDTO AddInfoBookingCustomer(BookingCustomerDTO bookingCustomerDTO) {

		try {
			Customer cus = cusDAO.customerByPhone(bookingCustomerDTO.getPhone());
			Booking booking = null;
			if(!checkNullCustomer(cus)) {
				Customer cus1 = new Customer();
				cus1.setFullName(bookingCustomerDTO.getFullName());
				cus1.setEmail(bookingCustomerDTO.getEmail());
				cus1.setPhone(bookingCustomerDTO.getPhone());
				cusDAO.save(cus1);
				booking = bookingDao.bookingByCustomer(cus1.getId());
				System.out.println(cus1.getId());
			}else {
				if(cus.getEmail()!= bookingCustomerDTO.getEmail()) {
					cus.setEmail(bookingCustomerDTO.getEmail());
					cusDAO.save(cus);
					booking = bookingDao.bookingByCustomer(cus.getId());
				}
			}
			Statusbooking statusBooking = statusDAO.StatusbookingbyId();
			Employee stylist = empDAO.employeeByIdStylist(bookingCustomerDTO.getStylistId());
			Customer cus1 = cusDAO.customerByPhone(bookingCustomerDTO.getPhone());
			if(!checkNullBooking(booking )) {
				Booking booking1= new Booking();
				booking1.setCreateDate(new Date());
				booking1.setTime(null);
				booking1.setNote(bookingCustomerDTO.getNote());
				booking1.setEmployee1(stylist);
				booking1.setTotalPrice(bookingCustomerDTO.getTotalPrice());
				booking1.setTotalTime(bookingCustomerDTO.getTotalTime());
				booking1.setCustomer(cus1);
				booking1.setStatusbooking(statusBooking);
				booking1.setVoting(null);
				booking1.setVoucherdetails(null);
				bookingDao.save(booking1);

				for(int i=0; i<bookingCustomerDTO.getListSer().size();i++ ){
					BookingDetail bookingDetail = new BookingDetail();
					bookingDetail.setBooking(booking1);
					bookingDetail.setService(bookingCustomerDTO.getListSer().get(i));
					bookingDetail.setPrice(bookingCustomerDTO.getListSer().get(i).getPrice());
					bookingDetail.setTime(bookingCustomerDTO.getListSer().get(i).getTime());
					bDetailDAO.save(bookingDetail);
				}}else{
				throw new Exception("c error");
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookingCustomerDTO;
	}


	public Booking bookingStatusIAT(Integer id){
		return bookingDao.bookingCusByStylist(id);
	}

}
