package com.furama.controller;

import com.furama.model.customer.Customer;
import com.furama.service.ICustomerService;
import com.furama.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping(value = "/list")
    public String viewList(@RequestParam(defaultValue = "") String searchName,
                           @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                           Model model) {
        model.addAttribute("customerList", this.iCustomerService.findAll(searchName, pageable));
        model.addAttribute("customerTypeList", this.iCustomerTypeService.findAll());
        model.addAttribute("searchName", searchName);
        return "customer/list";
    }

    @GetMapping(value = "/create")
    public String viewCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypeList", this.iCustomerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute Customer customer,
                         RedirectAttributes redirectAttributes) {
//        CustomerType customerType = new CustomerType();
//        customerType.setId(customer.getCustomerType().getId());
//        customer.setCustomerType(customerType);
        this.iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Create successfully!");
        return "redirect:/customer/list";
    }

    @PostMapping(value = "/remove")
    public String remove(@RequestParam int removeCustomerId,
                         RedirectAttributes redirectAttributes) {
        this.iCustomerService.deleteById(removeCustomerId);
        redirectAttributes.addFlashAttribute("msg", "Remove successfully!");
        return "redirect:/customer/list";
    }

    @GetMapping(value = "/showEdit/{id}")
    public String showEdit(@PathVariable int id,
                           Model model) {
        model.addAttribute("customerObj", this.iCustomerService.findById(id));
        model.addAttribute("customerTypeList", this.iCustomerTypeService.findAll());
        return "customer/update";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute Customer customerObj,
                         RedirectAttributes redirectAttributes) {
        this.iCustomerService.save(customerObj);
        redirectAttributes.addFlashAttribute("msg", "Update successfully!");
        return "redirect:/customer/list";
    }
}
