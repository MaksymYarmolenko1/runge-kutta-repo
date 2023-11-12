package com.nulp;

import com.nulp.model.RungeKuttaCalculationResult;
import com.nulp.utils.calculation.RungeKuttaUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleBinaryOperator;

public class RungeKuttaUtilsTest
{

    @Test
    public void shouldCalculateRungeKutta()
    {
        // given
        final DoubleBinaryOperator expression = (x, y) -> (5 * x * x - y) / Math.exp(x + y);

        // when
        List<RungeKuttaCalculationResult> testedResults = RungeKuttaUtils.rungeKutta(0.0, 1.0, 1.0, 0.1, expression, false);

        // then
        Assertions.assertEquals(testedResults, rungeKuttaCalculationResults());
    }

    private List<RungeKuttaCalculationResult> rungeKuttaCalculationResults()
    {
        List<RungeKuttaCalculationResult> testResults = new ArrayList<>();
        testResults.add(new RungeKuttaCalculationResult(0.0, 1.0, -0.036787944117144235, -0.03454223937715997, -0.03454345267778262, -0.031543932583208985));
        testResults.add(new RungeKuttaCalculationResult(0.1, 0.9655827898649603, -0.03154430004487266, -0.027876928287398062, -0.02788679541228334, -0.02364734202447938));
        testResults.add(new RungeKuttaCalculationResult(0.2, 0.9377962749535078, -0.023648185012737882, -0.018926776118394027, -0.018954808751886314, -0.013857659703604525));
        testResults.add(new RungeKuttaCalculationResult(0.30000000000000004, 0.9189181058773573, -0.01385886278143641, -0.008478239606024294, -0.008531416697839625, -0.002977302756469027));
        testResults.add(new RungeKuttaCalculationResult(0.4, 0.9104421928530851, -0.0029786344481659995, 0.0026604328853155647, 0.0025807040492823747, 0.008202237597725388));
        testResults.add(new RungeKuttaCalculationResult(0.5, 0.9130598390228777, 0.008201035433716773, 0.013727300977249866, 0.01362588665179533, 0.01897314704144455));
        testResults.add(new RungeKuttaCalculationResult(0.6, 0.9267065986450863, 0.01897229755439657, 0.02407941974341753, 0.023965870938164418, 0.028775214556615532));
        testResults.add(new RungeKuttaCalculationResult(0.7, 0.9506796142241156, 0.028774871849233677, 0.033244861594677426, 0.03313051315663713, 0.03723128887007393));
        testResults.add(new RungeKuttaCalculationResult(0.7999999999999999, 0.9838057659277717, 0.037231524524293985, 0.040940874662773234, 0.040835975067127224, 0.0441484563285236));
        testResults.add(new RungeKuttaCalculationResult(0.8999999999999999, 1.0246280459798747, 0.044149260797826315, 0.04705938070898806, 0.04697122787488836, 0.04949161767221824));

        return testResults;
    }
}