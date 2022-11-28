package com.Web.BookExchange.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Web.BookExchange.entity.BookRequests;

@Repository

public interface BookRequestRepository  extends JpaRepository<BookRequests,Long> {


}