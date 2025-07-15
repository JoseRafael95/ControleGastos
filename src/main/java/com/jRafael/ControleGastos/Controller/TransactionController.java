package com.jRafael.ControleGastos.Controller;

import com.jRafael.ControleGastos.Dto.TransactionDto;
import com.jRafael.ControleGastos.Entity.Transaction;
import com.jRafael.ControleGastos.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping
    public ResponseEntity<Page<Transaction>> findAll(Pageable pageable){
       return ResponseEntity.ok(transactionService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<TransactionDto> save(@RequestBody TransactionDto transaction){
        return ResponseEntity.ok(transactionService.save(transaction));
    }

}
