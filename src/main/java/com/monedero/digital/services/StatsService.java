package com.monedero.digital.services;

import com.monedero.digital.dtos.GraphDTO;
import com.monedero.digital.dtos.StatsDTO;

public interface StatsService {

    GraphDTO getChartData();

    StatsDTO getStats();
}
