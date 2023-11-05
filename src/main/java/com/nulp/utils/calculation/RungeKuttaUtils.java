package com.nulp.utils.calculation;

import com.nulp.model.RungeKuttaCalculationResult;
import com.nulp.utils.parser.Parser;
import com.nulp.utils.parser.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleBinaryOperator;

public class RungeKuttaUtils {

    public static List<RungeKuttaCalculationResult> rungeKutta(double x0,
                                  final double y0,
                                  final double x,
                                  final double h,
                                  final DoubleBinaryOperator expression,
                                  final boolean printStacktrace)
    {
        double f1, f2, f3, f4;
        double y = y0;
        List<RungeKuttaCalculationResult> results = new ArrayList<>();
        // Count number of iterations using step height h
        int n = (int)((x - x0) / h);

        // Iterate for number of iterations
        for (int i = 1; i <= n; i++)
        {
//            Apply Runge Kutta Formulas to find next value of y
//            f1 = eval(function, buildPoint("x", x0), buildPoint("y", y)).getValue();
//            f2 = eval(function, buildPoint("x", x0 + 0.5 * h), buildPoint("y", y + 0.5 * f1)).getValue();
//            f3 = eval(function, buildPoint("x", x0 + 0.5 * h), buildPoint("y", y + 0.5 * f2)).getValue();
//            f4 = eval(function, buildPoint("x", x0 + h), buildPoint("y", y + f3)).getValue();

            // Apply Runge Kutta Formulas to find next value of y
            f1 = h * expression.applyAsDouble(x0, y);
            f2 = h * expression.applyAsDouble(x0 + 0.5 * h, y + 0.5 * f1);
            f3 = h * expression.applyAsDouble(x0 + 0.5 * h, y + 0.5 * f2);
            f4 = h * expression.applyAsDouble(x0 + h, y + f3);
            results.add(buildIterationResult(x0, y, f1, f2, f3, f4));

            if (printStacktrace)
            {
                System.out.printf("Iteration: %d\n    F1: %f\n    F2: %f\n    F3: %f\n    F4: %f\n    X: %f\n    Y: %f\n\n", i, f1, f2, f3, f4, x0, y);
            }

            // Update next value of y
            y = y + (1.0 / 6.0) * (f1 + 2 * f2 + 2 * f3 + f4);

            // Update next value of x
            x0 = x0 + h;
        }

        return results;
    }

    private static RungeKuttaCalculationResult buildIterationResult(double x, double y, double f1,
                                                                    double f2, double f3, double f4)
    {
        return RungeKuttaCalculationResult.builder()
                .x(x).y(y)
                .f1(f1).f2(f2).f3(f3).f4(f4)
                .build();
    }

    private static Point buildPoint(String variable, Double value)
    {
        return new Point(variable, value);
    }
}
