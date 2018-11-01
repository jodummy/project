package com.common.www;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.www.dto.PagingDto;
//////
import com.common.www.dto.commonDTO;
import com.common.www.dto.commonDTO2;
import com.common.www.service.commonService;

@Controller
public class commonCotroller {

	@Autowired
	private commonService service;

	@RequestMapping(value = "/store.do", method = RequestMethod.GET)
	public String homeMain(Model model) {
		List<commonDTO> list = service.getStore();
		model.addAttribute("list", list);
		return "store";
	}

	@RequestMapping(value = "/goods.do", method = RequestMethod.GET)
	public String homeSimple(Model model, PagingDto pagintDto) {
		pagintDto.setTotal(service.selectTotalPaging());
		// paging 넣어야 한다. 그러려면 쿼리 select 부분을 고쳐여 하는데 parameter 부분에 값을 넣어줘야 한다.
		// pagingDto넣어서 start값과 last값을 설정해 준다.
		List<commonDTO2> list = service.getItem();
		model.addAttribute("list", list);
		return "goods";
	}

	@RequestMapping(value = "/insertGoods.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String insertGoods(Model model) {
		return "insertGoods";
	}

	@RequestMapping(value = "/insertGoodsPage.do", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public boolean insertUserPage(Model model, commonDTO2 goodsDto, HttpServletRequest req) {
		boolean isc = false;
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		String goodsnumber = req.getParameter("goodsnumber");
		String goodsname = req.getParameter("goodsname");
		String price = req.getParameter("price");
		goodsDto.setGoodsnumber(Integer.parseInt(goodsnumber));
		goodsDto.setGoodsname(goodsname);
		goodsDto.setPrice(Integer.parseInt(price));
		service.insertGoodsFood(goodsDto);
		return isc;

	}

}
