package com.Web.BookExchange.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Web.BookExchange.entity.NormalUser;
@Repository
public interface UserRepository extends JpaRepository<NormalUser,Long> {


}
