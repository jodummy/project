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
import com.common.www.dto.storeDTO;
import com.common.www.dto.goodsDTO;
import com.common.www.dto.commonDTO3;
import com.common.www.service.commonService;

@Controller
public class commonCotroller {

	@Autowired
	private commonService service;

	@RequestMapping(value = "/store.do", method = RequestMethod.GET)
	public String homeMain(Model model) {
		List<storeDTO> list = service.getStore();
		model.addAttribute("list", list);
		return "store";
	}

	@RequestMapping(value = "/insertStore.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String insertStore() {
		return "insertStore";
	}

	@RequestMapping(value = "/insertStorePage.do", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody boolean insertStorePage(storeDTO storeDto, HttpServletRequest req) {

		String storeCode = req.getParameter("storeCode");
		String location = req.getParameter("location");
		String tel = req.getParameter("tel");
		try {
			storeDto.setstoreCode(storeCode);
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
		List<goodsDTO> list = service.getItem();
		model.addAttribute("list", list);

		return "goods";
	}

	@RequestMapping(value = "/insertGoods.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String insertGoods() {
		return "insertGoods";
	}

	@RequestMapping(value = "/insertGoodsPage.do", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody boolean insertUserPage(goodsDTO goodsDto, HttpServletRequest req) {

		String goodsNumber = req.getParameter("goodsNumber");
		String goodsName = req.getParameter("goodsName");
		String price = req.getParameter("price");

		try {
			goodsDto.setGoodsNumber(Integer.parseInt(goodsNumber));
			goodsDto.setGoodsName(goodsName);
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
			@RequestParam(value = "goodsNumber") String value) {
		String goodsNumber = value;
		List<String> arr = arrayParams;

		System.out.println(goodsNumber);
		System.out.println(arr.toString());

		try {
			if (goodsNumber != null && arr.size() < 2)
				service.deleteGoods(Integer.parseInt(goodsNumber));
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
			@RequestParam(value = "storeCode") String value) {
		String storeCode = value;
		List<String> arr = arrayParams;

		System.out.println(storeCode);
		System.out.println(arr.toString());

		try {
			if (storeCode != null && arr.size() < 2) {
				service.deleteStore(storeCode);
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
	public String detailGoods(Model model, String goodsNumber) {
		goodsDTO goodsDto = service.getItemOne(Integer.parseInt(goodsNumber));
		model.addAttribute("dto", goodsDto);
		return "detailGoods";
	}

	@RequestMapping(value = "/detailStore.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String detailStore(Model model, String storeCode) {
		storeDTO StoreDto = service.getStoreOne(storeCode);
		model.addAttribute("dto", StoreDto);

		List<commonDTO3> employeeDto = service.getEmployee(storeCode);
		model.addAttribute("dto2", employeeDto);

		return "detailStore";
	}

	@RequestMapping(value = "/modifyGoods.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyGoods(Model model, String goodsNumber) {
		goodsDTO goodsDto = service.getItemOne(Integer.parseInt(goodsNumber));
		model.addAttribute("dto", goodsDto);
		return "modifyGoods";
	}

	@RequestMapping(value = "/modifyStore.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyStore(Model model, String storeCode) {
		storeDTO storeDto = service.getStoreOne(storeCode);
		model.addAttribute("dto", storeDto);
		return "modifyStore";
	}

	// modifyGoodspage
	@RequestMapping(value = "/modifyGoodspage.do", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody boolean modifyGoodspage(goodsDTO goodsDto, HttpServletRequest req) {
		String goodsName = req.getParameter("goodsName");
		String price = req.getParameter("price");
		String nowStock = req.getParameter("nowStock");
		String soldNum = req.getParameter("soldNum");
		String calorie = req.getParameter("calorie");
		String goodsInfo = req.getParameter("goodsInfo");
		String inputGoods = req.getParameter("inputGoods");
		String outputGoods = req.getParameter("outputGoods");
		try {
			goodsDto.setGoodsName(goodsName);
			goodsDto.setPrice(Integer.parseInt(price));
			goodsDto.setNowStock(Integer.parseInt(nowStock));
			goodsDto.setSoldNum(Integer.parseInt(soldNum));
			goodsDto.setCalorie(Integer.parseInt(calorie));
			goodsDto.setGoodsInfo(goodsInfo);
			goodsDto.setInputGoods(inputGoods);
			goodsDto.setOutputGoods(outputGoods);
			service.updateGoods(goodsDto);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	// 여기 하던주 수정해줘
	@RequestMapping(value = "/modyStorePage.do", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody boolean modyStorePage(storeDTO storeDto, HttpServletRequest req) {
		String location = req.getParameter("location");
		String tel = req.getParameter("tel");
		String income = req.getParameter("income");
		String storeCode = req.getParameter("storeCode");

		try {
			storeDto.setinCome(Integer.parseInt(income));
			storeDto.setLocation(location);
			storeDto.setstoreCode(storeCode);
			storeDto.setTel(tel);
			service.updateStore(storeDto);
			return true;
		} catch (Exception e) {
			e.getMessage();
		}

		return false;
	}

}
