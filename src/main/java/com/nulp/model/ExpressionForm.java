package com.nulp.model;

import lombok.Data;

@Data
public class ExpressionForm {
    double x0;
    double y0;
    double x;
    double h;
    String expression;
    boolean printStacktrace;
}
