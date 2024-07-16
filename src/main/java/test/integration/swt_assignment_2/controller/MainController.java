package test.integration.swt_assignment_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import test.integration.swt_assignment_2.model.CalculationForm;
import test.integration.swt_assignment_2.model.CustomerType;
import test.integration.swt_assignment_2.model.EmployeeType;
import test.integration.swt_assignment_2.model.ItemType;

@Controller
public class MainController {
    @GetMapping("ahihi")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("itemTypes", ItemType.values());
        modelAndView.addObject("customerTypes", CustomerType.values());
        modelAndView.addObject("employeeTypes", EmployeeType.values());
        return modelAndView;
    }
    @PostMapping("calculate")
    public ModelAndView index(@ModelAttribute("CalculationForm") CalculationForm form) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("itemTypes", ItemType.values());
        modelAndView.addObject("customerTypes", CustomerType.values());
        modelAndView.addObject("employeeTypes", EmployeeType.values());
        modelAndView.addObject("customerType", form.getCustomerType());
        modelAndView.addObject("itemType", form.getItemType());
        modelAndView.addObject("itemPrice", form.getItemType());
        modelAndView.addObject("employeeType", form.getEmployeeType());
        modelAndView.addObject("commission", form.calculateCommission());
        return modelAndView;
    }
}
