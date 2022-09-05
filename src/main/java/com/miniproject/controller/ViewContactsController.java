package com.miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.miniproject.dto.ContactDTO;
import com.miniproject.service.ContactService;

@Controller								
public class ViewContactsController {
	@Autowired
	private ContactService contactService;
	
	public String handleAddCtcsHyperlink(Model model) {// add hyperlink
		
		return null;
	}
	
	@GetMapping("/editContact")
	public String editContact(@RequestParam("cId") Integer cid, Model model) {// edit data
		ContactDTO contact = contactService.getContactById(cid);
		model.addAttribute("contact",contact);
		
		return "index";
	}
	
	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("cId")Integer cid, RedirectAttributes rattr) {// delete data
		contactService.deleteContactById(cid);
		rattr.addFlashAttribute("delSucc", "Contact Deleted Successfully");
		return "redirect:viewContacts";
	}

}
