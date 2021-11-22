package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.datn.entity.BookingDetail;
import poly.datn.entity.BookingDetailPK;

import java.util.List;

public interface BookingDetailDAO extends JpaRepository<BookingDetail, BookingDetailPK>{


}
