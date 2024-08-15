package com.monedero.digital.services;

import com.monedero.digital.dtos.ExpenseDTO;
import com.monedero.digital.entities.Expense;

import java.util.List;

public interface ExpenseService {

    List<Expense> getAllExpenses();

    Expense getExpenseById(Long id);

    Expense postExpense(ExpenseDTO expenseDTO);
}
