package com.monedero.digital.services;

import com.monedero.digital.dtos.ExpenseDTO;
import com.monedero.digital.entities.Expense;

public interface ExpenseService {

    Expense postExpense(ExpenseDTO expenseDTO);
}
