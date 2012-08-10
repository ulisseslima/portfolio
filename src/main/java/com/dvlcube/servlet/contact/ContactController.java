package com.dvlcube.servlet.contact;

import java.io.IOException;
import java.util.Date;
import java.util.Formatter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dvlcube.bean.Contact;
import com.dvlcube.portfolio.service.ContactService;
import com.dvlcube.servlet.CubeServlet;
import com.dvlcube.servlet.Mapping;

@Controller
@RequestMapping(ContactMapping.ROOT_CONTEXT)
public class ContactController extends CubeServlet {

	@Autowired
	private ContactService contactService;

	@RequestMapping(value = ContactMapping.Add.CONTEXT, method = RequestMethod.POST)
	public String addContact(
		@ModelAttribute(ContactMapping.Add.VAR_CONTACT) final Contact contact,
		final BindingResult result) {
		contactService.addContact(contact);
		return redirectToIndex();
	}

	@RequestMapping(ContactMapping.Delete.CONTEXT)
	public String deleteContact(@PathVariable(ContactMapping.Delete.VAR_CONTACT) final Integer contactId) {
		contactService.removeContact(contactId);
		return redirectToIndex();
	}

	@RequestMapping(ContactMapping.Ajax.CONTEXT)
	public void doAjax(
		final HttpServletResponse response,
		@PathVariable(ContactMapping.Ajax.VAR_MESSAGE) final String message) {
		write(response, "You got %s'd, BIOTCH!", message);
	}

	@RequestMapping("/time")
	public @ResponseBody
	String getTime(@RequestParam final String name) {
		final String result = "Time for " + name + " is " + new Date().toString();
		return result;
	}

	@RequestMapping(ContactMapping.INDEX)
	public String listContacts(final Map<String, Object> map) {
		map.put("contact", new Contact());
		map.put("contactList", contactService.listContact());
		return ContactMapping.View.contact.name();
	}

	/**
	 * @param index
	 * @return
	 * @author wonka
	 * @since 10/08/2012
	 */
	private String redirect(final String view) {
		return Mapping.REDIRECT.concat(ContactMapping.ROOT_CONTEXT.concat(view));
	}

	/**
	 * @return
	 * @author wonka
	 * @since 10/08/2012
	 */
	private String redirectToIndex() {
		return redirect(ContactMapping.INDEX);
	}

	/**
	 * @param response
	 * @throws IOException
	 * @author wonka
	 * @since 10/08/2012
	 */
	private void write(final HttpServletResponse response, final String string, final Object... args) {
		try {
			final String s = new Formatter().format(string, args).toString();
			response.getWriter().write(s);
			System.out.println(s);
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
}