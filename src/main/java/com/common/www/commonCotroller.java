package com.common.www;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//////
import com.common.www.dto.commonDTO;
import com.common.www.service.commonService;

@Controller
public class commonCotroller {

	@Autowired
	private commonService service;

	@RequestMapping(value = "/test.do", method = RequestMethod.GET)
	public String homeMain(Model model) {

		List<commonDTO> list = service.getstore();
		
		model.addAttribute("list",list);
		
		

		return "test";

	}

}
