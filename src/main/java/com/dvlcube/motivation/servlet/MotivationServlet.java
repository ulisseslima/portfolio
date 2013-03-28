package com.dvlcube.motivation.servlet;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dvlcube.motivation.bean.Motivation;
import com.dvlcube.motivation.service.MotivationService;
import com.dvlcube.motivation.service.Response;
import com.dvlcube.util.CubeList;
import com.dvlcube.util.CubeList.Factory;

/**
 * @author wonka
 * @since 10/09/2012
 */
@Controller
@RequestMapping("/motivation")
public class MotivationServlet {
	private static final String _namespace = "motivation/motivation_";
	private static final String index = _namespace + "index";

	private final CubeList<Motivation> list = new CubeList<>(new Factory<Motivation>() {
		@Override
		public List<Motivation> f(final int start, final int maxResults) {
			return service.list(start, maxResults).getContents();
		}
	});

	@Autowired
	private MotivationService service;

	@RequestMapping("/add")
	public @ResponseBody
	Response<Motivation> add(final Motivation motivation) {
		return service.add(motivation);
	}

	@RequestMapping("/get")
	public @ResponseBody
	Response<Motivation> get(final long id) {
		return service.get(id);
	}

	@RequestMapping("/")
	public String index(final Map<String, Object> map) {
		final Response<Motivation> response = new Response<>(true, list);
		map.put("response", response);
		return index;
	}

	@RequestMapping("/scroll")
	public @ResponseBody
	Response<Motivation> scroll() {
		final Response<Motivation> response = new Response<>(true, list.scroll());
		return response;
	}
}
