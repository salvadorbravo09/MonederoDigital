package com.monedero.digital.services;

import com.monedero.digital.dtos.IncomeDTO;
import com.monedero.digital.entities.Income;

import java.util.List;

public interface IncomeService {

    List<IncomeDTO> getAllIncomes();



    Income postIncome(IncomeDTO incomeDTO);
}
