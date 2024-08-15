package com.monedero.digital.controllers;

import com.monedero.digital.dtos.ExpenseDTO;
import com.monedero.digital.entities.Expense;
import com.monedero.digital.services.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/expense")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200/")
public class ExpenseController {

    private final ExpenseService expenseService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllExpenses() {
        return ResponseEntity.status(HttpStatus.OK).body(expenseService.getAllExpenses());
    }

    @PostMapping
    public ResponseEntity<?> postExpense(@RequestBody ExpenseDTO expenseDTO) {
        Expense createdExpense = expenseService.postExpense(expenseDTO);
        if (createdExpense != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdExpense);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
