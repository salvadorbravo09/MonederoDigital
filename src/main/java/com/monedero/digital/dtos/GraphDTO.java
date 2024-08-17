package com.monedero.digital.dtos;

import com.monedero.digital.entities.Expense;
import com.monedero.digital.entities.Income;
import lombok.Data;

import java.util.List;

@Data
public class GraphDTO {

    private List<Expense> expenseList;

    private List<Income> incomeList;
}
