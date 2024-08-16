package com.monedero.digital.services;

import com.monedero.digital.dtos.IncomeDTO;
import com.monedero.digital.entities.Income;

import java.util.List;

public interface IncomeService {

    List<IncomeDTO> getAllIncomes();

    IncomeDTO getIncomeById(Long id);

    Income postIncome(IncomeDTO incomeDTO);

    Income updateIncome(Long id, IncomeDTO incomeDTO);


}
