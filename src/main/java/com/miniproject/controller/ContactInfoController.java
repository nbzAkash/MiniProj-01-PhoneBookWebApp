package com.miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.miniproject.dto.ContactDTO;
import com.miniproject.service.ContactService;

@Controller
public class ContactInfoController {
	@Autowired
	private ContactService contactService;
	
	@GetMapping(value = {"/","loadForm"})
	public String loadContactForm(Model model) { // for displaying the form
		
		ContactDTO contactObj = new ContactDTO();
		model.addAttribute("contact", contactObj);
		
		return "index";
	}
	@PostMapping("/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contact")ContactDTO dto, RedirectAttributes rattr) { // to save and load update
		
		boolean isSaved = contactService.saveContact(dto);
		if(isSaved) {
			
			if(dto.getCid() != null) {
				rattr.addFlashAttribute("succMsg", "Contact Updated Successfully");
				
			}else {
				rattr.addFlashAttribute("succMsg","Contact Saved Successfully");
			}
			 
			
		}else {
			rattr.addFlashAttribute("errMsg","Failed to save Contact");
		}
		
		return "redirect:loadForm";
	}
	
	@GetMapping("/viewContacts")
	public String handleViewCtcsHyperlink(Model model) { // show for  hyperlink/ view all data
		
		List<ContactDTO> allContacts = contactService.getAllContacts();
		model.addAttribute("contacts", allContacts);
		
		return "viewContacts";
	}

}
