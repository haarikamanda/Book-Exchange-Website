package com.Web.BookExchange.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Web.BookExchange.entity.Books;
@Repository
public interface BookRepository extends JpaRepository<Books,Long> {


}
