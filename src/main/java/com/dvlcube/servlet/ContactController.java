package com.dvlcube.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dvlcube.bean.Contact;

@Controller
@SessionAttributes
public class ContactController {

	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") final Contact contact,
			final BindingResult result) {

		System.out.println("First Name:" + contact.getFirstname()
				+ "\nLast Name:" + contact.getLastname());

		return "redirect:contacts.html";
	}

	@RequestMapping("/contacts")
	public ModelAndView showContacts() {

		return new ModelAndView("contact", "command", new Contact());
	}
}