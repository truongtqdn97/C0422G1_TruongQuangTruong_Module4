package com.example.controller;

import com.example.model.Medical;
import com.example.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MedicalController {
    @Autowired
    private IMedicalService iMedicalService;

    @GetMapping("/")
    public String goHome(Model model){
        model.addAttribute("medicalList", this.iMedicalService.showMedicalList());
        return "home";
    }

    @GetMapping("/show-form")
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

    @PostMapping("/create")
    public String view(@ModelAttribute Medical medical,
                       RedirectAttributes redirectAttributes){
        List<Medical> medicalList = this.iMedicalService.showMedicalList();
        medical.setMedicalId(medicalList.get(medicalList.size()-1).getMedicalId()+1);
        this.iMedicalService.save(medical);
        redirectAttributes.addFlashAttribute("msgCreate",
                "Khai báo thành công!");
        return "redirect:/";
    }

    @GetMapping("/updateForm/{medicalId}")
    public String showUpdate(@PathVariable int medicalId,
                         Model model){
        model.addAttribute("medical", this.iMedicalService.findById(medicalId));
        model.addAttribute("yearOfBirth", this.iMedicalService.showYearOfBirth());
        model.addAttribute("genderList", this.iMedicalService.showGenderList());
        model.addAttribute("nationList", this.iMedicalService.showNationList());
        model.addAttribute("vehicleList", this.iMedicalService.showVehicleList());
        model.addAttribute("dayList", this.iMedicalService.showDayList());
        model.addAttribute("monthList", this.iMedicalService.showMonthList());
        model.addAttribute("yearList", this.iMedicalService.showYearList());
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Medical medical,
                         RedirectAttributes redirectAttributes){
        this.iMedicalService.save(medical);
        redirectAttributes.addFlashAttribute("msgUpdate",
                "Cập nhật thành công!");
        return "redirect:/";
    }
}
