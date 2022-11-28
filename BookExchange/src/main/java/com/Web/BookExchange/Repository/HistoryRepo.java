package com.Web.BookExchange.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Web.BookExchange.entity.History;
@Repository
public interface HistoryRepo extends JpaRepository<History,Long> {


}
