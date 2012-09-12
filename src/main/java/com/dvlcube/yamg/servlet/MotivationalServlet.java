package com.dvlcube.yamg.servlet;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dvlcube.yamg.bean.Motivation;
import com.dvlcube.yamg.service.MotivationalResponse;
import com.dvlcube.yamg.service.MotivationalService;

/**
 * 
 * @author wonka
 * @since 10/09/2012
 */
@Controller
@RequestMapping("/yamg")
public class MotivationalServlet {
	@Autowired
	private MotivationalService service;

	@RequestMapping("/add")
	public @ResponseBody
	MotivationalResponse add(final Motivation motivation) {
		final MotivationalResponse response;
		if (service.add(motivation)) {
			response = new MotivationalResponse(true);
		} else {
			response = new MotivationalResponse(false);
		}
		return response;
	}

	@RequestMapping("/get")
	public @ResponseBody
	Motivation get(final long id) {
		final Motivation motivation = service.get(id);
		return motivation;
	}

	@RequestMapping("/get/json")
	public @ResponseBody
	Motivation getJson(final Motivation motivation) {
		final Motivation response = new Motivation();
		response.setTitle(motivation.getTitle() + "-mod");
		response.setSubtitle(motivation.getSubtitle() + "-mod");
		return response;
	}

	@RequestMapping("/")
	public String index(final Map<String, Object> map) {
		List<Motivation> list = service.list();
		map.put("motivations", list);
		return "yamg/yamg_index";
	}
}
