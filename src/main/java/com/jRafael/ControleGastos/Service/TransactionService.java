package com.jRafael.ControleGastos.Service;

import com.jRafael.ControleGastos.Dto.TransactionDto;
import com.jRafael.ControleGastos.Entity.Category;
import com.jRafael.ControleGastos.Entity.Transaction;
import com.jRafael.ControleGastos.Entity.User;
import com.jRafael.ControleGastos.Repository.CategoryRepositry;
import com.jRafael.ControleGastos.Repository.TransactionRepository;
import com.jRafael.ControleGastos.Repository.UserRepository;
import com.jRafael.ControleGastos.Service.exceptions.TransactionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepositry categoryRepositry;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    public TransactionDto save(TransactionDto transactionDto){
        Transaction newTransaction = new Transaction();
        Category category = categoryRepositry.findById(transactionDto.getCategoryDto().getId()).orElseThrow(()-> new RuntimeException("Erro"));
        User user = userRepository.findById(transactionDto.getUserDto().getId()).orElseThrow(()-> new RuntimeException("Erro"));

        newTransaction.setDescription(transactionDto.getDescription());
        newTransaction.setPrice(transactionDto.getPrice());
        newTransaction.setDate(transactionDto.getDate());
        newTransaction.setType(transactionDto.getType());

        category.setId(transactionDto.getCategoryDto().getId());
        user.setId(transactionDto.getUserDto().getId());

        newTransaction.setCategory(category);
        newTransaction.setUser(user);

        newTransaction = transactionRepository.save(newTransaction);

        return new TransactionDto(newTransaction);
    }

    public Page<Transaction> findAll(Pageable pageable){
        return transactionRepository.findAll(pageable);
    }

    public TransactionDto update(Long id, TransactionDto newTransactionDto){
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("Transação não encontrada"));

        transaction.setType(newTransactionDto.getType());
        transaction.setPrice(newTransactionDto.getPrice());
        transactionRepository.save(transaction);
        return new TransactionDto(transaction);
    }


    public void deleteById(Long id){
        transactionRepository.deleteById(id);
    }



}
