package com.spring.mvc.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc.models.License;
import com.spring.mvc.models.Person;
import com.spring.mvc.services.LicenseService;
import com.spring.mvc.services.PersonService;



@Controller
public class LicenseController {
	private final LicenseService licenseService;
	
	public LicenseController(LicenseService licenseService) {
		this.licenseService = licenseService;
	}

	@Autowired
	private PersonService personService;
	
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("licenseObject") License license, Model model) {
		List<Person> personslist = personService.allPerson();
		model.addAttribute("personslist", personslist);
		ArrayList<String> states = new ArrayList<String>(Arrays.asList("Ramallah", "Nablus", "Jenin", "Bethlahem", "California", "Haifa", "Akko",
				"Nasra", "Florida", "Tulkarem", "Hawaii", "Hebron", "Jericho", "Kansas"));
		model.addAttribute("states", states);
		return "newlicense.jsp";
	}
	
	@RequestMapping(value="/addlicense", method=RequestMethod.POST)
	public String addlicense(@Valid @ModelAttribute("licenseObject") License license, BindingResult result) {
		if (result.hasErrors()) {
			return "newlicense.jsp";
		}
		else {
			String number = licenseService.generateLicenseNumber();
			license.setNumber(number);
			licenseService.addLicense(license);
			return "redirect:/persons/" +license.getId();
		}
	}
}