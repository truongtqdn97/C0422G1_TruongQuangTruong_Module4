package com.example.controller;

import com.example.model.Medical;
import com.example.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MedicalController {
    @Autowired
    private IMedicalService iMedicalService;

    @GetMapping("/")
    public String goForm(Model model){
        model.addAttribute("medical", new Medical());
        model.addAttribute("yearOfBirth", this.iMedicalService.showYearOfBirth());
        model.addAttribute("genderList", this.iMedicalService.showGenderList());
        model.addAttribute("nationList", this.iMedicalService.showNationList());
        model.addAttribute("vehicleList", this.iMedicalService.showVehicleList());
        model.addAttribute("dayList", this.iMedicalService.showDayList());
        model.addAttribute("monthList", this.iMedicalService.showMonthList());
        model.addAttribute("yearList", this.iMedicalService.showYearList());
        return "form";
    }

    @PostMapping("/send")
    public String view(@ModelAttribute Medical medical,
                       RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("medical", medical);
        return "success";
    }
}
