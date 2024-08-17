package com.monedero.digital.services.impl;

import com.monedero.digital.dtos.GraphDTO;
import com.monedero.digital.dtos.StatsDTO;
import com.monedero.digital.entities.Expense;
import com.monedero.digital.entities.Income;
import com.monedero.digital.repositories.ExpenseRepository;
import com.monedero.digital.repositories.IncomeRepository;
import com.monedero.digital.services.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {

    private final IncomeRepository incomeRepository;

    private final ExpenseRepository expenseRepository;

    public GraphDTO getChartData() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(27);

        GraphDTO graphDTO = new GraphDTO();
        graphDTO.setExpenseList(expenseRepository.findByDateBetween(startDate, endDate));
        graphDTO.setIncomeList(incomeRepository.findByDateBetween(startDate, endDate));

        return graphDTO;
    }

    public StatsDTO getStats() {
        Double totalIncome = incomeRepository.sumAllAmounts();
        Double totalExpense = expenseRepository.sumAllAmounts();

        Optional<Income> optionalIncome = incomeRepository.findFirstByOrderByDateDesc();
        Optional<Expense> optionalExpense = expenseRepository.findFirstByOrderByDateDesc();

        StatsDTO statsDTO = new StatsDTO();
        statsDTO.setExpense(totalExpense);
        statsDTO.setIncome(totalIncome);

        if (optionalIncome.isPresent()) {
            statsDTO.setLatestIncome(optionalIncome.get());
        }

        if (optionalExpense.isPresent()) {
            statsDTO.setLatestExpense(optionalExpense.get());
        }

        statsDTO.setBalance(totalIncome - totalExpense);

        List<Income> incomeList = incomeRepository.findAll();
        List<Expense> expenseList = expenseRepository.findAll();

        OptionalDouble minIncome = incomeList.stream().mapToDouble(Income::getAmount).min();
        OptionalDouble maxIncome = incomeList.stream().mapToDouble(Income::getAmount).max();

        OptionalDouble minExpense = expenseList.stream().mapToDouble(Expense::getAmount).min();
        OptionalDouble maxExpense = expenseList.stream().mapToDouble(Expense::getAmount).max();

        statsDTO.setMaxExpense(maxExpense.isPresent() ? maxExpense.getAsDouble() : Double.NaN);
        statsDTO.setMinExpense(minExpense.isPresent() ? minExpense.getAsDouble() : Double.NaN);

        statsDTO.setMaxIncome(maxIncome.isPresent() ? maxIncome.getAsDouble() : Double.NaN);
        statsDTO.setMinIncome(minIncome.isPresent() ? minIncome.getAsDouble() : Double.NaN);

        return statsDTO;
    }
}
