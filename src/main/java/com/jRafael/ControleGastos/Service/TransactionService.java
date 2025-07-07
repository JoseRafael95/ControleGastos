package com.jRafael.ControleGastos.Service;

import com.jRafael.ControleGastos.Entity.Transaction;
import com.jRafael.ControleGastos.Repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    TransactionRepository transactionRepository;

    public Transaction save(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    public List<Transaction> findAll(){
        return transactionRepository.findAll();
    }

    public void deleteById(Long id){
        transactionRepository.deleteById(id);
    }

}
