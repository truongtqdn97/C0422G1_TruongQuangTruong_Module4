package com.furama.controller;

import com.furama.model.Customer;
import com.furama.model.CustomerType;
import com.furama.service.ICustomerService;
import com.furama.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping(value = "/customer/list")
    public String viewList(Model model,
                           @PageableDefault(size = 5) Pageable pageable){
        model.addAttribute("customerList", this.iCustomerService.findAll(pageable));
        model.addAttribute("customerTypeList", this.iCustomerTypeService.findAll());
        return "customer/list";
    }

    @GetMapping(value = "/customer/create")
    public String viewCreateForm(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypeList", this.iCustomerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping(value = "/customer/create")
    public String create(@ModelAttribute Customer customer,
                         RedirectAttributes redirectAttributes,
                         Model model){
        CustomerType customerType = new CustomerType();
        customerType.setId(customer.getCustomerType().getId());
        customer.setCustomerType(customerType);
        this.iCustomerService.save(customer);
//        redirectAttributes.addFlashAttribute("msg", "Create successfully!");
        return "redirect:/customer/list";
    }
}
