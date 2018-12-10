package com.common.www;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.www.dto.storeDTO;
import com.common.www.dto.goodsDTO;
import com.common.www.dto.employeeDTO;
import com.common.www.service.commonService;

@Controller
public class commonCotroller {

	@Autowired
	private commonService service;

	@RequestMapping("/NewFile.do")
	public String dashBaord() {
		return "NewFile";
	}

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
	public String homeSimple(Model model, String storeCode, goodsDTO goodsDto) {
		storeDTO StoreDto = service.getStoreOne(storeCode);
		goodsDto.setStoreCode(storeCode);
		List<goodsDTO> list = service.getListGoods(goodsDto);
		model.addAttribute("list", list);
		model.addAttribute("storeCode", storeCode);
		model.addAttribute("inCome", StoreDto.getinCome());
		return "goods";
	}

	@RequestMapping(value = "/insertGoods.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String insertGoods(Model model, HttpServletRequest req) {
		String storeCode = req.getParameter("storeCode");
		model.addAttribute("storeCode", storeCode);
		return "insertGoods";
	}

	@RequestMapping(value = "/insertGoodsPage.do", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody String insertUserPage(goodsDTO goodsDto, HttpServletRequest req) {
		String storeCode = req.getParameter("storeCode");
		String goodsNumber = req.getParameter("goodsNumber");
		String goodsName = req.getParameter("goodsName");
		String price = req.getParameter("price");

		System.out.println(storeCode);
		System.out.println(goodsNumber);
		System.out.println(goodsName);
		System.out.println(price);

		try {
			goodsDto.setGoodsName(storeCode);
			goodsDto.setGoodsNumber(Integer.parseInt(goodsNumber));
			goodsDto.setGoodsName(goodsName);
			goodsDto.setPrice(Integer.parseInt(price));
			service.insertGoodsFood(goodsDto);
			return "goods?&storeCode" + storeCode;
		} catch (Exception e) {
			e.getMessage();
		}

		return "goods?&storeCode" + storeCode;

	}

	@RequestMapping(value = "/detailGoods.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String detailGoods(Model model, HttpServletRequest req, goodsDTO goodsdto) {
		String goodsNumber = req.getParameter("goodsNumber");
		String storeCode = req.getParameter("storeCode");
		model.addAttribute("storeCode", storeCode);
		goodsdto.setGoodsNumber(Integer.parseInt(goodsNumber));
		goodsdto.setStoreCode(storeCode);
		goodsDTO goodsDto = service.getItemOne(goodsdto);
		model.addAttribute("dto", goodsDto);
		return "detailGoods";
	}

	@RequestMapping(value = "/detailStore.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String detailStore(Model model, String storeCode) {
		storeDTO StoreDto = service.getStoreOne(storeCode);
		model.addAttribute("dto", StoreDto);

		List<employeeDTO> employeeDto = service.getEmployee(storeCode);
		model.addAttribute("dto2", employeeDto);

		return "detailStore";
	}

	@RequestMapping(value = "/modifyGoods.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyGoods(Model model, HttpServletRequest req, goodsDTO goodsdto) {
		String goodsNumber = req.getParameter("goodsNumber");
		String storeCode = req.getParameter("storeCode");
		goodsdto.setGoodsNumber(Integer.parseInt(goodsNumber));
		goodsdto.setStoreCode(storeCode);
		goodsDTO goodsDto = service.getItemOne(goodsdto);
		model.addAttribute("dto", goodsDto);
		model.addAttribute("storeCode", storeCode);
		return "modifyGoods";
	}

	// modifyGoodspage
	@RequestMapping(value = "/modifyGoodspage.do", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody boolean modifyGoodspage(goodsDTO goodsDto, HttpServletRequest req) {
		String outputGoods = req.getParameter("outputGoods");
		System.out.println(outputGoods);
		try {
			goodsDto.setGoodsName(req.getParameter("goodsName"));
			goodsDto.setPrice(Integer.parseInt(req.getParameter("price")));
			goodsDto.setNowStock(Integer.parseInt(req.getParameter("nowStock")));
			goodsDto.setSoldNum(Integer.parseInt(req.getParameter("soldNum")));
			goodsDto.setCalorie(Integer.parseInt(req.getParameter("calorie")));
			goodsDto.setGoodsInfo(req.getParameter("goodsInfo"));
			goodsDto.setInputGoods(req.getParameter("inputGoods"));
			goodsDto.setOutputGoods(req.getParameter("outputGoods"));
			goodsDto.setStoreCode(req.getParameter("storeCode"));
			goodsDto.setGoodsNumber(Integer.parseInt(req.getParameter("goodsNumber")));
			service.updateGoods(goodsDto);
			return true;
		} catch (Exception e) {
			System.out.println("실패야 뭘 물어: " + e.getMessage());
		}
		return false;
	}

	@RequestMapping(value = "/modifyStore.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyStore(Model model, String storeCode) {
		storeDTO storeDto = service.getStoreOne(storeCode);
		model.addAttribute("dto", storeDto);
		return "modifyStore";
	}

	@RequestMapping(value = "/modyStorePage.do", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody boolean modyStorePage(storeDTO storeDto, HttpServletRequest req) {
//		String location = req.getParameter("location");
//		String tel = req.getParameter("tel");
//		String income = req.getParameter("income");
//		String storeCode = req.getParameter("storeCode");

		try {
			storeDto.setinCome(Integer.parseInt(req.getParameter("income")));
			storeDto.setLocation(req.getParameter("location"));
			storeDto.setstoreCode(req.getParameter("storeCode"));
			storeDto.setTel(req.getParameter("tel"));
			service.updateStore(storeDto);
			return true;
		} catch (Exception e) {
			e.getMessage();
		}

		return false;
	}

	// insertEmployee
	@RequestMapping(value = "/insertEmployee.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String insertEmployee(Model model, HttpServletRequest req) {
		String storeCode = req.getParameter("storeCode");
		model.addAttribute("storeCode", storeCode);
		return "insertEmployee";
	}

	@RequestMapping(value = "/insertEmployeePage.do", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody boolean insertEmployeePage(employeeDTO employeeDTO, HttpServletRequest req) {

		String storeCode = req.getParameter("storeCode");
		String manager = req.getParameter("manager");
		String phone = req.getParameter("phone");
		String seqTime = req.getParameter("seqTime");

//		System.out.println(storeCode + manager + phone + seqTime);

		try {
			employeeDTO.setStoreCode(storeCode);
			employeeDTO.setManager(manager);
			employeeDTO.setPhone(phone);
			employeeDTO.setSeqTime(Integer.parseInt(seqTime));
			service.insertEmployee(employeeDTO);
			return true;
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	@RequestMapping(value = "/deleteEmployeePage.do", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody boolean deleteEmployeePage(@RequestParam(value = "checkArray[]") List<String> arrayParams,
			@RequestParam(value = "phone") String value) {
		String phone = value;
		List<String> arr = arrayParams;

		System.out.println(phone);
		System.out.println(arr.toString());

		try {
			if (phone != null && arr.size() < 2) {
				service.deleteEmployee(phone);
			} else {
				for (int i = 0; i < arr.size(); i++) {
					service.deleteEmployee(arr.get(i));
				}
			}
			return true;
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	@RequestMapping(value = "/deleteGoodsPage", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody boolean deleteGoodsPage(@RequestParam(value = "checkArray[]") List<String> arrayParams,
			@RequestParam(value = "goodsnumber") String value, @RequestParam(value = "storeCode") String value2,
			goodsDTO goodsDto) {
		String storeCode = value2;
		String goodsNumber = value;
		List<String> arr = arrayParams;

		System.out.println(storeCode);
		System.out.println(goodsNumber);

		goodsDto.setStoreCode(storeCode);

		try {
			if (goodsNumber != null && arr.size() < 2) {

				goodsDto.setGoodsNumber(Integer.parseInt(goodsNumber));
				service.deleteGoods(goodsDto);
			} else
				for (int i = 0; i < arr.size(); i++) {
					goodsDto.setGoodsNumber(Integer.parseInt(arr.get(i)));
					service.deleteGoods(goodsDto);
				}

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

	// basketMovePage
	@RequestMapping(value = "/basketMovePage.do", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody boolean basketMovePage(@RequestParam(value = "goodsnumber") String value,
			@RequestParam(value = "nowStock") String value2, @RequestParam(value = "storeCode") String value3,
			goodsDTO goodsDto) {
		int goodsnumber = Integer.parseInt(value);
		int nowStock = Integer.parseInt(value2);
		String storeCode = value3;

		System.out.println(goodsnumber);
		System.out.println(nowStock);
		System.out.println(storeCode);

		goodsDto.setGoodsNumber(Integer.parseInt(value));
		goodsDto.setNowStock(Integer.parseInt(value2));
		goodsDto.setStoreCode(value3);

		try {
			// 트랜젝션 처리 부분
			service.updateIncomeTotal(goodsDto);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

}
