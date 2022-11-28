package com.Web.BookExchange.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Web.BookExchange.entity.Wallet;
@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {
	Wallet findByUserId(long userId);
}