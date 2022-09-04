package com.furama.controller;

import com.furama.model.Facility;
import com.furama.model.FacilityType;
import com.furama.model.RentType;
import com.furama.service.IFacilityService;
import com.furama.service.IFacilityTypeService;
import com.furama.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/facility")
public class FacilityController {
    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @Autowired
    private IRentTypeService iRentTypeService;

    @Autowired
    private IFacilityService iFacilityService;

    @GetMapping(value = "/list")
    public String viewList(@PageableDefault(value = 2)Pageable pageable,
                           Model model){
        model.addAttribute("rentType", this.iRentTypeService.findAll());
        model.addAttribute("facilityType", this.iFacilityTypeService.findAll());
        model.addAttribute("facilities", this.iFacilityService.findAll(pageable));
        return "facility/list";
    }

    @GetMapping(value = "/create")
    public String viewCreateForm(Model model){
        model.addAttribute("facilityObj", new Facility());
        model.addAttribute("rentType", this.iRentTypeService.findAll());
        model.addAttribute("facilityType", this.iFacilityTypeService.findAll());
        return "facility/create";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute Facility facilityObj,
                         RedirectAttributes redirectAttributes){
        RentType rentType = new RentType();
        rentType.setId(facilityObj.getRentType().getId());
        facilityObj.setRentType(rentType);

        FacilityType facilityType = new FacilityType();
        facilityType.setId(facilityObj.getFacilityType().getId());
        facilityObj.setFacilityType(facilityType);

        this.iFacilityService.save(facilityObj);
//        redirectAttributes.addFlashAttribute("msg", "Create successfully!");
        return "redirect:/list";
    }
}
