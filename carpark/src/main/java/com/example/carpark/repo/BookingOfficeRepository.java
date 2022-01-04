package com.example.carpark.repo;

import com.example.carpark.entities.BookingOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingOfficeRepository extends JpaRepository<BookingOffice, Long> {
}
