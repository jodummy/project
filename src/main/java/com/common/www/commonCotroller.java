package com.common.www;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
//		pagintDto.setTotal(service.selectTotalPaging());
		List<commonDTO2> list = service.getItem();
		model.addAttribute("list", list);
		return "goods";
	}

	@RequestMapping(value = "/insertGoods.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String insertGoods(Model model) {
		return "insertGoods";
	}

	@RequestMapping(value = "/insertGoodsPage.do", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody boolean insertUserPage(Model model, commonDTO2 goodsDto, HttpServletRequest req) {

		String goodsnumber = req.getParameter("goodsnumber");
		String goodsname = req.getParameter("goodsname");
		String price = req.getParameter("price");

		try {
			goodsDto.setGoodsnumber(Integer.parseInt(goodsnumber));
			goodsDto.setGoodsname(goodsname);
			goodsDto.setPrice(Integer.parseInt(price));
			service.insertGoodsFood(goodsDto);
			return true;
		} catch (Exception e) {
			e.getMessage();
		}

		return false;

	}

	@RequestMapping(value = "/deleteGoodsPage.do", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody boolean deleteGoodsPage(@RequestParam(value = "checkArray[]") List<String> arrayParams,
			@RequestParam(value = "goodsnumber") String value) {
		String goodsnumber = value;
		List<String> arr = arrayParams;

		System.out.println(goodsnumber);
		System.out.println(arr.toString());

		try {
			if (goodsnumber != null && arr.size() < 2)
				service.deleteGoods(Integer.parseInt(goodsnumber));
			else
				for (int i = 0; i < arr.size(); i++)
					service.deleteGoods(Integer.parseInt(arr.get(i)));

			return true;
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	// goodsnumber 값을 가져와 처리한다. hidden으로 값을 숨겨서 값을 넘김다
	// 페이지 구현 하지 않음 페이지 구현 해줘
	@RequestMapping(value = "/updateGoods.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateGoods(Model model, int goodsnumber) {
		System.err.println(goodsnumber);
		commonDTO2 goodsDto = service.getItemOne(goodsnumber);
		return "updateGoods";
	}

	@RequestMapping(value = "/updateGoodPage.do", method = { RequestMethod.GET, RequestMethod.POST })
	public boolean updateGoodPage(commonDTO2 goodsDto, HttpServletRequest req) {

		return false;
	}

}
