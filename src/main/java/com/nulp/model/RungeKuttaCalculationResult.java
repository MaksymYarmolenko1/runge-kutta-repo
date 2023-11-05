package com.nulp.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RungeKuttaCalculationResult {
    double x;
    double y;
    double f1;
    double f2;
    double f3;
    double f4;
}
