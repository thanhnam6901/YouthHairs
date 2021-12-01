package poly.datn.service;

import java.util.List;

import poly.datn.entity.Voucher;
import poly.datn.entity.Voucherdetail;
import poly.datn.service.dto.VoucherDetailInfoDTO;

public interface VoucherDetailService {
	
	List<Voucherdetail> findAll();

    List<Voucher> VoucherByCus(Integer id);
    VoucherDetailInfoDTO completeBooking(VoucherDetailInfoDTO voucherDetailInfoDTO );

	Voucherdetail save(Voucherdetail voucherDetail);
}
