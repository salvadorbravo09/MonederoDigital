package com.monedero.digital.services;

import com.monedero.digital.dtos.IncomeDTO;
import com.monedero.digital.entities.Income;

public interface IncomeService {




    Income postIncome(IncomeDTO incomeDTO);
}
