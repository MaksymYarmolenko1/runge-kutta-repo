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

    public RungeKuttaCalculationResult(double x, double y, double f1, double f2, double f3, double f4) {
        this.x = x;
        this.y = y;
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.f4 = f4;
    }
}
