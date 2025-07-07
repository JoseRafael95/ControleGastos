package com.jRafael.ControleGastos.Repository;

import com.jRafael.ControleGastos.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
