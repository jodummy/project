package com.common.www;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	@RequestMapping(value = "/insertStore.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String insertStore(Model model) {
		return "insertStore";
	}

	@RequestMapping(value = "/insertStorePage.do", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody boolean insertStorePage(Model model, commonDTO storeDto, HttpServletRequest req) {

		String storecode = req.getParameter("storecode");
		String location = req.getParameter("location");
		String tel = req.getParameter("tel");
		try {
			storeDto.setStorecode(storecode);
			storeDto.setLocation(location);
			storeDto.setTel(tel);
			service.insertStore(storeDto);
			return true;
		} catch (Exception e) {
			e.getMessage();
		}
		return false;

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

	@RequestMapping(value = "/deleteStorePage.do", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody boolean deleteStorePage(@RequestParam(value = "checkArray[]") List<String> arrayParams,
			@RequestParam(value = "storecode") String value) {
		String storecode = value;
		List<String> arr = arrayParams;

		System.out.println(storecode);
		System.out.println(arr.toString());

		try {
			if (storecode != null && arr.size() < 2) {
				service.deleteStore(storecode);
			} else {
				for (int i = 0; i < arr.size(); i++) {
					service.deleteStore(arr.get(i));
				}
			}
			return true;
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	@RequestMapping(value = "/detailGoods.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String detailGoods(Model model, String goodsnumber) {
		commonDTO2 goodsDto = service.getItemOne(Integer.parseInt(goodsnumber));
		model.addAttribute("dto", goodsDto);
		return "detailGoods";
	}

	@RequestMapping(value = "/modifyGoods.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyGoods(Model model, String goodsnumber) {
		commonDTO2 goodsDto = service.getItemOne(Integer.parseInt(goodsnumber));
		model.addAttribute("dto", goodsDto);
		return "modifyGoods";
	}

	// modyGoodsPage
	@RequestMapping(value = "/modifyGoodspage.do", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody boolean modifyGoodspage(Model model, commonDTO2 goodsDto, HttpServletRequest req)
			throws ParseException {
		String goodsname = req.getParameter("goodsname");
		String price = req.getParameter("price");
		String nowstock = req.getParameter("nowstock");
		String soldnum = req.getParameter("soldnum");
		String calorie = req.getParameter("calorie");
		String goodsinfo = req.getParameter("goodsinfo");

		// 날짜 오류 잡아야지
//		Date inputgoods = req.getParameter("inputgoods");
//		Date expirationdate = req.getParameter("expirationdate");

//		System.out.println(req.getParameter("inputgoods"));
//		System.out.println(req.getParameter("expirationdate"));
//		System.out.println(transFormat.parse(inputgoods));
//		System.out.println(transFormat.parse(expirationdate));

		try {
			goodsDto.setGoodsname(goodsname);

			goodsDto.setPrice(Integer.parseInt(price));

			goodsDto.setNowstock(Integer.parseInt(nowstock));

			goodsDto.setSoldnum(Integer.parseInt(soldnum));

			goodsDto.setCalorie(Integer.parseInt(calorie));

			goodsDto.setGoodsinfo(goodsinfo);

			service.updateGoods(goodsDto);

//			goodsDto.setInputgoods(inputgoods);

//			goodsDto.setExpirationdate(expirationdate);
			System.out.println("성공인거 같은데");
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.err.println("실패인거 같은데");

		return false;
	}

}
