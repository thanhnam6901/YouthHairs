package poly.datn.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poly.datn.entity.Services;

import java.sql.Time;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingCustomerDTO {

	//Customer

	private String email;

	private String fullName;

	private String phone;

	//booking
	
	private Date createDate;

	private String note;

	private int stylistId;

	private float totalPrice;

	private Time totalTime;

	//Service
	private List<Services> listSer;

}
