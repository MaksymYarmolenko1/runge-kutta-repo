package com.nulp.controller;

import com.nulp.model.ExpressionForm;
import com.nulp.utils.calculation.RungeKuttaUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.function.DoubleBinaryOperator;

@Controller
public class WebController {

    private static final String HOME_PAGE = "home";
    private static final String RESULT_PAGE = "result";

    @RequestMapping("/")
    public String home()
    {
        return HOME_PAGE;
    }

    @PostMapping("/calculate")
    public String calculateExpression(@ModelAttribute("expressionForm") ExpressionForm form, Model model)
    {
        final DoubleBinaryOperator expression = (x, y) -> (5 * x * x - y) / Math.exp(x + y);
        model.addAttribute("resultList", RungeKuttaUtils.rungeKutta(form.getX0(), form.getY0(), form.getX(), form.getH(), expression, form.isPrintStacktrace()));
        return RESULT_PAGE;
    }
}
